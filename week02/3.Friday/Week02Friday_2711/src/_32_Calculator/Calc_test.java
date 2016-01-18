package _32_Calculator;

public class Calc_test {
    final static String[] operatorsSplit = "!,^,(,),!,*,/,+,-".split(",");
    final static String[] operatorsExecute = "!,^,*,/,+,_".split(",");

    private static String myFormat(String s) {
        s = s.replaceAll("\\!","!1"); //so that it is no longer a unary operator 
        for (int i = 0; i < operatorsSplit.length; i++) {
            String o = " " + operatorsSplit[i] + " ";
            s = s.replaceAll("\\" + operatorsSplit[i], o);
        }
        s = s.replaceAll("\\p{javaSpaceChar}{2,}", " ").trim();
        if (s.charAt(0)=='-') s=s.replace("- ", "@");
        s = s.replaceAll("\\-", "_");
        s=s.replace("@", "-");
        //Math.
        return s;
    }

    private static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    private static String removeBrackets(String s) {
        int leftBracket = s.indexOf('(');
        while (leftBracket > -1) {
            int rightBracket = leftBracket+1;
            /*while (rightBracket > leftBracket && s.charAt(rightBracket) != ')') {
                rightBracket--;
            }*/
            int b=0; //number of left brackets after first one
            while(rightBracket<s.length() && (b!=0 || s.charAt(rightBracket)!=')' )){
                if(s.charAt(rightBracket)=='(') b++;
                else if(s.charAt(rightBracket)==')') b--;
                rightBracket++;
            }
            String strBnBrackets = s.substring(leftBracket + 1, rightBracket);
            // System.out.println(strBnBrackets);
            strBnBrackets = removeBrackets(strBnBrackets);

            s = s.substring(0, leftBracket) + " " + strBnBrackets + " " + s.substring(rightBracket + 1);
            // System.out.println("s: (row38) "+ s);
            leftBracket = s.indexOf('(');
        }
        
        if (containsExOperators(s)) {
            String s2 = myFormat(s);
            // System.out.println("s2: "+s2);
            String s1 = executeOperations(s2);
            // System.out.println("-----: "+s1);
            s = s1;
        }
        return s;

    }

    private static boolean containsExOperators(String s) {
        for (int i = 0; i < operatorsExecute.length; i++) {
            if (s.indexOf(operatorsExecute[i]) > -1) {
                return true;
            }
       }
        return false;
    }

    private static String executeOperations(String s) {
        int iBeg;
        int iEnd;
        Double tempResult;
        for (int i = 0; i < operatorsExecute.length; i++) {
            int index = s.indexOf(operatorsExecute[i]);
            while (index != -1) {
                /*if (operatorsExecute[i].equals("!")) {
                    iBeg = index - 2;
                    iEnd = index + 1;

                    while (iBeg > 0 && s.charAt(iBeg) != ' ') {
                        iBeg--;
                    }

                    String t = s.substring(iBeg, iEnd);
                    // System.out.printf("! b: %d, e: %d, t: |%s| \n", iBeg,
                    // iEnd, t);
                    String[] expression = s.substring(iBeg, iEnd).trim().split(" ");
                    Double operand1 = Double.parseDouble(expression[0].trim());
                    Integer op1 = operand1.intValue();
                    tempResult = 1.0 * factorial(op1);
                } else
                */
                {
                    iBeg = index - 2;
                    iEnd = index + 2;
                    while (iEnd < s.length() && s.charAt(iEnd) != ' ') {
                        iEnd++;
                    }

                    while (iBeg > 0 && s.charAt(iBeg) != ' ') {
                        iBeg--;
                    }

                    String t = s.substring(iBeg, iEnd);

                    // System.out.printf("b: %d, e: %d, t: |%s| \n", iBeg, iEnd,
                    // t);
                    String[] expression = s.substring(iBeg, iEnd).trim().split(" ");

                    double operand1 = Double.parseDouble(expression[0].trim());
                    double operand2 = Double.parseDouble(expression[2].trim());
                    tempResult = 0.0;
                    switch (expression[1]) {
                    case "!":
             
                        Double d=operand1;
                        tempResult = 1.0 * factorial(d.intValue());
                        break;
                    case "^":
                        tempResult = Math.pow(operand1, operand2);
                        break;
                    case "*":
                        tempResult = operand1 * operand2;
                        break;
                    case "/":
                        tempResult = operand1 / operand2;
                        break;
                    case "+":
                        tempResult = operand1 + operand2;
                        break;
                    //case "-":
                    case "_":
                        tempResult = operand1 - operand2;
                        break;
                    // ! ???
                    }
                }
                s = (s.substring(0, iBeg).trim() + " " + tempResult.toString() + " " + s.substring(iEnd).trim());
                s = s.trim();
                // System.out.printf("----------result s: %s\n",s);
                index = s.indexOf(operatorsExecute[i]);
            }
        }
        return s;
    }

    private static void myInterface() {
        ReadInput ri = new ReadInput();
        ri.writeLine("Hello!\n");
        while (true) {
            String userExpression = ri.readLine("Enter expression:>");

            if (!userExpression.toUpperCase().equals("EXIT")) {
                String result = removeBrackets(userExpression);
                ri.writeLine("Output:> " + result);
            } else {
                ri.writeLine("Bye!\n");
                return;
            }

        }
    }

    public static void main(String[] args) {
        myInterface();
        //String s = "3^2 + 2^3";
        // s=myFormat(s);
        //System.out.println(s + "=" + removeBrackets(s));
        // System.out.println(s);
        // System.out.println("|" + executeOperations_test(s) + "|");

    }
}