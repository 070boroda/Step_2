import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_53 {

    public static void main(String[] args) {

        int row = 0;
        int column = 0;
        int composition = 0;
        int countBlack = 0;
        int countRed = 0;
        int countBlue = 0;
        int countGreen = 0;
        String result = null;

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            row = scan.nextInt();
            column = scan.nextInt();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                composition = i * j;
                if (composition % 5 == 0) {
                    countBlue++;
                } else if (composition % 3 == 0) {
                    countGreen++;
                } else if (composition % 2 == 0) {
                    countRed++;
                } else {
                    countBlack++;
                }
            }

            result = "RED : " + countRed + "\n"
                    + "GREEN : " + countGreen + "\n"
                    + "BLUE : " + countBlue + "\n"
                    + "BLACK : " + countBlack;

            try (FileWriter output = new FileWriter("output.txt")) {
                output.write(result);
            } catch (IOException | NumberFormatException e1) {
                e1.printStackTrace();
            }
        }
    }
}
