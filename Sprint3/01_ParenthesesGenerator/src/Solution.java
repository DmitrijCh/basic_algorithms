import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequenceNum = scanner.nextInt();
        char[] charBox = new char[2 * sequenceNum];
        sequence(charBox, 0, sequenceNum, 0, 0);
    }

    static void sequence(char[] str, int pos, int n, int open, int close) {
        if (close == n) {
            for (char c : str) System.out.print(c);
            System.out.println();
        } else {
            if (open < n) {
                str[pos] = '(';
                sequence(str, pos + 1, n, open + 1, close);
            }
            if (open > close) {
                str[pos] = ')';
                sequence(str, pos + 1, n, open, close + 1);
            }
        }
    }
}