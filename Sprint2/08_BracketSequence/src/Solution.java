import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String brackets = scan.nextLine();
        System.out.println(subsequence(brackets));
    }

    public static String subsequence(String brackets) {
        int[] array = new int[brackets.length()];
        int result = 0;
        if (brackets.isEmpty()) {
            return "True";
        }
        if (brackets.charAt(0) == ')' || brackets.charAt(0) == ']') {
            return "False";
        }
        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(') {
                array[result] = 1;
                result++;
            }
            if (brackets.charAt(i) == '[') {
                array[result] = 0;
                result++;
            }
            if (brackets.charAt(i) == ')') {
                if (result == 0 || array[result - 1] == 0) {
                    return "False";
                } else {
                    result--;
                }
            }
            if (brackets.charAt(i) == ']') {
                if (result == 0 || array[result - 1] == 1) {
                    return "False";
                } else {
                    result--;
                }
            }
        }
        if (result != 0) {
            return "False";
        } else {
            return "True";
        }
    }
}