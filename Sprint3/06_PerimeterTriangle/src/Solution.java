import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int linesQuantity = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        List<Integer> lines = new ArrayList<>();
        for (int i = 0; i < linesQuantity; i++) {
            lines.add(Integer.parseInt(tokenizer.nextToken()));
        }
        Collections.sort(lines);
        int max = 0;
        for (int i = lines.size() - 1; i >= 2; i--) {
            int result = 0;
            if (lines.get(i) < lines.get(i - 1) + lines.get(i - 2)) {
                result = lines.get(i) + lines.get(i - 1) + lines.get(i - 2);
            }
            if (result > max) {
                max = result;
            }
        }
        System.out.println(max);
    }
}