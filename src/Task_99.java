import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task_99 {

    public static void main(String[] args) {

        int block = 0;
        int row = 0;
        int column = 0;
        int count = 0;
        char[][] field = null;
        int xPrinc = 0;
        int yPrinc = 0;
        int xPrincces = 0;
        int yPrincces = 0;
        StringBuilder str = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            block = scan.nextInt();
            row = scan.nextInt();
            column = scan.nextInt();
            field = new char[block * row][column];
            while (scan.hasNext()) {
                str.append(scan.next());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        String str1 = str.toString();
        for (int i = 0; i < block * row; i++) {
            for (int j = 0; j < column; j++) {
                if (str1.charAt(count) == '1') {
                    xPrinc = i;
                    yPrinc = j;
                } else if (str1.charAt(count) == '2') {
                    xPrincces = i;
                    yPrincces = j;
                }
                field[i][j] = str1.charAt(count++);
            }
        }


    }
}