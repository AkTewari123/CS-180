package challengerTwo;

import java.util.ArrayList;

public class ThreadSafeRegister extends Register {
    private int nickels;
    private int dimes;
    private int quarters;
    private int ones;
    private int fives;
    private int tens;
    private int twenties;
    private Object lock = new Object();

    public ThreadSafeRegister(
            int nickels,
            int dimes,
            int quarters,
            int ones,
            int fives,
            int tens,
            int twenties) {
                super(nickels, dimes, quarters, ones, fives, tens, twenties);
    }

    public double[] makeChange(double cost, double amountPaid) {
        double change = cost - amountPaid;
        var changeList = new ArrayList<Double>();

        while (change >= 0) {
            synchronized (lock) {
                if (change >= 20 && twenties > 0) {
                    changeList.add(20.0);
                    twenties--;
                    change -= 20;
                } else if (change >= 10 && tens > 0) {
                    changeList.add(10.0);
                    change -= 10;
                    tens--;
                } else if (change >= 5 && fives > 0) {
                    changeList.add(5.0);
                    fives--;
                    change -= 5;
                } else if (change >= 1 && ones > 0) {
                    changeList.add(1.0);
                    ones--;
                    change-=1;
                } else if (change >= .25 && quarters > 0) {
                    changeList.add(.25);
                    change-=.25;
                    quarters--;
                } else if (change >= .10 && dimes > 0) {
                    changeList.add(.10);
                    change-=.1;
                    dimes--;
                } else if (change >= .05 && nickels > 0) {
                    changeList.add(.05);
                    change-=.05;
                    nickels--;
                }
            }
        }
        double[] changeArray = new double[changeList.size()];
        for (int i = 0; i < changeList.size(); i++) {
            changeArray[i] = changeList.get(i);
        }

        return changeArray;

    }
    
}
