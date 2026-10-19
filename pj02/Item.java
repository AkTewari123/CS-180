package pj02;

public class Item {
    String name;
    int itemNumber;
    double weight;
    char size;

    public Item(String name, int itemNumber, double weight, char size) {
        this.name = name;
        this.itemNumber = itemNumber;
        this.weight = weight;
        this.size = size;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) - %.2f lbs - Size %c", name, itemNumber, weight, size);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Item otherItem) {
            return otherItem.toString().equals(this.toString());
        }

        return false;
    }

}
