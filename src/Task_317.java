import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_317 {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int z = 0;
        int w = 0;
        int count = 0;

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            x = scan.nextInt();
            y = scan.nextInt();
            z = scan.nextInt();
            w = scan.nextInt();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        int temp_X, temp_Y, temp_Z;
        for (int i = 0; i <= w / x; i++) {
            for (int j = 0; j <= (w - (temp_X = x * i)) / y; j++) {
                temp_Y = y * j;
                temp_Z = w - (temp_X + temp_Y);
                if (temp_Z % z == 0) {
                    count++;
                }
            }
        }

        try (FileWriter output = new FileWriter("output.txt")) {
            output.write(String.valueOf(count));
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
