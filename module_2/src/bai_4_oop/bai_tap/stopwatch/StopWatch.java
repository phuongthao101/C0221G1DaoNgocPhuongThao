package bai_4_oop.bai_tap.stopwatch;

public class StopWatch {
    private double startTime;
    private double endTime;


    public StopWatch(double startTime, double endTime) {
        this.startTime = startTime;
        this.endTime = endTime;

    }
    public StopWatch() {

    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double start() {
        startTime = System.currentTimeMillis();
        return startTime;
    }


   public double stop() {
        endTime = System.currentTimeMillis();
        return endTime;
    }
     public double getElapsedTime(){
        return endTime - startTime;
        
    }



}
