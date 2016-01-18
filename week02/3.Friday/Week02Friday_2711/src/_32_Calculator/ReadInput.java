package _32_Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInput {
    private BufferedReader br;

    public String readLine(String prompt) {
        System.out.print(prompt);
        try {
            String result = bufferedReader().readLine();
            System.out.println();
            return result;
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    public void writeLine(String output) {
        System.out.println(output);
    }

    private BufferedReader bufferedReader() {
        return br == null ? (br = new BufferedReader(new InputStreamReader(System.in))) : br;
    }

    public static void main(String[] args) {
        ReadInput ri = new ReadInput();
        ri.writeLine("Hello!\n");
        while (true) {
            String userExpression = ri.readLine("Enter expression:>");

            if (!userExpression.toUpperCase().equals("EXIT")) {
                String result = "1";
                ri.writeLine("Output:> " + result);
            } else {
                ri.writeLine("Bye!\n");
                return;}

        }
    }
}
