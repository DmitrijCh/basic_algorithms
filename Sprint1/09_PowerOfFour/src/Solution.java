import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int number = Integer.parseInt(tokenizer.nextToken());
        while (number % 4 == 0 && number > 0) {
            number /= 4;
        }
        System.out.println(number == 1 ? "True" : "False");
    }
}