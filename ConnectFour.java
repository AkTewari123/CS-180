/* 
  * Program: ConnecFour.java
  * @version 9/22/26
  * @author Akshat Tewari
  * Description: This program is for two players to play ConnectFour with each other!
*/

boolean checkWin(char[][] connectBoard, int col, int row,  boolean turn) {
    if (row < 0 || col < 1) {
        // IO.println("not checking");
        return false;
    }

    char mark = turn ? 'X' : 'O';
    int numConsecutive = 0;
    --col;
    // IO.println(String.format("column: %d, row: %d, turn: %s", col, row, turn ? "X" : "O"));
    
    // horizontal win
    int i = 0;
    // IO.println("checking row number " + row);
    for (var piece : connectBoard[row]) {
      
        if (piece == mark) {
            ++numConsecutive;
            // IO.println("HIT: i = " + i + ", row = " + row + ", consecutive = " + numConsecutive + " for player: " + (turn ? "X" : "O"));
        } else {
            numConsecutive = 0;
            // IO.println("reset to 0");
        }
        i++;
        if (numConsecutive >= 4) {
            return true;
        }
      
    }
    
    numConsecutive = 0;
    
    // IO.println("checking column number " + col);
    
    // vertical win
    for (i = 0; i < connectBoard.length; i++) {
        if (connectBoard[i][col] == mark) {
            // IO.println("HIT: i = " + i + ", col = " + col + ", consecutive = " + numConsecutive);
            ++numConsecutive;
        } else {
            // IO.println("reset to 0");
            numConsecutive = 0;
        }
        if (numConsecutive >= 4) {
            return true;
        }
    }
    
    numConsecutive = 0;
    
    // checking diagonals
    
    int diagTopLeft = 0;
    int diagBottomLeft = 0;
    for (int x = -3; x < 4; x++) {
      // IO.println(String.format("DIAG TL: checking x = %d where col = %d and row = %d", x, col + x, row + x));
      // IO.println(String.format("DIAG BL: checking x = %d where col = %d and row = %d", x, col + x, row - x));
      if (x == 0) {
        // IO.println("arrived @ location of player piece");
      }
      
      if (col + x < 0 || col + x >= connectBoard[0].length) {
        // IO.println(String.format("Out of bounds: col = %d", col + x));
        diagTopLeft = diagBottomLeft = 0;
        continue;
      }  else {
          if (row + x < 0 || row + x >= connectBoard.length) {
            diagTopLeft = 0;
            // IO.println(String.format("Out of bounds TL: row = %d for number of rows: %d", row + x, connectBoard.length));
            // continue;
          } else {
            // IO.println("running check for TL");
            if (mark == connectBoard[row + x][col + x]) {
              // IO.println("HIT TOP LEFT: x = " + x);
              diagTopLeft++;
              // IO.println("NUM FOR TL IN A ROW: " + diagTopLeft);

              if (diagTopLeft >= 4) {
                return true;

              }
            } else {
              diagTopLeft = 0;
            }
      }
        
      if (row - x >= 0 && row - x < connectBoard.length) {
          // IO.println("running check for BL");

          if (mark == connectBoard[row - x][col + x]) {
            // IO.println("HIT BOTTOM LEFT: x = " + x);
            diagBottomLeft++;
            // IO.println("NUM FOR BL IN A ROW: " + diagBottomLeft);
            if (diagBottomLeft >= 4) {
              return true;
            }
          } else {
            diagBottomLeft = 0;
          }
        } else {
            // IO.println(String.format("Out of bounds BL: row = %d for number of rows: %d", row + x, connectBoard.length));

            diagBottomLeft = 0;
        }
      }

      // IO.println();
    }
    
    return false;
  }
    void printBoard(char[][] connectBoard) {
        String boardArray = "1 2 3 4 5 6 7\n";

        for (int i = 0; i < connectBoard.length; i++) {
            for (int j = 0; j < connectBoard[i].length; j++) {
                boardArray += connectBoard[i][j] + (j < connectBoard[i].length - 1 ? " " : "");
            }
            if (i < connectBoard.length - 1) {
                boardArray += "\n";
            }
        }

        IO.println(boardArray);
    }
  char[][] makeMove(char[][] connectBoard, int col, boolean turn) {
      if (col < 1 || col > 7) {
          // IO.println("column number");
          return new char[1][1];
      }

      --col;

      for (int i = 5; i >= 0; i--) {

          if (connectBoard[i][col] == '.') {
              connectBoard[i][col] = turn ? 'X' : 'O';
              break;
          } else if (i == 0) {
              return new char[1][1];
          }
      }

      printBoard(connectBoard);
      return connectBoard;
  }

    int getColNum (Scanner scan, String prompt) {
        while (true) {
            IO.println(prompt);
            if (scan.hasNextInt()) {
                return scan.nextInt();
            } else {
                scan.next();
                scan.nextLine();
                IO.println("Invalid Column");
            }
    }
  }

  void main() {
      IO.println("Welcome to Connect Four!");


      boolean playerTurn = false; // true for Player 1, false for Player 2
      String promptOne = "Player 1 (X) - Choose a column:";
      String promptTwo = "Player 2 (O) - Choose a column:";
      int colNum = -1;
      int rowNum = -1;
      int numTurns = 0;

      // init board
      char[][] board = new char[6][7];
      int i = 0;
      for (var col : board) {
          int j = 0;
          for (var row : col) {
              board[i][j++] = '.';
          }
          ++i;
      }
      printBoard(board);
      Scanner scan = new Scanner(System.in);
      while (true) {
          if (numTurns >= board.length * board[0].length) {
              break;
          }
          playerTurn = !playerTurn;
          colNum = getColNum(scan, playerTurn ? promptOne : promptTwo);

        

          char[][] newBoard = makeMove(board, colNum, playerTurn);

          while (newBoard.length == 1) {
            // printBoard(board);
            IO.println("Invalid Column");
            colNum = getColNum(scan, playerTurn ? promptOne : promptTwo);
            newBoard = makeMove(board, colNum, playerTurn);
          } 

          board = newBoard;

          for (int it = 0; it < 6; it++) {
            // IO.println("inspecting column " + board[it][colNum - 1]);
            if (board[it][colNum - 1] != '.') {
              rowNum = it;
              break;
            }
          }
        
        ++numTurns;

        // IO.println("number of turns: " + numTurns);
        // IO.println("ROW NUMBER DETERMINED: " + rowNum);
        
        if (checkWin(board, colNum, rowNum, playerTurn)) {
            break;
        }
        // printBoard(board);
        
      }
      if (checkWin(board, colNum, rowNum, playerTurn)) {
          IO.println(playerTurn ? "Player 1 Wins!" : "Player 2 Wins!");
      } else {
          IO.println("Game Ends in a Draw!");
      }

      scan.close();
      




}