/** 
  * @version 9/15/26
  * @author Akshat Tewari
  * Description: This program lets people put in an equation and outputs a 
  * Solution for the simple equation!
*/

/**
 * This function checks the character "i" across all different possible operators. 
 * This is a way to condense code & improve neatness
 * @param i character from the eqn string
 * @return isOperator to see if a given character is an operator
 * @author Akshat Tewari
 */
public static boolean isOperator(char i) {
    // check if something is an operator
    if (i == '-') {
        return true;
    } else if (i == '*') {
        return true;
    } else if (i == '+') {
        return true;
    } else if (i == '/') {
        return true;
    } else if (i == '^') {
        return true;
    } else {
        return false;
    }
}

/**
 * This function condenses the equation based on the operator passed in
 * It takes the two numbers on the sides of a sign & performs the appropriate operation.
 * @param eqn the equation as a string
 * @param operator the operator we are looking for
 * @return handleOperator a condensed/simplified version of the equation 
 * @author Akshat Tewari
 */
public static String handleOperator(String eqn, char operator) {
    String firstNum;
    String secondNum;
    int i = 0;
    while (eqn != null && eqn != "" && eqn.substring(1).indexOf(operator) != -1) {
        // IO.println("loop");
        int start;
        int end;
        firstNum = "";
        secondNum = "";
        if (eqn.charAt(i) == operator && i != 0) {
            // IO.println("operator found: " + operator + " at " + i);
            start = i - 1;
            end = i + 1;
            // IO.println("found at " + i + " end: " + end + " start: " + start);

            boolean hasNegativeBeg = false; 
            
            while (start >= 0 && (!isOperator(eqn.charAt(start)) || hasNegativeBeg)) {
                firstNum = eqn.charAt(start) + firstNum;
                start--;
                hasNegativeBeg = start >= 0 && eqn.charAt(start) == '-' 
                    && (start == 0 || isOperator(eqn.charAt(start - 1))); 
            }

            while (end < eqn.length() && (!isOperator(eqn.charAt(end)) || end == i + 1)) {
                secondNum += eqn.charAt(end);
                end++;
            }

            // IO.println("end: " + end + " start: " + start);
            // IO.println("firstNum: " + firstNum + " secondNum: " + secondNum);
            if (firstNum == "" || firstNum == null || secondNum == "" || secondNum == null) {
                break;
            }
            var a = Double.parseDouble(firstNum);
            var b = Double.parseDouble(secondNum);
            double result = switch (operator) {
                case '^' -> Math.pow(a, b);
                case '*' -> a * b;
                case '/' -> a / b;
                case '-' -> a - b;
                default -> a + b;
                
            };


            String temp = eqn;
            eqn = "";
            eqn += start == -1 ? "" : temp.substring(0, start + 1);
            eqn += String.format("%.2f", result) + temp.substring(end);
            // IO.println(eqn);
            i = 0;
        } else {
            i++;
        }
            
    }
    return eqn;
}

public static void main(String[] args) {
    // Helper helper = Helper();
    IO.println("Welcome to Basic Calculator!");
    IO.println("1 - Enter an Equation");
    IO.println("2 - Exit");
    
    int userInput = Integer.parseInt(IO.readln());

    while (userInput != 1 && userInput != 2) {
        IO.println("Invalid Menu Option");
        IO.println("1 - Enter an Equation");
        IO.println("2 - Exit");
        userInput = Integer.parseInt(IO.readln());
    }


    while (userInput == 1) {
        String eqn = IO.readln("Enter an equation:\n");
        
        eqn = handleOperator(eqn, '^');
        eqn = handleOperator(eqn, '*');
        eqn = handleOperator(eqn, '/');
        eqn = handleOperator(eqn, '-');
        eqn = handleOperator(eqn, '+');
        
        IO.println("Solution = " + eqn);

        IO.println("1 - Enter an Equation");
        IO.println("2 - Exit");
        userInput = Integer.parseInt(IO.readln());
        while (userInput != 1 && userInput != 2) {
            IO.println("Invalid Menu Option");
            IO.println("1 - Enter an Equation");
            IO.println("2 - Exit");
            userInput = Integer.parseInt(IO.readln());
        } 
    }
    IO.println("Thank you for using Basic Calculator!");
}