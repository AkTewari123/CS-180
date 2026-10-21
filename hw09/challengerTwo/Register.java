package challengerTwo;

/**
 * Register class
 *
 * An old outdate race condition nightmare.
 *
 * @author Purdue CS
 * @version 1.2.1991
 */
public class Register {

    private int nickels;
    private int dimes;
    private int quarters;
    private int ones;
    private int fives;
    private int tens;
    private int twenties;

    public Register(
            int nickels,
            int dimes,
            int quarters,
            int ones,
            int fives,
            int tens,
            int twenties) {

        this.nickels = nickels;
        this.dimes = dimes;
        this.quarters = quarters;
        this.ones = ones;
        this.fives = fives;
        this.tens = tens;
        this.twenties = twenties;
    }

    public final int getNickels() {
        return nickels;
    }

    public final void setNickels(
            int nickels) {

        this.nickels = nickels;
    }

    public final int getDimes() {
        return dimes;
    }

    public final void setDimes(
            int dimes) {

        this.dimes = dimes;
    }

    public final int getQuarters() {
        return quarters;
    }

    public final void setQuarters(
            int quarters) {

        this.quarters = quarters;
    }

    public final int getOnes() {
        return ones;
    }

    public final void setOnes(
            int ones) {

        this.ones = ones;
    }

    public final int getFives() {
        return fives;
    }

    public final void setFives(
            int fives) {

        this.fives = fives;
    }

    public final int getTens() {
        return tens;
    }

    public final void setTens(
            int tens) {

        this.tens = tens;
    }

    public final int getTwenties() {
        return twenties;
    }

    public final void setTwenties(
            int twenties) {

        this.twenties = twenties;
    }

    public final double getValue() {

        return nickels * 0.05
                + dimes * 0.10
                + quarters * 0.25
                + ones
                + fives * 5.0
                + tens * 10.0
                + twenties * 20.0;
    }

}