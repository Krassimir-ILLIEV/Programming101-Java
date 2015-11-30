import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFiles {

    public static void main(String[] args) {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("wordGame.txt");
            Scanner scanner = new Scanner(fileInput);
            String input=scanner.nextLine();
            
            String[] s=input.replaceAll("\\s+", " ").split(" ");
            int N=Integer.parseInt(s[0]);
            int M=Integer.parseInt(s[1]);
            System.out.println(M);
            System.out.println(N);
           String[][] Grid = new String[N][M];
           int i=0;
            while (scanner.hasNextLine()) {
                input = scanner.nextLine().replaceAll("\\s+", " ");
                String[] st=input.split(" ");
                
                System.out.println(input);
                    for (int j=0; j<M;j++){
                        Grid[i][j]=st[j];
                }
                    i++;

           }
            System.out.println("-----");
            for (int k=0;k<N;k++){
                for (int j=0;j<M;j++){
                    System.out.print(Grid[k][j]);
                }
                System.out.println();
            }
            scanner.close();
            fileInput.close();
        } catch (Exception e) {
            System.out.println("Oops!Something went wrong.");

        }
    }
}
