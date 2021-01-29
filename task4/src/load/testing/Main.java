package load.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первое число");
        String firstWord = reader.readLine();
        System.out.println("Введите второе число");
        String secondWord = reader.readLine();
        reader.close();
        String[] array = secondWord.split("");
        String secondWordSecond="";
        for (String s: array){
            if (s.equals("*")){s=".*";}
            secondWordSecond=secondWordSecond+s;
        }
        if (Pattern.matches(secondWordSecond,firstWord)){
            System.out.println("OK");
        }else {System.out.println("KO");}
    }
}
