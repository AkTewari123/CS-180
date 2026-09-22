import java.lang.IO;

void main() {
    boolean x = true  && false;   // and, false
    boolean y = true  || false;   // or, true
    boolean z = !true; // not operator, false
    IO.println("" + x + y + z);

    String school = "Purdue";
    String univ = "University";

    String s1 = school.concat(" " + univ);   // "PurdueUniversity"
    String s2 = school + " " + univ;   // "Purdue University"
    String s3 = school.toUpperCase();  // "PURDUE"

    IO.println("s1: " + s1);
    IO.println("s2: " + s2);
    IO.println("s3: " + s3);


}