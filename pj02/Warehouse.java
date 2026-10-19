package pj02;

public class Warehouse {
    private Shelf[][] shelves;

    public Warehouse(int rows, int columns) {
        shelves = new Shelf[rows][columns];
    }

    public Shelf[][] getShelves() {
        return shelves;
    }

    public int addItems(Item item, int quantity) {
        int numLeft = quantity;
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < shelves[0].length; j++) {
                var shelfPallets = shelves[i][j].getPallets();
                var shelf = shelves[i][j];
                for (int x = 0; x < shelfPallets.length; x++) {
                    var pallet = shelfPallets[x];
                    Item palletItem = pallet.getItem();
                    if (numLeft <= 0) {
                        break;
                    } else if (palletItem.getName() == null) {
                        continue;
                    } else if (!palletItem.getName().equals(item.getName())) {
                        continue;
                    } else if (pallet.getRemainingCapacity() < item.getWeight()) {
                        continue;
                    } else if (shelf.getAvailableCapacity() < item.getWeight()) {
                        continue;
                    }

                    numLeft = pallet.addItem(item, numLeft);
                    



                }
            }
        }
    
        return numLeft;


    }

    public int removeItems(Item item, int quantity) {
        int leftToRemove = quantity;
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < shelves[0].length; j++) {
                var shelfPallets = shelves[i][j].getPallets();
                var shelf = shelves[i][j];
                for (int x = 0; x < shelfPallets.length; x++) {
                    var pallet = shelfPallets[x];
                    Item palletItem = pallet.getItem();
                    if (leftToRemove <= 0) {
                        break;
                    } else if (palletItem.getName() == null) {
                        continue;
                    } else if (!palletItem.getName().equals(item.getName())) {
                        continue;
                    }

                    int numLeft = pallet.removeItems(item, leftToRemove);

                    if (numLeft == 0) {
                        shelf.clean();
                    }
                    



                }
            }
        }
    
        return leftToRemove;


    }




}
