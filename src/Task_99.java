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
        Node quenn = null;
        MyQueue q = new MyQueue();
        ArrayList<Node> check = new ArrayList<>();

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
                    if (field[i][j][k] == '2') {
                        quenn = new Node(i, j, k);

                    }

                }
            }
        }

        for (int i = 0; i <block ; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    System.out.print(field[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }


        q.add(prince);
        System.out.println(quenn.getZ() + " " + quenn.getX() + " " + quenn.getY());
        System.out.println(prince.getZ() + " " + prince.getX() + " " + prince.getY());
        while (!q.isEmpty()) {
            Node curent;
            curent = q.peek();
            curent.setVisited(true);
            check.add(curent);
            System.out.println("текущая позиция z " + curent.getZ());
            System.out.println("текущая позиция x " + curent.getX());
            System.out.println("текущая позиция y " + curent.getY());
            q.remove();

            if (field[curent.getZ()][curent.getX()][curent.getY()] == '2') {  // роверяем нашли или нет принцесу
                count++;
                System.out.println("в цикле с принцессой");
                return;
            }

            if (curent.getX() != 0) {
                if (field[curent.getZ()][curent.getX() - 1][curent.getY()] != 'o' || !check(new Node(curent.getZ(), curent.getX() - 1, curent.getY()),check))//проверяем левую ячейку
                    q.add(new Node(curent.getZ(), curent.getX() - 1, curent.getY()));
              /*  System.out.println("текущая позиция z " + curent.getZ());
                System.out.println("текущая позиция x " + curent.getX());
                System.out.println("текущая позиция y " + curent.getY());*/
                System.out.println("После проверки выхода в левую ячейку");
            }

            if (curent.getY() != 0  && curent.getY() != column-1)
                if (field[curent.getZ()][curent.getX()][curent.getY() + 1] != 'o' || !check(new Node(curent.getZ(), curent.getX(), curent.getY() + 1),check) ) { //проверяем верхнюю ячейку
                    q.add(new Node(curent.getZ(), curent.getX(), curent.getY() + 1));
                }

            if (curent.getX() != row - 1) {
                if (field[curent.getZ()][curent.getX() + 1][curent.getY()] != 'o' || !check(new Node(curent.getZ(), curent.getX() + 1, curent.getY()),check)) { //проверяем правую ячейку
                    q.add(new Node(curent.getZ(), curent.getX() + 1, curent.getY()));
                }
            }

            if (curent.getY() != column - 1) {
                if (field[curent.getZ()][curent.getX()][curent.getY() + 1] != 'o' || !check(new Node(curent.getZ(), curent.getX(), curent.getY()+1),check) ) { //проверяем нижняя ячейку
                    q.add(new Node(curent.getZ(), curent.getX(), curent.getY()+1));
                }
            }

        }
        System.out.println("count = " + count);
        System.out.println("Поиск завершен");
    }


    public static boolean check(Node node, ArrayList<Node> list){
        boolean flag = false;
        for (Node n : list) {
            if(node.getY() == n.getY() && node.getZ() == n.getZ() &&  node.getX() == n.getX()){
                flag = n.isVisited();
            }
        }
        return flag;
    }
}


class Node{

    private int x;
    private int y;
    private int z;
    private boolean isVisited;

    public Node() {
    }

    public Node(int z, int y, int x) {
        this.z = z;
        this.x = x;
        this.y = y;
        this.isVisited = false;
    }


    public boolean isVisited() {
        return isVisited;
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

    public void setVisited(boolean visited) {
        isVisited = visited;
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
