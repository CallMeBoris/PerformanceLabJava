package load.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первую строку");
        String firstWord = reader.readLine();
        System.out.println("Введите вторую строку");
        String secondWord = reader.readLine();
        reader.close();
        //разбиваем вторую строку на отдельные символы
        String[] array = secondWord.split("");
        String secondWordSecond="";
        //если символ является *, то перед ним ставим точку
        for (String s: array){
            if (s.equals("*")){s=".*";}
            secondWordSecond=secondWordSecond+s;
        }
        //сравниваем строки через паттерны
        if (Pattern.matches(secondWordSecond,firstWord)){
            System.out.println("OK");
        }else {System.out.println("KO");}
    }
}
