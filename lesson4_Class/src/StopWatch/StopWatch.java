package StopWatch;

public class StopWatch {
    private long starTime;
    private long endTime;
    public StopWatch(){
        this.starTime = System.currentTimeMillis();
    };
    public long getStartTime() {
        return starTime;
    };
    public long getEndTime() {
        return endTime;
    };
    public void start(){
        this.starTime = System.currentTimeMillis();
    };
    public void stop(){
        this.endTime = System.currentTimeMillis();
    };
    public long getElapsedTime(){
        return (endTime - starTime)/1000;
    }


}
