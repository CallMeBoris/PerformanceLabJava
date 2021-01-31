package load.testing;

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class CreateLogFile {
        //создание требуемого .log файла
    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        try {
            fh = new FileHandler("MyLogFile2.log");
            logger.addHandler(fh);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int volume = 200;
        int currentVolume = 32;
        logger.info(String.valueOf(volume));
        logger.info(String.valueOf(currentVolume));
        Random r = new Random();
        int low = -100;
        int high = 100;
        for (int i = 0; i<5000; i++){
            int n = r.nextInt(high-low) + low;
            if (n>=0){logger.info("somebody"+i+" wanna top up "+n+"l");}
            else {logger.info("somebody"+i+" wanna scoop "+Math.abs(n)+"l");}
            Thread.sleep(350);
        }
    }
}
