public class OrderTotal {

    // Looks up the price for a given item type.
    // 1 = book, 2 = pen, 3 = notebook
    static double priceForItem(int itemType) {
        double price;
        if (itemType == 1) {
            price = 12.0;
        } else if (itemType == 2) {
            price = 1.5;
        } else if (itemType == 3) {
            price = 12.0;
        } else {
            price = 0.0;
        }
        return price;
    }

    // Calculates total price for all the items in int[] items
    static double calculateTotal(int[] items) {
        double total = 0.0;
        for (int i = 0; i < items.length; i++) {
            double p = priceForItem(items[i]);
            total += p;
        }
        return total;
    }

    public static void main(String[] args) {
        IO.println("Remy".indexOf('y'));
    }
}