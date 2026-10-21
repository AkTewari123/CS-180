public class LockThreads extends Thread {
    @Override 
    public void run() {
        AtomicCounter myCount = new AtomicCounter();
        for (int i = 0; i < 500; i++) {
            myCount.decrement();
        }
    }
}
