import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_99 {

    public int sumWide(Node root) {
        MyQueue stack = new MyQueue();
        stack.add(root);

        int summ = 0;

        while (!stack.isEmpty()) {
            Node node = stack.remove();

        }
        return summ;
    }


    public static void main(String[] args) {

        int block = 0;
        int row = 0;
        int column = 0;
        int count = 0;
        char[][][] field = null;
        StringBuilder str = new StringBuilder();
        Node prince = null;
        MyQueue q = new MyQueue();

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            block = scan.nextInt();
            row = scan.nextInt();
            column = scan.nextInt();
            field = new char[block][row][column];
            while (scan.hasNext()) {
                str.append(scan.next());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        String str1 = str.toString();                   //Инициализация переменных
        for (int i = 0; i < block; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    field[i][j][k] = str1.charAt(count++);
                    if (field[i][j][k] == '1') {
                        prince = new Node(i, j, k);

                    }
                }
            }
        }

        prince.setAvailable(true);
        q.add(prince);

        while (!q.isEmpty()) {
            Node curent;
            curent = q.peek();
            System.out.println("текущая позиция z" + curent.getZ());
            q.remove();

            if (field[curent.getZ()][curent.getX()][curent.getY()] == '2') {  // роверяем нашли или нет принцесу
                count++;
                return;
            }

            if (curent.getX() != 0 || field[curent.getZ()][curent.getX() - 1][curent.getY()] != 'o' || !curent.isAvailable()) { //проверяем левую ячейку
                q.add(new Node(curent.getZ(), curent.getX() - 1, curent.getY(), true));
            }

            if (curent.getY() != 0 || field[curent.getZ()][curent.getX()][curent.getY() - 1] != 'o' || !curent.isAvailable()) { //проверяем верхнюю ячейку
                q.add(new Node(curent.getZ(), curent.getX(), curent.getY() - 1, true));
            }

            if (curent.getX() != row-1 || field[curent.getZ()][curent.getX() + 1][curent.getY()] != 'o' || !curent.isAvailable()) { //проверяем правую ячейку
                q.add(new Node(curent.getZ(), curent.getX() + 1, curent.getY(), true));
            }
            if (curent.getY() != column-1 || field[curent.getZ()][curent.getX()][curent.getY() + 1 ] != 'o' || !curent.isAvailable()) { //проверяем нижняя ячейку
                q.add(new Node(curent.getZ(), curent.getX() - 1, curent.getY(), true));
            }


        }

        System.out.println("Поиск завершен");
    }
}


/*        System.out.println(prince.getZ() + prince.getX() + prince.getY());
        for (int i = 0; i <block ; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    System.out.print(field[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }*/



class Node{

    private int x;
    private int y;
    private int z;
    private boolean isAvailable;

    public Node() {
    }

    public Node(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }

    public Node(int z, int i, int y, boolean setAvailable) {
        this.z = z;
        this.x = x;
        this.y = y;
        this.isAvailable = setAvailable ;
    }

    public boolean isAvailable() {
        return isAvailable;
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

    public void setAvailable(boolean available) {
        isAvailable = available;
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

    public boolean contains(Node item) {
        return list.contains(item);
    }

     public Node peek(){
        return list.get(0);
     }

 }
