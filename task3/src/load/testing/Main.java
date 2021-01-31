package load.testing;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Main {
    public static void main(String[] args) throws IOException {
        String path ="";
        Date dateStart = null;
        Date dateFinish = null;
        int in=0;
        int inTrue=0;
        int out=0;
        int outTrue=0;
        int inWater=0;
        int outWater=0;
        int inWaterFalse=0;
        int outWaterFalse=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу:");
            try{path = reader.readLine();
                System.out.println("Введите начало периода:");
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.ENGLISH);
                String start = reader.readLine();
                dateStart = format.parse(start);
                System.out.println("Введите конец периода:");
                String finish = reader.readLine();
                dateFinish = format.parse(finish);
                ReadData.read(path);
                reader.close();
            } catch (IOException|ParseException e){System.out.println("usage");}

            int volume = ReadData.volume;
            int fullness = ReadData.fullness;
            for (int i = 0; i<ReadData.water.size(); i++) {
                Date data = ReadData.dates.get(i + 2);
                if (data.after(dateStart) && data.before(dateFinish)){
                    Integer value = ReadData.water.get(i);
                if (value >= 0) {
                    in++;
                    if (value + fullness <= volume) {
                        inTrue++;
                        inWater = inWater + value;
                        fullness = fullness + value;
                    } else {
                        inWaterFalse = inWaterFalse + value;
                    }
                } else {
                    out++;
                    if (fullness + value > 0) {
                        outTrue++;
                        outWater = outWater + value;
                        fullness = fullness + value;
                    } else {
                        outWaterFalse = outWaterFalse + value;
                    }
                }
            }
        }
            double errIn = 100*((double)in-inTrue)/in;
            String errInStr = String.format("%.2f", errIn);
            double errOut = 100*((double)out-outTrue)/out;
            String errOutStr = String.format("%.2f", errOut);

        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("data.csv"));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Количество попыток налить воду в бочку было за указанный период"
                        ,"Процент ошибок за указанный период при наливании воды в бочку","Объем воды, налитый в бочку за указанный период"
                        ,"Объем воды, не налитый в бочку за указанный период","Количество попыток вылить воду из бочки было за указанный период"
                        ,"Процент ошибок за указанный период при выливании воды из бочки","Объем воды, вылитый из бочки за указанный период"
                        ,"Объем воды, не вылитый из бочки за указанный период","Объем воды в бочке в начале указанного периода"
                        ,"Объем воды в бочке в конце указанного периода"));
        ) {
            csvPrinter.printRecord(in, errInStr + "%", inWater, inWaterFalse, out, errOutStr + "%", Math.abs(outWater)
                    , Math.abs(outWaterFalse), ReadData.fullness, fullness);
            csvPrinter.flush();
        }
    }
}
