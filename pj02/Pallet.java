package pj02;

public class Pallet {

    private Item item;
    private int count;
    public Pallet(Item item, int count) {
        if (Policies.getPalletCapacity(item.getSize()) >= count) {
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
        return Policies.getPalletCapacity(item.getSize());
    }

    public boolean isFull() {
        return this.getRemainingCapacity() < 1;
    }

    public boolean isEmpty() {
        return item == null || this.getRemainingCapacity() == this.getCapacity();
    }

    public double getWeight() {
        return item.getWeight() * count;
    }

    public int addItem(Item item, int quantity) {
        if (this.item.getName().equals(item.getName())) {
            int tmp = count;
            count = Math.min(this.getCapacity(), count + quantity);

            return Math.max(tmp + quantity - this.getCapacity() , 0);
        } 

        return quantity;
    }

    public int removeItems(Item item, int quantity) {
        if (this.item.getName().equals(item.getName())) {
            int tmp = count;
            count = Math.max(0, count - quantity);

            return Math.max(quantity, tmp - quantity);
        }
        return 0;
    }

    @Override 
    public String toString() {
        return item.toString() + " x " + count;
    }

}
