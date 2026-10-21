package challengerOne;

import java.util.ArrayList;

public class PrimeFinder implements Runnable {
    private int start;
    private int end;
    private static ArrayList<Integer> primes = new ArrayList<>();
    private static Object lock = new Object();

    public PrimeFinder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isPrime (int num) {
        if (num == 2 || num == 4) {
            return false;
        }
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        for (int num = start; num <= end; num++) {
            boolean addToList = isPrime(num);
    
            if (addToList) {
                synchronized (lock) {
                    primes.add(num);
                }
            }
        }

    }

    public static ArrayList<Integer> getPrimes() {
        return primes;
    }

    public static int getNum() {
        return primes.size();
    }

    

}
