
/**
 * Pallet.java
 * This is Pallet which has items in our warehouse.
 * @author Akshat Tewari
 * @version 10/20/26
 */
public class Pallet {

    private Item item;
    private int count;
    public Pallet(Item item, int count) {
        
        if (item != null && Policies.getPalletCapacity(item.getSize()) >= count) {
            this.item = item;
            this.count = count;
        } else {
            this.item = null;
            this.count = 0;
        }
    }

    public Item getItem() {
        return item;
    }
    public int getCount() {
        return count;
    }

    public int getRemainingCapacity() {
        if (item != null) {
            return this.getCapacity() - count;
        }
        return -1;
    }

    public int getCapacity() {
        if (item == null) {
            return -1;
        }
        return Policies.getPalletCapacity(item.getSize());
    }

    public boolean isFull() {
        return this.getRemainingCapacity() < 1;
    }

    public boolean isEmpty() {
        return this.item == null || this.getRemainingCapacity() == this.getCapacity();
    }

    public double getWeight() {
        if (item == null) {
            return 0;
        }
        return item.getWeight() * count;
    }

    public int addItems(Item item, int quantity) {
        if (quantity <= 0 ) {
            return quantity;
        }
        if (this.item != null && item != null && !this.item.equals(item)) {
            return quantity;
        }
        if (item != null) {
            if (this.item == null) {
                this.item = item;
            }
            int tmp = count;
            count = Math.min(this.getCapacity(), count + quantity);
            count = Math.max(count, 0); 
            if (quantity > 0)  {
                return Math.max(tmp + quantity - this.getCapacity(), 0);
            } else {
                return Math.min(quantity + (tmp - count), 0);
            }
        } 
        // IO.println("here");
        return quantity;
    }

    public int removeItems(Item item, int quantity) {
        
        if (item != null && this.item != null && this.item.getName().equals(item.getName())) {
            int tmp = count;
            count = Math.max(0, count - quantity);
            if (count == 0) {
                this.item = null;
            }
            if (quantity > tmp) {
                return tmp;
            } else {
                return quantity;
            }
        }
        return 0;
    }

    @Override 
    public String toString() {
        String itemString;
        if (item == null) {
            itemString = "null";
        } else {
            itemString = item.toString();
        }
        return itemString + " x " + count;
    }

}
