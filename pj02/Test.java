import java.util.Arrays;

class Test{
    public static void main(String[] args) {
        Item itemOne = new Item("Zelda", 234, 2.25, 'S');
        Item itemTwo = new Item("Barbie", 289, 2.203, 'M');
        Item itemThree = new Item("Mario", 900, 3.2, 'S');
        
        Pallet p1 = new Pallet(itemThree, 100);

        // p1.removeItems(itemThree, 100);
        
        IO.println(p1.addItems(itemThree, -110));
        // IO.println(p1.addItems(itemTwo, 4));
        IO.println(p1);
    }   

}