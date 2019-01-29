package model.timer;

import com.sun.org.glassfish.gmbal.ManagedObject;
import controllers.DrawViewController;
import javafx.application.Platform;

import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class TimeCounter{

    Timer timer, timer2;
    static int timeToChangeImage=2;
    static DrawViewController drawViewController;
    static int numberOfReps=5;

    static int delay = 1000;
    static int period = 1000;
    int timeLeft = 0;

    public TimeCounter(DrawViewController drawViewController, int seconds, int numberOfReps) {
        timeToChangeImage = seconds;
        this.drawViewController = drawViewController;
        this.numberOfReps = numberOfReps;
        timer = new Timer();
        timer2 = new Timer();
        timer.scheduleAtFixedRate(new ChangeImgTask(), 0, timeToChangeImage*1000);
        timer2.scheduleAtFixedRate(new ChangeTimeLabelTask(), 0, period);
        timeLeft=timeToChangeImage;

    }

    class ChangeImgTask extends TimerTask {
        public void run() {
            Platform.runLater(()->drawViewController.changeImage(1));
            System.out.format("Changing IMAGE :3");
            numberOfReps--;
            if(numberOfReps<=0)
                timer.cancel();
            timeLeft = timeToChangeImage;

        }
    }

    class ChangeTimeLabelTask extends TimerTask{
        public void run(){
            timeLeft--;
            Platform.runLater(()->drawViewController.changeTimeLabel(secondsToString(timeLeft)));
            if(numberOfReps<=0)
                timer2.cancel();
        }

        private String secondsToString(int pTime) {
            return String.format("%02d:%02d", pTime / 60, pTime % 60);
        }
    }


}
