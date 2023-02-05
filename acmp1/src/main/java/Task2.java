import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        if (n < 0) {
            System.out.println(((-1 + n) * (-n) / 2 + 1));
        } else if (n == 0) {
            System.out.println(1);
        } else {
            System.out.println((1 + n) * n / 2);
        }

    }
}