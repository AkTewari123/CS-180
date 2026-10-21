/**
 * Warehouse.java
 * This is the Warehouse which houses all the shelves!
 * @author Akshat Tewari
 * @version 10/20/26
 */
public class Warehouse {
    private Shelf[][] shelves;

    public Warehouse(int rows, int columns) {
        this.shelves = new Shelf[rows][columns];
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < shelves[0].length; j++) {
                double weightLimit = Policies.getShelfWeightLimit();
                shelves[i][j] = new Shelf(Policies.getShelfCapacity(), weightLimit);
            }
        }
    }

    public Shelf[][] getShelves() {
        return this.shelves;
    }

    public int addItems(Item item, int quantity) {
        int numLeft = quantity;
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < shelves[0].length; j++) {
                var shelfPallets = shelves[i][j].getPallets();
                var shelf = shelves[i][j];
                for (int x = 0; x < shelfPallets.length; x++) {
                    var pallet = shelfPallets[x];
                    if (numLeft <= 0) {
                        break;
                    }
                    if (pallet == null || pallet.getItem() == null) {
                        double weightLeft = shelf.getWeightLimit() - shelf.getCurrentWeight();
                        int maxLeft = (int) (weightLeft / item.getWeight());

                        if (maxLeft > 0) {
                            if (Policies.getPalletCapacity(item.getSize()) >= numLeft) {
                                shelfPallets[x] = new Pallet(item, numLeft);
                            } else {
                                int cap = Policies.getPalletCapacity(item.getSize());
                                shelfPallets[x] = new Pallet(item, cap);
                            }
                            numLeft -= shelfPallets[x].getCount();

                        }
                        continue;
                    }

                    Item palletItem = pallet.getItem();
                    double weightLeft = shelf.getWeightLimit() - shelf.getCurrentWeight();
                    if (numLeft <= 0) {
                        break;
                    } else if (palletItem.getName() == null) {
                        continue;
                    } else if (!palletItem.getName().equals(item.getName())) {
                        continue;
                    } else if (weightLeft < item.getWeight()) {
                        continue;
                    }
                    
                    int maxLeft = (int) (weightLeft / item.getWeight());
                    int qntSubtract = Math.min(maxLeft, numLeft);
                    int tmp = pallet.addItems(item, qntSubtract);

                    if (qntSubtract == maxLeft) {
                        numLeft -= (maxLeft - tmp);
                    } else {
                        numLeft = tmp;
                    }
                    



                }
            }
        }
    
        return numLeft;


    }

    public int removeItems(Item item, int quantity) {
        int leftToRemove = quantity;
        int numRemoved = 0;

        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < shelves[0].length; j++) {
                var shelfPallets = shelves[i][j].getPallets();
                var shelf = shelves[i][j];
                for (int x = 0; x < shelfPallets.length; x++) {

                    var pallet = shelfPallets[x];
                    if (pallet == null) {
                        continue;
                    }
                    Item palletItem = pallet.getItem();
                    if (leftToRemove <= 0) {
                        break;
                    } else if (palletItem.getName() == null) {
                        continue;
                    } else if (!palletItem.getName().equals(item.getName())) {
                        continue;
                    }

                    int removedAccumulator = pallet.removeItems(item, leftToRemove);
                    leftToRemove -= removedAccumulator;
                    numRemoved += removedAccumulator;
                    if (pallet.getCount() <= 0) {
                        shelf.clean();
                    }     

                }
            }
        }
    
        return numRemoved;
    }

    public boolean movePallet(int sRow, int sCol, int palletIndex, int dRow, int dCol) {
        if (sRow == dRow 
            && sCol == dCol) {
            return false;
        }
        if (sRow >= shelves.length || sRow < 0) {
            return false;
        }
        if (dRow >= shelves.length || dRow < 0) {
            return false;
        }
        if (sCol >= shelves[0].length || sCol < 0) {
            return false;
        }
        if (dCol >= shelves[0].length || dCol < 0) {
            return false;
        }
        
        if (palletIndex < 0 || palletIndex >= 5) {
            return false;
        }
        Shelf sourceShelf = shelves[sRow][sCol];
        Shelf destShelf = shelves[dRow][dCol];
        if (sourceShelf != null && destShelf != null) {
            Pallet pallet = sourceShelf.getPallets()[palletIndex];

            if (pallet != null) {
                double weightLimit = destShelf.getWeightLimit() - destShelf.getCurrentWeight();
                if (weightLimit >= pallet.getWeight()) {

                    if (destShelf.hasOpenPositions()) {
                        destShelf.addPallet(pallet);
                        sourceShelf.removePallet(palletIndex);
                    }

                }
                return true;
            }

        }

        return false;
    }

    public int[] findItem(Item item) {
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        for (int x = 0; x < shelves.length; x++) {
            for (int y = 0; y < shelves[x].length; y++) {
                Shelf shelf = shelves[x][y];
                if (shelf == null) {
                    continue;
                }

                Pallet[] pallets = shelf.getPallets();
                for (int z = 0; z < pallets.length; z++) {
                    
                    if (pallets[z] != null && pallets[z].getItem().equals(item)) {
                        ret[0] = x;
                        ret[1] = y;

                        return ret;
                    }
                }
            }
        }
        
        return ret;
    }

    public int getItemCount(Item item) {
        int qnt = 0;
        for (int x = 0; x < shelves.length; x++) {
            for (int y = 0; y < shelves[x].length; y++) {
                Shelf shelf = shelves[x][y];
                if (shelf == null) {
                    continue;
                }
                for (int z = 0; z < shelf.getPallets().length; z++) {
                    Pallet pallet = shelf.getPallets()[z];
                    if (pallet != null && pallet.getItem().equals(item)) {
                        qnt += shelf.getPallets()[z].getCount();
                    }
                }
            }
        }
        
        return qnt;
    }






}
