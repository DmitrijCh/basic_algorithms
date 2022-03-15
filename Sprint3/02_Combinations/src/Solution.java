import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numbers = reader.readLine();
        int[] digits = new int[numbers.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Integer.parseInt(numbers.substring(i, i + 1));
        }
        StringBuilder builder = new StringBuilder(" ");
        List<String> combinations = getCombinations(digits);
        for (String combination : combinations) {
            builder.append(combination).append(" ");
        }
        System.out.print(builder);
    }

    public static List<String> getCombinations(int[] digits) {
        String[] alphabet = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();
        combinations.add("");
        for (Integer digit : digits) {
            List<String> temp = new ArrayList<>();
            for (String combination : combinations) {
                for (String letter : alphabet[digit].split("")) {
                    temp.add(combination + letter);
                }
            }
            combinations.clear();
            combinations.addAll(temp);
        }
        return combinations;
    }
}