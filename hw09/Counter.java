public class Counter {
    private static int value = 0;
    private static Object lock = new Object();

    public int getValue() {
        return value;
    }

    public void increment() {
        synchronized (lock) {
            value++;
        }
    }
    
    public void decrement() {

        synchronized (lock) {
            value--;
        }
    }


}
