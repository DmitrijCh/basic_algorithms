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
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int homeQuantity = Integer.parseInt(tokenizer.nextToken());
        int amount = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < homeQuantity; i++) {
            prices.add(Integer.parseInt(tokenizer.nextToken()));
        }

        Collections.sort(prices);

        int index = 0;
        int result = 0;
        while (amount >= prices.get(index)) {
            amount -= prices.get(index);
            result++;
            index++;
            if (index == prices.size()) {
                break;
            }
        }
        System.out.println(result);
    }
}