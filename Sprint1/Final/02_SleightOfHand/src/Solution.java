// Сложность алгоритма: O(n) — линейная зависимость

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberKey = scan.nextInt();
        int[] simulatorField = new int[16];
        final int line = 4;
        for (int i = 0; i < line; i++) {
            String s = scan.next();
            for (int j = 0; j < line; j++) {
                char sym = s.charAt(j);
                if (sym == '.') {
                    simulatorField[i * line + j] = 0;
                } else {
                    simulatorField[i * line + j] = Integer.parseInt(sym + "");
                }
            }
        }

        int[] numbersBox = new int[10];
        int temp;
        final int num = numberKey * 2;
        for (int j : simulatorField) {
            temp = j;
            numbersBox[temp]++;
        }

        int result = 0;
        for (int i = 1; i < numbersBox.length; i++) {
            if (numbersBox[i] >= 1) {
                int sumDigits = numbersBox[i];
                if (sumDigits <= num) {
                    sumDigits = 1;
                    result += sumDigits;
                }
            }
        }
        System.out.print(result);
    }
}