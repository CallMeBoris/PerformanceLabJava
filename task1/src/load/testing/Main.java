package load.testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args){
        System.out.println("Введите через пробел число и нужную систему исчисления:");
            try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        String[] array = data.split(" ");

        if (array.length==2){System.out.println(itoBase(Integer.parseInt(array[0]),array[1]));}
        else if (array.length==3){System.out.println(itoBase(array[0],array[1],array[2]));}
            }catch (Exception e){System.out.println("usage");}
    }

    private static String itoBase(int nb, String base) throws Exception {
        int baseInt;
        try {
         baseInt= Integer.parseInt(base);
        }catch (NumberFormatException e){baseInt=BaseNumber.getBaseNumber(base);}
        if (baseInt > 36){throw new Exception();}
        String number = "";
        while (nb>=baseInt){
            int num = nb%baseInt;
            nb = nb/baseInt;
            if (num>9){number=number+Letter.getLetter(num);}
                else {number=number+num;}
        }
        if (nb>9){number=number+Letter.getLetter(nb);}
        else {number=number+nb;}
        StringBuilder builder = new StringBuilder(number);
        builder.reverse();
        return builder.toString();
    }

    private static String itoBase(String nb, String baseSrc, String baseDst){
        return null;
    }
}
