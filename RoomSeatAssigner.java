void main() {
    IO.println("Welcome to Room Seat Assigner!");
    String[] names = (IO.readln("Enter student names separated by commas:\n")).split(",");

    double doubSquare = (Math.pow(names.length, .5));
    double delta = 1e-3;

    if (delta < doubSquare % 1) {
        ++doubSquare;
    }
    int square = (int) doubSquare;
    IO.println("Minimum Room Size: " + square + " x " + square);
    
    IO.println("Seating Chart:");
    for (int i = 0; i < square; i++) {
        for (int j = 0; j < square; j++) {
            int idx = i * square + j;

            if (idx < names.length) {
                IO.print(names[idx]);
            } else {
                IO.print("EMPTY");
            }

            if (j < square - 1) {
                IO.print(" ");
            }
        }
        
        IO.println();
    }



}