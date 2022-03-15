import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int[] array = new int[16];
        for (int i = 0; i < 4; i++) {
            String s = scan.next();
            for (int j = 0; j < 4; j++) {
                char c = s.charAt(j);
                if (c == '.') {
                    array[i * 4 + j] = 0;
                } else {
                    array[i * 4 + j] = Integer.parseInt(c + "");
                }
            }
        }

        int[] count = new int[10];
        int temp;
        int num = k * 2;
        for (int j : array) {
            temp = j;
            count[temp]++;
        }

        int result = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] >= 1) {
                int z = count[i];
                if (z <= num) {
                    z = 1;
                    result += z;
                }
            }
        }
        System.out.print(result);
    }
}
