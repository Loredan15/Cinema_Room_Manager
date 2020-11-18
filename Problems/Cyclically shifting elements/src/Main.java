import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] data = new int[number];
        for (int i = 1; i < data.length; i++){
            data[i] = scanner.nextInt();
        }
        data[0] = scanner.nextInt();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <data.length ; i++) {
            res.append(data[i] + " ");
            res.trimToSize();
        }
        System.out.println(res);
    }
}
