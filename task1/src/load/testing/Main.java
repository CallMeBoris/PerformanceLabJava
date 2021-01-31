package load.testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args){
        System.out.println("Введите через пробел число и нужную систему исчисления или число," +
                " его систему исчисления и нужную систему исчисления:");
            try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        reader.close();
        String[] array = data.split(" ");
        //если введенных значений два, то вызывается первый метод, если три, то перегруженный
        if (array.length==2){System.out.println(itoBase(Integer.parseInt(array[0]),array[1]));}
        else if (array.length==3){System.out.println(itoBase(array[0],array[1],array[2]));}
        else {System.out.println("usage");}
            }catch (Exception e){System.out.println("usage");}
    }

    private static String itoBase(int nb, String base) throws Exception {
        int baseInt;
        //переводим основание в int
        try {
         baseInt= Integer.parseInt(base);
        }catch (NumberFormatException e){baseInt=BaseNumber.getBaseNumber(base);}
        if (baseInt > 36){throw new Exception();}
        String number = "";
        //делим число на оснвание и записываем остаток от деления в строку
        while (nb>=baseInt){
            int num = nb%baseInt;
            nb = nb/baseInt;
            //если число больше 9, то записываем его как букву
            if (num>9){number=number+Letter.getLetter(num);}
                else {number=number+num;}
        }
        //дописываем последний остаток от деления
        if (nb>9){number=number+Letter.getLetter(nb);}
        else {number=number+nb;}
        StringBuilder builder = new StringBuilder(number);
        //разворачиваем строку
        builder.reverse();
        return builder.toString();
    }

    private static String itoBase(String nb, String baseSrc, String baseDst) throws Exception {
        int baseIntSrc;
        //переводим основание в int
        try {
            baseIntSrc= Integer.parseInt(baseSrc);}catch (NumberFormatException e){
            baseIntSrc=BaseNumber.getBaseNumber(baseSrc);}
        //переводим полученное значение в массив символов
        String[] numbers = nb.split("");
        int number = 0;
        //в цикле переводим число в десятичную систему счисления
        for (int i = 0; i < numbers.length; i++){
            int a;
            try{a = Integer.parseInt(numbers[i]);}catch (NumberFormatException  e){a=Letter.getNumber(numbers[i]);}
            if (a==37||a>baseIntSrc){throw new Exception();}
            number = number+ (int) (a*Math.pow(baseIntSrc,numbers.length-i-1));
        }
        //передаем число в десятичной системе и нужную систему счисления в другой метод
        return itoBase(number,baseDst);
    }
}
