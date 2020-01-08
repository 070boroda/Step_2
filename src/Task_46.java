import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_46 {

    public static void main(String[] args) {

        int value = 0;
        StringBuilder e = new StringBuilder();
        e.append("2.7182818284590452353602875");
        String result = null;
        int indexLeft = 0;
        int indexRight = 0;

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            value = scan.nextInt();
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        }

        if (value == 0) {
            result = "3";
        } else if (value == 25) {
            result = String.valueOf(e);
        } else {
            indexRight = Integer.parseInt(e.substring(value + 2, value + 3));
            indexLeft = Integer.parseInt(e.substring(value + 1, value + 2));
            e.delete(value + 1, e.length());
            e.append((indexRight < 5 ? indexLeft : indexLeft + 1));
            result = String.valueOf(e);
        }

        try (FileWriter output = new FileWriter("output.txt")) {
            output.write(result);
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
