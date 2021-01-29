package load.testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        double[] centerCircle = new double[3];
        double radius;
        double[] firstPoint = new double[3];
        double[] secondPoint = new double[3];
        String line = "";

        try {BufferedReader readPath = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите путь к файлу");
             String inputFileName = readPath.readLine();
             BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             line = reader.readLine();
             reader.close();
             readPath.close();
        }
        catch (IOException e) {
            e.printStackTrace();}

        String[] info = line.split(" ");

        if (info[0].contains("sphere")){
            if (info[1].contains("center")){
                centerCircle[0] = Double.parseDouble(info[2].substring(1,info[2].length()-1));
                centerCircle[1] = Double.parseDouble(info[3].substring(0,info[3].length()-1));
                centerCircle[2] = Double.parseDouble(info[4].substring(0,info[4].length()-2));
                radius=Double.parseDouble(info[6].substring(0,info[6].length()-2));
                firstPoint[0] = Double.parseDouble(info[8].substring(2,info[8].length()-1));
                firstPoint[1] = Double.parseDouble(info[9].substring(0,info[9].length()-1));
                firstPoint[2] = Double.parseDouble(info[10].substring(0,info[10].length()-2));
                secondPoint[0] = Double.parseDouble(info[11].substring(1,info[11].length()-1));
                secondPoint[1] = Double.parseDouble(info[12].substring(0,info[12].length()-1));
                secondPoint[2] = Double.parseDouble(info[13].substring(0,info[13].length()-3));
            }else {
                radius=Double.parseDouble(info[2].substring(0,info[2].length()-1));
                centerCircle[0] = Double.parseDouble(info[4].substring(1,info[4].length()-1));
                centerCircle[1] = Double.parseDouble(info[5].substring(0,info[5].length()-1));
                centerCircle[2] = Double.parseDouble(info[6].substring(0,info[6].length()-3));
                firstPoint[0] = Double.parseDouble(info[8].substring(2,info[8].length()-1));
                firstPoint[1] = Double.parseDouble(info[9].substring(0,info[9].length()-1));
                firstPoint[2] = Double.parseDouble(info[10].substring(0,info[10].length()-2));
                secondPoint[0] = Double.parseDouble(info[11].substring(1,info[11].length()-1));
                secondPoint[1] = Double.parseDouble(info[12].substring(0,info[12].length()-1));
                secondPoint[2] = Double.parseDouble(info[13].substring(0,info[13].length()-3));
            }
        }else {
            if (info[8].contains("center")){
                firstPoint[0] = Double.parseDouble(info[1].substring(2,info[1].length()-1));
                firstPoint[1] = Double.parseDouble(info[2].substring(0,info[2].length()-1));
                firstPoint[2] = Double.parseDouble(info[3].substring(0,info[3].length()-2));
                secondPoint[0] = Double.parseDouble(info[4].substring(1,info[4].length()-1));
                secondPoint[1] = Double.parseDouble(info[5].substring(0,info[5].length()-1));
                secondPoint[2] = Double.parseDouble(info[6].substring(0,info[6].length()-3));
                centerCircle[0] = Double.parseDouble(info[9].substring(1,info[9].length()-1));
                centerCircle[1] = Double.parseDouble(info[10].substring(0,info[10].length()-1));
                centerCircle[2] = Double.parseDouble(info[11].substring(0,info[11].length()-2));
                radius=Double.parseDouble(info[13].substring(0,info[13].length()-2));
            }else {
                firstPoint[0] = Double.parseDouble(info[1].substring(2,info[1].length()-1));
                firstPoint[1] = Double.parseDouble(info[2].substring(0,info[2].length()-1));
                firstPoint[2] = Double.parseDouble(info[3].substring(0,info[3].length()-2));
                secondPoint[0] = Double.parseDouble(info[4].substring(1,info[4].length()-1));
                secondPoint[1] = Double.parseDouble(info[5].substring(0,info[5].length()-1));
                secondPoint[2] = Double.parseDouble(info[6].substring(0,info[6].length()-3));
                radius=Double.parseDouble(info[9].substring(0,info[9].length()-1));
                centerCircle[0] = Double.parseDouble(info[11].substring(1,info[11].length()-1));
                centerCircle[1] = Double.parseDouble(info[12].substring(0,info[12].length()-1));
                centerCircle[2] = Double.parseDouble(info[13].substring(0,info[13].length()-3));
            }
        }
        QuadraticEquation.solution(firstPoint[0],secondPoint[0],
                firstPoint[1],secondPoint[1],
                firstPoint[2],secondPoint[2],
                centerCircle[0],centerCircle[1],centerCircle[2],radius);
    }
}

