import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberQuantity = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();
        List<Integer> list = new ArrayList<>(numberQuantity);
        StringBuffer buffer = new StringBuffer(" ");
        for (int i = 0; i < numberQuantity; i++) {
            list.add(Integer.parseInt(tokenizer.nextToken()));
        }
        boolean isSortedYet = true;
        for (int i = 0; i < list.size() - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int tmp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, tmp);
                    isSorted = false;
                    isSortedYet = false;
                }
            }
            if (isSortedYet) {
                print(list, buffer);
                break;
            }
            if (isSorted) {
                break;
            }
            print(list, buffer);
        }
    }

    private static void print(List<Integer> arrayList, StringBuffer stringBuffer) {
        for (Integer number : arrayList) {
            stringBuffer.append(number).append(" ");
        }
        System.out.println(stringBuffer.toString());
        stringBuffer.setLength(0);
    }
}