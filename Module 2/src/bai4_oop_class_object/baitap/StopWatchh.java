package bai4_oop_class_object.baitap;



public class StopWatchh {
    private long starTime;
    private long endTime;

    public StopWatchh(long starTime, long endTime) {
        this.starTime = starTime;
        this.endTime = endTime;
    }

    public long getStarTime() {
        return starTime;
    }

    public void setStarTime(long starTime) {
        this.starTime = starTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public StopWatchh() {
    }

    public void start( ) {
      this.starTime = System.currentTimeMillis();


    }
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
       return  endTime - starTime;

    }

    public static void main(String[] args) {
        StopWatchh star1 = new StopWatchh();
        star1.start();
        for (int i = 0; i < 1000000 ; i++) {

        }
        star1.stop();
        System.out.println("Thời gian bắt đầu " + star1.getStarTime());
        System.out.println("Thời gian hoàn thành " + star1.getEndTime());
        System.out.println("Tổng thời gian " + star1.getElapsedTime() + " millisecond");
    }
}
