package challengerOne;

public class Main {
    public static void main(String[] args) {
        try {
            Runnable p1 = new PrimeFinder(1, 70);
            Runnable p2 = new PrimeFinder(71, 100);
    
            Thread t1 = new Thread(p1);
            Thread t2 = new Thread(p2);

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            for (int i = 0; i < PrimeFinder.getPrimes().size(); i++) {
                IO.println(PrimeFinder.getPrimes().get(i));
            }

            IO.println(String.format("Size: %d", PrimeFinder.getNum()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
