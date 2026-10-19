package pj02;
class Test{
    public static void main(String[] args) {
        Item itemOne = new Item("Zelda", 234, 2.25, 'S');
        Item itemTwo = new Item("Zelda", 234, 2.203, 'M');
        Pallet palletOne = new Pallet(itemOne, 5);
        Pallet palletTwo = new Pallet(itemTwo, 105);

        IO.println(itemOne.toString());
        IO.println(itemTwo.toString());
        IO.println(itemOne.equals(itemTwo));
        IO.println(palletOne.toString());
        IO.println(palletOne.addItem(itemTwo, 400));
        IO.println(palletOne.getCount());
    }

}