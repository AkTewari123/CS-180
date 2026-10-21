import java.util.concurrent.atomic.AtomicInteger;


public class AtomicCounter {
    private static AtomicInteger value;

    public int getValue() {
        return value.get();
    }

    public void increment() {
        value.getAndIncrement();
    }

    public void decrement() {
        value.getAndDecrement();
    }
}
