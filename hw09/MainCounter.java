public class MainCounter {
    public static void main(String[] args) {
        try {
            LockThreads t1 = new LockThreads();
            LockThreads t2 = new LockThreads();
    
            t1.start();
            t2.start();
    
            t1.join();
            t2.join();

            IO.println(new Counter().getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
