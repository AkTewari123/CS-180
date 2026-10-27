public class BalanceTracker {
 
    public static void main(String[] args) {
        int[] amounts = {100, 50, 20, 30, 10, 60, 5, 40};
        // 1 = deposit, 2 = withdrawal, 3 = refund
        int[] types = {1, 1, 2, 1, 2, 1, 3, 1};
 
        double balance = 0.0;
 
        for (int i = 0; i < amounts.length; i++) {
            int type = types[i];
            int amount = amounts[i];
 
            if (type == 1) {
                balance += amount;
            } else if (type == 2) {
                balance -= amount;
            } else if (type == 3) {
                balance += amount;
            }
        }
 
        double expected = 255.0;
        if (Math.abs(balance - expected) < 0.001) {
            System.out.println("Correct! Final balance: $" + balance);
        } else {
            System.out.println("Expected $" + expected + ", got $" + balance);
        }
    }
}
