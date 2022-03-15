import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int elementQuantity = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        List<String> arrayList = new ArrayList<>(elementQuantity);
        for (int i = 0; i < elementQuantity; i++) {
            arrayList.add(tokenizer.nextToken());
        }

        arrayList.sort((Comparator<Object>) (obj2, obj1) -> {
            String number1 = obj1.toString();
            String number2 = obj2.toString();
            return (number1 + number2).compareTo(number2 + number1);
        });

        StringBuilder result = new StringBuilder();
        for (String number : arrayList) {
            result.append(number);
        }
        System.out.println(result);
    }
}
