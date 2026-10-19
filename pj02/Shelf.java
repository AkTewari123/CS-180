package pj02;

public class Shelf {
    private Pallet[] pallets;
    private double weightLimit;
    public Shelf(int palletCapacity, double weightLimit) {
        this.weightLimit = weightLimit;
        pallets = new Pallet[palletCapacity];
    }
    public Pallet[] getPallets() {
        return pallets;
    }

    public double getWeightLimit() {
        return weightLimit;
    }

    public double getCurrentWeight() {
        double total = 0.0;
        for (var pallet : pallets) {
            if (pallet != null) {
                total += pallet.getWeight();
            }
        }

        return total;
    }
    public boolean hasOpenPositions() {
        for (var pallet : pallets) {
            if (pallet == null) {
                return true;
            }
        }

        return false;

    }
    public double getAvailableCapacity() {
        return this.hasOpenPositions() ? weightLimit - this.getCurrentWeight() : -1;
    }

    public boolean addPallet(Pallet pallet) {
        if (pallet.getItem() == null || pallet == null) {
            return false;
        } else if (pallet.getCount() == 0 || !this.hasOpenPositions()) {
            return false;
        } else if (this.weightLimit - this.getCurrentWeight() < pallet.getWeight()) {
            return false;
        } else {

            for (int i = 0; i < this.pallets.length; i++) {
                if (this.pallets[i] == null) {
                    this.pallets[i] = pallet;
                    break;
                }
            }

            return true;
        }

    }

    public int findItem (Item item) {
        for (int i = 0; i < this.pallets.length; i++) {
            if (this.pallets[i] != null) {
                if (this.pallets[i].getItem().getName().equals(item.getName())) {
                    return i;
                }
            }
        }

        return -1;

    }

    public Pallet removePallet(int position) {
        if (position >= this.pallets.length || position < 0 || this.pallets[position] == null) {
            return null;
        }

        Pallet tmp = this.pallets[position];
        this.pallets[position] = null;

        return tmp;
    }

    public void clean() {
        for (int i = 0; i < this.pallets.length; i++) {
            if (this.pallets[i] == null 
                || this.pallets[i].getItem() == null || this.pallets[i].getCount() == 0) {
                    this.pallets[i] = null;
            }
        }
    }

    public String toString() {
        int used = 0;
        for (var pallet : pallets) {
            if (pallet != null) {
                used++;
            }
        }
        return String.format("%d/%d - %.2f/%.2f lbs", used, this.pallets.length, 
            this.getCurrentWeight(), this.getWeightLimit());
    }




}
