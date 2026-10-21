public class CounterThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                IO.println(i);
                super.sleep(500);
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CounterThread t1 = new CounterThread();
        CounterThread t2 = new CounterThread();

        t1.start();
        t2.start();
    }
}
