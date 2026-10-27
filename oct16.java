class Main {
    void main() throws InterruptedException {
        Thread t1 = new Thread(new Counter());
        Thread t2 = new Thread(new Counter());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        IO.println("expected 2000000, got " + Counter.counter);
    }
}

class Counter implements Runnable {
    static int counter = 0;
    Object gate = new Object();                    // NOT static: every worker gets its own gate

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (gate) {
                counter++;
            }
        }
    }
}