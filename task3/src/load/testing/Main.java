package load.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу:");
        String path = reader.readLine();
        System.out.println("Введите начало периода:");
        String start = reader.readLine();
        System.out.println("Введите конец периода:");
        String finish = reader.readLine();
        ReadData.read(path);
        int volume = ReadData.volume;
        int fullness = ReadData.fullness;
        int in=0;
        int inTrue=0;
        int out=0;
        int outTrue=0;
        int inWater=0;
        int outWater=0;
        int inWaterFalse=0;
        int outWaterFalse=0;
            for (int i = 0; i<ReadData.water.size(); i++){
                Date data = ReadData.dates.get(i+2);
                Integer value = ReadData.water.get(i);
                    if (value>=0){
                        in++;
                        if (value+fullness<=volume){
                            inTrue++;
                            inWater=inWater+value;
                            fullness = fullness + value;}
                        else {inWaterFalse=inWaterFalse+value;}
                    } else {
                        out++;
                        if (fullness+value>0){
                            outTrue++;
                            outWater = outWater + value;
                            fullness = fullness + value;}
                        else {outWaterFalse=outWaterFalse+value;}
                    }
        }
            double errIn = 100*((double)in-inTrue)/in;
            String errInStr = String.format("%.2f", errIn);
            double errOut = 100*((double)out-outTrue)/out;
            String errOutStr = String.format("%.2f", errOut);


            System.out.println("Количество попыток налить воду в бочку было за указанный период: " + in);
            System.out.println("Процент ошибок за указанный период при наливании воды в бочку: " + errInStr + "%");
            System.out.println("Объем воды, налитый в бочку за указанный период: " + inWater);
            System.out.println("Объем воды, не налитый в бочку за указанный период: " + inWaterFalse);

            System.out.println("Количество попыток вылить воду из бочки было за указанный период: " + out);
            System.out.println("Процент ошибок за указанный период при выливании воды из бочки: " + errOutStr + "%");
            System.out.println("Объем воды, вылитый из бочки за указанный период: " + outWater);
            System.out.println("Объем воды, не вылитый из бочки за указанный период: " + outWaterFalse);

            System.out.println("Объем воды в бочке в начале указанного периода "+ReadData.fullness);
            System.out.println("Объем воды в бочке в конце указанного периода "+ fullness);
    }
}
