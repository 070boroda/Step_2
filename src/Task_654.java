import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_654 {

    public static void main(String[] args) {

        long[] array = null;
        long prev = 0;
        long sum = 0;
        long max = prev;
        int x = 0;
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);

            x = scan.nextInt();
            array = new long[x];
            for (int i = 0; i < x; i++) {
                array[i] = scan.nextInt();
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
            if (array[i] > array[i - 1]) {
                sum += array[i] - array[i - 1];
            }
            prev = array[i];
        }
        sum += max - prev;
        try (
                FileWriter output = new FileWriter("output.txt")) {
            output.write(String.valueOf(sum));
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
