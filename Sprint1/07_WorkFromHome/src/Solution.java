import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder binary = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int number = Integer.parseInt(tokenizer.nextToken());
        while (number > 0) {
            if ((number & 1) == 1) {
                binary.append(1);
            } else {
                binary.append(0);
                number >>= 1;
            }
        }
        System.out.println(binary.reverse());
    }
}
