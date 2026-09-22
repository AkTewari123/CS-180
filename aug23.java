import java.lang.IO;

void main() {
    String s = "BURGER";
    s.length();    // 6     how many characters
    IO.println(s.charAt(0));   // 'B'   the char at a position
    IO.println(s.charAt(2));   // 'R'
    
    double part = 5.0;
    int partTwo = 5;
    
    IO.println((int) (part));
    IO.println((double) (partTwo));
    String y = "BURGER";

    if (s == y) {
        IO.println("not cooked");
    } else {
        IO.println("cooked");

    }

}