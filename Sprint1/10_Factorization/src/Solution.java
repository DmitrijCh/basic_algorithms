import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int number = Integer.parseInt(tokenizer.nextToken());
        double sqrt = Math.sqrt(number);
        int firstNumber = 2;
        while (number > 1 && firstNumber <= sqrt) {
            if (number % firstNumber == 0) {
                System.out.print(firstNumber + " ");
                number /= firstNumber;
            } else if (firstNumber == 2) {
                firstNumber++;
            } else {
                firstNumber += 2;
            }
        }
        if (number != 1) {
            System.out.print(number);
        }
    }
}
