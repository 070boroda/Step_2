import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_99 {

    public static void main(String[] args) {

        int block = 0;
        int row = 0;
        int column = 0;
        int count = 0;
        int result = 0;
        char[][][] field = null;
        StringBuilder str = new StringBuilder();
        Node prince = null;
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
        String str1 = str.toString();
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
        while (!q.isEmpty()) {
            result++;
            Node curent;
            curent = q.peek();
            curent.setVisited(true);
            check.add(curent);
            q.remove();

            if (field[curent.getZ()][curent.getY()][curent.getX()] == '2') {
                System.out.println("e ghbywtcs");
                result++;
                System.out.println(result);
                System.out.println("count = " + result*5);
                System.out.println("Поиск завершен");
                return;
            }

            if (curent.getX() != 0) {
                if (field[curent.getZ()][curent.getY()][curent.getX() - 1] != 'o') {
                    if (!check(new Node(curent.getZ(), curent.getY(), curent.getX() - 1), check)) {

                        q.add(new Node(curent.getZ(), curent.getY(), curent.getX() - 1));
                        System.out.println("Лево");

                    }
                }
            }

            if (curent.getY() != 0)
                if (field[curent.getZ()][curent.getY() - 1][curent.getX()] != 'o') {
                    if (!check(new Node(curent.getZ(), curent.getY() - 1, curent.getX()), check)) {
                        q.add(new Node(curent.getZ(), curent.getY() - 1, curent.getX()));
                        System.out.println("Вверх");
                    }
                }

            if (curent.getX() != column - 1) {
                if (field[curent.getZ()][curent.getY()][curent.getX() + 1] != 'o') {
                    if (!check(new Node(curent.getZ(), curent.getY(), curent.getX() + 1), check)) {

                            q.add(new Node(curent.getZ(), curent.getY(), curent.getX() + 1));
                        System.out.println("право");
                        }
                    }
                }


            if (curent.getY() != row - 1) {
                if (field[curent.getZ()][curent.getY() + 1][curent.getX()] != 'o') {
                    if (!check(new Node(curent.getZ(), curent.getY() + 1, curent.getX()), check)) {

                        q.add(new Node(curent.getZ(), curent.getY() + 1, curent.getX()));
                        System.out.println("Вниз");
                    }
                }
            }

            if (curent.getZ() != block - 1) {
                if (field[curent.getZ()+1][curent.getY()][curent.getX()] != 'o') {
                    if (!check(new Node(curent.getZ() + 1, curent.getY(), curent.getX()), check)) {

                        q.add(new Node(curent.getZ()+1, curent.getY() , curent.getX()));
                        System.out.println("Вглубь");
                    }
                }
            }
        }

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
        this.y = y;
        this.x = x;
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
