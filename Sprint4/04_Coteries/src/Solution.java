import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lineQuantity = Integer.parseInt(reader.readLine());
        List<String> coteries = new ArrayList<>();
        Set<String> coterieSet = new HashSet<>();
        for (int i = 0; i < lineQuantity; i++) {
            String circle = reader.readLine();
            if (!coterieSet.contains(circle)) {
                coterieSet.add(circle);
                coteries.add(circle);
            }
        }
        StringBuffer buffer = new StringBuffer(" ");
        for (String circle : coteries) {
            buffer.append(circle).append("\n");
        }
        System.out.println(buffer);
    }
}