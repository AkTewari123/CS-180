void main() {
    int numStore = Integer.parseInt(IO.readln("How many favorite numbers do you have?\n"));

    int[] faveNums = new int[numStore];

    int sum = 0;

    for (int i = 1; i <= numStore; i++) {
        int faveNum = Integer.parseInt(IO.readln(String.format("Enter favorite number %d:\n", i)));
        sum += faveNum;

        faveNums[i-1] = faveNum;
    }


    String arrayString = "";

    for (int val : faveNums) {
        arrayString += val + " ";
    }

    IO.println("Array Contents: " + arrayString.substring(0, arrayString.length()-1));
    IO.println("Array Sum: " + sum);

}