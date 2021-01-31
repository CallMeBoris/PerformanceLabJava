package load.testing;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//преобразование значений .log файла для дальнейшей работы
 class ReadData {
     //создание двух ArrayList-ов для хранения события и даты его происхождения
    static ArrayList<Integer> water = new ArrayList<>();
    static ArrayList<Date> dates = new ArrayList<>();
    //хранение значений объёма бочки и её заполненности
    static int volume;
    static int fullness;
    static void read(String filename) throws IOException, ParseException {
        File file = new File(filename);
        BufferedReader reader = new BufferedReader( new FileReader(file));
        String line;
        ArrayList<Integer> volful = new ArrayList<>(2);
        //создание паттернов для поиска требуемых значений
        Pattern patternMessage = Pattern.compile("<message>.*</message>");
        Pattern patternDate = Pattern.compile("<date>.*</date>");
        //чтение файла
        while( ( line = reader.readLine() ) != null ) {
            Matcher matcherMessage = patternMessage.matcher(line);
            Matcher matcherDate = patternDate.matcher(line);

            //поиск сообщений о событии и запись их в лист
            if (matcherMessage.find()){
                String message = matcherMessage.group();
                String[] mes = message.split(" ");
                int liters;
                try{
                    liters = Integer.parseInt(mes[mes.length-1].substring(0,mes[mes.length-1].length()-11));
                    }catch (NumberFormatException e){
                    liters = Integer.parseInt(mes[mes.length-1].substring(9,mes[mes.length-1].length()-10));
                    volful.add(liters);
                }
                if (mes.length==5){water.add(liters);}
                else if (mes.length==4){water.add(-1*liters);}
            }

            ///поиск даты и запись её в соответствующий лист
            if (matcherDate.find()){
                String dateString = matcherDate.group();
                dateString = dateString.substring(6,dateString.length()-7);
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.ENGLISH);
                Date date = format.parse(dateString);
                dates.add(date);
            }
        }
        //запись объёмов
        volume=volful.get(0);
        fullness=volful.get(1);
        reader.close();
    }
}