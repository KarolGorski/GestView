package model.timer;

import controllers.DrawViewController;

import java.util.TimerTask;
import java.util.Timer;

public class TimeCounter {

    Timer timer;
    static int timeToChangeImage=2;
    static DrawViewController drawViewController;

    public TimeCounter(DrawViewController drawViewController, int seconds) {
        timeToChangeImage = seconds;
        this.drawViewController = drawViewController;
        timer = new Timer();
        timer.schedule(new ChangeImgTask(), timeToChangeImage*1000);
    }

    class ChangeImgTask extends TimerTask {
        public void run() {
            System.out.format("Changing IMAGE :3");
            timer.cancel();
        }
    }

    public static void runTimer(){
        new TimeCounter(drawViewController, timeToChangeImage);
        System.out.format("Task scheduled.%n");
    }
}
