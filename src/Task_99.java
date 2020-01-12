import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_99 {

    public static void main(String[] args) {

        int block = 0;
        int row = 0;
        int column = 0;
        int count = 0;
        char[][][] field = null;
        int[][][] wave = null;
        StringBuilder str = new StringBuilder();
        Node start = null;
        int end = 0;
        MyQueue q = new MyQueue();

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            block = scan.nextInt();
            row = scan.nextInt();
            column = scan.nextInt();
            field = new char[block][row][column];
            wave = new int[block][row][column];
            while (scan.hasNext()) {
                str.append(scan.next());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        String str1 = str.toString();
        for (int i = 0; i < block; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    field[i][j][k] = str1.charAt(count++);
                    wave[i][j][k] = 0;
                    if (field[i][j][k] == '1') {
                        start = new Node(i, j, k);
                    }
                }
            }
        }

        q.add(start);
        wave[start.getZ()][start.getY()][start.getX()] = 1;
        while (!q.isEmpty()) {
            Node current = q.peek();
            q.remove();

            if (current.getZ() < block - 1) {
                if (field[current.getZ() + 1][current.getY()][current.getX()] == '2') {
                    end = (wave[current.getZ()][current.getY()][current.getX()]);
                    break;
                } else if (field[current.getZ() + 1][current.getY()][current.getX()] == '.'
                        && wave[current.getZ() + 1][current.getY()][current.getX()] == 0) {
                    int c = 0;
                    q.add(new Node(current.getZ() + 1, current.getY(), current.getX()));
                    c = (wave[current.getZ()][current.getY()][current.getX()]);
                    wave[current.getZ() + 1][current.getY()][current.getX()] = c + 1;
                }
            }

            if (current.getY() < row - 1) {
                if (field[current.getZ()][current.getY() + 1][current.getX()] == '2') {
                    end = (wave[current.getZ()][current.getY()][current.getX()]);
                    break;
                } else if (field[current.getZ()][current.getY() + 1][current.getX()] == '.'
                        && wave[current.getZ()][current.getY() + 1][current.getX()] == 0) {
                    int c = 0;
                    q.add(new Node(current.getZ(), current.getY() + 1, current.getX()));
                    c = (wave[current.getZ()][current.getY()][current.getX()]);
                    wave[current.getZ()][current.getY() + 1][current.getX()] = c + 1;
                }
            }

            if (current.getX() != 0) {
                if (field[current.getZ()][current.getY()][current.getX() - 1] == '2') {
                    end = (wave[current.getZ()][current.getY()][current.getX()]);
                    break;
                } else if (field[current.getZ()][current.getY()][current.getX() - 1] == '.'
                        && wave[current.getZ()][current.getY()][current.getX() - 1] == 0) {
                    int c = 0;
                    q.add(new Node(current.getZ(), current.getY(), current.getX() - 1));
                    c = (wave[current.getZ()][current.getY()][current.getX()]);
                    wave[current.getZ()][current.getY()][current.getX() - 1] = c + 1;
                }
            }

            if (current.getY() != 0) {
                if (field[current.getZ()][current.getY() - 1][current.getX()] == '2') {
                    end = (wave[current.getZ()][current.getY()][current.getX()]);
                    break;
                } else if (field[current.getZ()][current.getY() - 1][current.getX()] == '.' &&
                        wave[current.getZ()][current.getY() - 1][current.getX()] == 0) {
                    int c = 0;
                    q.add(new Node(current.getZ(), current.getY() - 1, current.getX()));
                    c = (wave[current.getZ()][current.getY()][current.getX()]);
                    wave[current.getZ()][current.getY() - 1][current.getX()] = c + 1;
                }
            }

            if (current.getX() < column - 1) {
                if (field[current.getZ()][current.getY()][current.getX() + 1] == '2') {
                    end = (wave[current.getZ()][current.getY()][current.getX()]);
                    break;
                } else if (field[current.getZ()][current.getY()][current.getX() + 1] == '.' &&
                        wave[current.getZ()][current.getY()][current.getX() + 1] == 0) {
                    int c = 0;
                    q.add(new Node(current.getZ(), current.getY(), current.getX() + 1));
                    c = (wave[current.getZ()][current.getY()][current.getX()]);
                    wave[current.getZ()][current.getY()][current.getX() + 1] = c + 1;
                }
            }
        }

        for (int i = 0; i < block; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    System.out.print(wave[i][j][k]);
                }
                System.out.println();
            }
        }

        try (FileWriter output = new FileWriter("output.txt")) {
            output.write(String.valueOf(end * 5));
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}

class Node{

    private int x;
    private int y;
    private int z;

    public Node() {
    }

    public Node(int z, int y, int x) {
        this.z = z;
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

}

class MyQueue{

    ArrayList<Node> list = new ArrayList<>();

    public void add(Node item) {
        list.add(item);
    }

    public Node remove() {
        return list.remove(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Node peek(){
        return list.get(0);
    }

    public void clear(){
        list.clear();
    }
}
