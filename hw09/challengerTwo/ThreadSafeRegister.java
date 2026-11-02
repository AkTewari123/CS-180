package challengerTwo;

import java.util.ArrayList;

public class ThreadSafeRegister extends Register {
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
    private boolean equals (double a, double b) {
        // IO.println(String.format("a-b: %.7f", a-b));
        return Math.abs(a - b) < 1e-3;
    }
    public double[] makeChange(double cost, double amountPaid) {
        double change = amountPaid - cost;
        var changeList = new ArrayList<Double>();
        // IO.println("change due: " + change);
        while ((change > 0 && !this.equals(change, 0))) {
            synchronized (lock) {
                // IO.println(this.toString());
                // IO.println("lock");
                int nickels = super.getNickels();
                int dimes = super.getDimes();
                int quarters = super.getQuarters();
                int ones = super.getOnes();
                int fives = super.getFives();
                int tens = super.getTens();
                int twenties = super.getTwenties();
                // IO.println(this.toString());
                if ((change > 20 || this.equals(change, 20)) && twenties > 0) {
                    changeList.add(20.0);
                    super.setTwenties(twenties - 1);
                    change -= 20;
                } else if ((change >= 10 || this.equals(change, 10)) && tens > 0) {
                    changeList.add(10.0);
                    change -= 10;
                    super.setTens(tens - 1);
                } else if ((change >= 5 || this.equals(change, 5)) && fives > 0) {
                    changeList.add(5.0);
                    super.setFives(fives - 1);
                    change -= 5;
                } else if ((change >= 1 || this.equals(change, 1)) && ones > 0) {
                    changeList.add(1.0);
                    super.setOnes(ones - 1);
                    change-=1;
                } else if ((change >= .25 || this.equals(change, .25)) && quarters > 0) {
                    changeList.add(.25);
                    change-=.25;
                    super.setQuarters(quarters - 1);
                } else if ((change >= .1 || this.equals(change, .1)) && dimes > 0) {
                    changeList.add(.10);
                    change-=.1;
                    super.setDimes(dimes - 1);
                } else if ((change >= .05 || this.equals(change, .05)) && nickels > 0) {
                    changeList.add(.05);
                    change-=.05;
                    super.setNickels(nickels - 1);
                } else {
                    // IO.println("cannot make change");
                    break;
                }
                // IO.println(change);
            }
        }
        // IO.println("done with change");
        double[] changeArray = new double[changeList.size()];
        for (int i = 0; i < changeList.size(); i++) {
            changeArray[i] = changeList.get(i);
        }

        return changeArray;

    }

    public String toString() {
        return String.format("Nickels: %d\nDimes: %d\nQuarters: %d\nOnes: %s\nTens: %d\nTwenties: %d", super.getNickels(), super.getDimes(), super.getQuarters(), super.getOnes(), super.getTens(), super.getTwenties());
    }
    
}
