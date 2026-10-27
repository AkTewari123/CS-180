void main () {
    String[][][] world = {
        {
            {"Stone", "Dirt"},
            {"Grass", "Sand"}
        },
        {
            {"Water", "Lava"},
            {"Wood", "Leaves"}
        }
    };
    String demand = IO.readln("Enter an item:\n");

    for (int x = 0; x < 2; x++) {
        for (int y = 0; y < 2; y++) {
            for (int z = 0; z < 2; z++) {
                if (demand.equals(world[x][y][z])) {
                    IO.println("Coordinate:");
                    IO.println("X = " + x);
                    IO.println("Y = " + y);
                    IO.println("Z = " + z);
                    break;
                }
            }
        }
    }
}