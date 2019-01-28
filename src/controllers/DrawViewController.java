package controllers;

import model.timer.TimeCounter;

public class DrawViewController {
    TimeCounter timeCounter;

    public DrawViewController(TimeCounter timeCounter) {
        this.timeCounter = new TimeCounter(this, 2);
        System.err.println("Seconds setting is not implemented");
    }
}
