package challengerTwo;

import java.util.Arrays;

public class ThreadRegister implements Runnable {
    ThreadSafeRegister tr ;
    public ThreadRegister(ThreadSafeRegister tr) {
        this.tr = tr;
    }
    public void run() {
        IO.println(Arrays.toString(tr.makeChange(10.00, 20.80)));
    }
}
