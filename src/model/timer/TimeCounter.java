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
    static int period = 500;
    int timeLeft = 0;

    public TimeCounter(DrawViewController drawViewController, int seconds, int numberOfReps) {
        timeToChangeImage = seconds*1000;
        this.drawViewController = drawViewController;
        this.numberOfReps = numberOfReps;
        timer = new Timer();
       // timer2 = new Timer();
        timer.scheduleAtFixedRate(new ChangeImgTask(), 100, period);
        //timer2.scheduleAtFixedRate(new ChangeTimeLabelTask(), 0, period);
        timeLeft=timeToChangeImage;

    }

    public void resetTimer(){
        timeLeft=timeToChangeImage;
    }

    public void runAgain(){
        timer=new Timer();
        timer.scheduleAtFixedRate(new ChangeImgTask(), 100, period);
        timeLeft = timeToChangeImage;
    }

    public void stop(){
        timer.cancel();
    }

    class ChangeImgTask extends TimerTask {
        public void run() {
            timeLeft-=period;
            Platform.runLater(()->drawViewController.changeTimeLabel(secondsToString(Math.min(timeToChangeImage/1000,(timeLeft+1000)/1000))));

            if(timeLeft<=0){
                if(numberOfReps>0)
                    numberOfReps--;
                if(numberOfReps<=0){
                    timer.cancel();
                    Platform.runLater(()->drawViewController.finishClass());
                }
                Platform.runLater(()->drawViewController.changeImage(1));
                System.out.format("Changing IMAGE :3");

                timeLeft = timeToChangeImage;
                Platform.runLater(()->drawViewController.setQuantityLeftLabel(numberOfReps));
            }

        }

        private String secondsToString(int pTime) {
            return String.format("%02d:%02d", pTime / 60, pTime % 60);
        }
    }




}
