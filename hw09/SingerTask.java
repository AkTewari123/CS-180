public class SingerTask extends Thread implements Runnable {
    @Override 
    public void run() {
        try {
            for (int i = 0; i < 26; i ++) {
                IO.println((char) ('a' + i));
                super.sleep(250);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SingerTask t1 = new SingerTask();

        t1.run();
    }
}
