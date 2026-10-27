void main() {
    String[][] ticBoard = new String[3][3];

    String boardString = IO.readln("Enter row 1:\n");
    ticBoard[0] = boardString.split(" ");
    boardString = IO.readln("Enter row 2:\n");
    ticBoard[1] = boardString.split(" ");
    boardString = IO.readln("Enter row 3:\n");
    ticBoard[2] = boardString.split(" ");


    String winner = "-";
    for (int i = 0; i < 3; i++) {
        boolean inARow = ticBoard[i][0].equals(ticBoard[i][1]) && ticBoard[i][0].equals(ticBoard[i][2]);
        if (inARow) {
            winner = ticBoard[i][0];
            break;
        }
    }

    for (int j = 0; j < 3; j++) {
        if (!winner.equals("-")) {
            break;
        }
        boolean inACol = ticBoard[0][j].equals(ticBoard[1][j]) && ticBoard[1][j].equals(ticBoard[2][j]);
        if (inACol) {
            winner = ticBoard[0][j];
        }
    }
    if (winner.equals("-")) {
         
        if (ticBoard[0][0].equals(ticBoard[1][1]) && ticBoard[0][0].equals(ticBoard[2][2])) {
            winner = ticBoard[0][0];
        }   else if (ticBoard[0][2].equals(ticBoard[1][1]) && ticBoard[0][2].equals(ticBoard[2][0])) {
            winner = ticBoard[0][2];
        }
    }

    if (winner.equals("O")) {
        IO.println("Win for Player O");
    } else if (winner.equals("X")) {
        IO.println("Win for Player X");
    } else {

        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticBoard[i][j].equals("-")) {
                    full = false;
                }
            }
        }    
        // IO.println(Arrays.deepToString(ticBoard[0]));
        // IO.println(Arrays.deepToString(ticBoard[1]));
        // IO.println(Arrays.deepToString(ticBoard[2]));
        IO.println(full ? "Draw" : "Incomplete Game");
    }
}