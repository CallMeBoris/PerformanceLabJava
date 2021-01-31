package load.testing;

class QuadraticEquation {
    static void solution(double x0, double x1, double y0, double y1, double z0, double z1, double xs, double ys, double zs, double radius){
        double t1;
        double t2;
        double xFirst;
        double yFirst;
        double zFirst;
        double xSecond;
        double ySecond;
        double zSecond;

        //из параметрических уравнений прямой и сферы было получено квадратное уравнение типа a*t^2+b*t+c=0
        //ниже представлен расчет значений a, b, c и дискриминанта
        double a = (x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0);
        double b = 2*((x1-x0)*(x0-xs)+(y1-y0)*(y0-ys)+(z1-z0)*(z0-zs));
        double c = (x0-xs)*(x0-xs)+(y0-ys)*(y0-ys)+(z0-zs)*(z0-zs)-radius*radius;
        double d = b*b-4*a*c;

        //если дискриминант < 0, то корней нет
        if (d<0){System.out.println("Коллизий не найдено");}

        //если равен нулю, то есть один корень. Вычисляем его, подставляем в уравнения и находим координаты
        else if (d==0){
            t1 = -b/(2*a);
            xFirst = x0+(x1-x0)*t1;
            yFirst = y0+(y1-y0)*t1;
            zFirst = z0+(z1-z0)*t1;
            System.out.println("Координаты точки пересечения: x = "+xFirst+"; y = "+yFirst+"; z = "+zFirst);
        }else {
            //если больше нуля, то кореня два. Вычисляем их, подставляем в уравнения и находим координаты
        t1 = (-b+Math.sqrt(d))/(2*a);
        t2 = (-b-Math.sqrt(d))/(2*a);
            xFirst = x0+(x1-x0)*t1;
            yFirst = y0+(y1-y0)*t1;
            zFirst = z0+(z1-z0)*t1;
            xSecond = x0+(x1-x0)*t2;
            ySecond = y0+(y1-y0)*t2;
            zSecond = z0+(z1-z0)*t2;
            System.out.println("Координаты первой точки пересечения: x = "+xFirst+"; y = "+yFirst+"; z = "+zFirst);
            System.out.println("Координаты второй точки пересечения: x = "+xSecond+"; y = "+ySecond+"; z = "+zSecond);
        }
    }
}
