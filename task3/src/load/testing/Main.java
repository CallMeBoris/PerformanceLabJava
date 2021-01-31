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
        String path;
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
                ReadData.read(path);//чтение файла и запись требуемых значений
                reader.close();
            } catch (IOException|ParseException e){System.out.println("usage");}

            int volume = ReadData.volume;
            int fullness = ReadData.fullness;
            //обход листа, содержащего историю взаимодействия с водой в бочке
            for (int i = 0; i<ReadData.water.size(); i++) {
                Date data = ReadData.dates.get(i + 2);
                //проверка на нахождение даты в заданном промежутке
                if (data.after(dateStart) && data.before(dateFinish)){
                    Integer value = ReadData.water.get(i);
                    //вычисление значений при попытке налить воду
                if (value >= 0) {
                    //увеличение значения попыток
                    in++;
                    if (value + fullness <= volume) {
                        //увеличение значения удавшихся попыток
                        inTrue++;
                        //расчет значения суммарно налитого объема
                        inWater = inWater + value;
                        //расчет заполненности бочки
                        fullness = fullness + value;
                    } else {
                        //расчет значения объема воды, кторый не получилось налить в бочку
                        inWaterFalse = inWaterFalse + value;
                    }
                    //вычисление значений при попытке вычерпнуть воду
                } else {
                    //увеличение значения попыток
                    out++;
                    if (fullness + value > 0) {
                        //увеличение значения удавшихся попыток
                        outTrue++;
                        //расчет значения суммарно вычерпанного объема
                        outWater = outWater + value;
                        //расчет заполненности бочки
                        fullness = fullness + value;
                    } else {
                        //расчет значения объема воды, кторый не получилось вычерпать из бочки
                        outWaterFalse = outWaterFalse + value;
                    }
                }
            }
        }
            //расчет процентов ошибок
            double errIn = 100*((double)in-inTrue)/in;
            String errInStr = String.format("%.2f", errIn);
            double errOut = 100*((double)out-outTrue)/out;
            String errOutStr = String.format("%.2f", errOut);

            //создание .csv файла и запись в него значений
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("data2.csv"));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Количество попыток налить воду в бочку было за указанный период"
                        ,"Процент ошибок за указанный период при наливании воды в бочку","Объем воды, налитый в бочку за указанный период"
                        ,"Объем воды, не налитый в бочку за указанный период","Количество попыток вылить воду из бочки было за указанный период"
                        ,"Процент ошибок за указанный период при выливании воды из бочки","Объем воды, вылитый из бочки за указанный период"
                        ,"Объем воды, не вылитый из бочки за указанный период","Объем воды в бочке в начале указанного периода"
                        ,"Объем воды в бочке в конце указанного периода"))
        ) {
            csvPrinter.printRecord(in, errInStr + "%", inWater, inWaterFalse, out, errOutStr + "%", Math.abs(outWater)
                    , Math.abs(outWaterFalse), ReadData.fullness, fullness);
            csvPrinter.flush();
        }
    }
}
