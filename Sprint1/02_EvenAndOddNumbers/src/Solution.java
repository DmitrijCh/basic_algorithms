import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int firstNumber = Integer.parseInt(tokenizer.nextToken());
        int secondNumber = Integer.parseInt(tokenizer.nextToken());
        int thirdNumber = Integer.parseInt(tokenizer.nextToken());
        System.out.println(compareEvenOdd(firstNumber, secondNumber, thirdNumber));
    }

    public static String compareEvenOdd(int x, int y, int z) {
        boolean yRemain = y % 2 == 0;
        if ((x % 2 == 0) == yRemain && (z % 2 == 0) == yRemain) {
            return "WIN";
        } else {
            return "FAIL";
        }
    }
}