import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        int value = 0;
        Random random = new Random();
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Введите значение для добавления в левостороннее красно-черное дерево: ");
                value = scanner.nextInt();
                if (tree.addNode(value)) {
                    System.out.println("Значение добавлено в дерево.");
                } else {
                    System.out.println("Значение не может быть добавлено.");
                }
            } while (1==1);
        } catch (Exception ex) {
            System.out.println("Работа программы завершена.");
        }
    }
}