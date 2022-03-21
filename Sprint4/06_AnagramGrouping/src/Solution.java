import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wordsQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<String> words = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < wordsQuantity; i++) {
            words.add(stringTokenizer.nextToken());
        }

        HashMap<String, ArrayList<Integer>> anagramIndexes = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            words.set(i, sortWord(words.get(i)));
            if (!anagramIndexes.containsKey(words.get(i))) {
                anagramIndexes.put(words.get(i), new ArrayList<>(i));
            }
            anagramIndexes.get(words.get(i)).add(i);
        }

        ArrayList<ArrayList<Integer>> indexes = new ArrayList<>(anagramIndexes.size());
        for (Map.Entry<String, ArrayList<Integer>> pair : anagramIndexes.entrySet()) {
            indexes.add(pair.getValue());
        }

        for (ArrayList<Integer> integers : indexes) {
            Collections.sort(integers);
        }

        indexes.sort((ArrayList<Integer> array1, ArrayList<Integer> array2) -> {
            int index1 = 0;
            int index2 = 0;
            while (index1 < array1.size() && index2 < array2.size()) {
                if (array1.get(index1) < array2.get(index2)) {
                    return -1;
                }
                if (array1.get(index1) > array2.get(index2)) {
                    return 1;
                }
                index1++;
                index2++;
            }

            if (index1 < array1.size()) {
                return -1;
            }

            if (index2 < array2.size()) {
                return 1;
            }
            return 0;
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<Integer> indexesForWords : indexes) {
            for (Integer index : indexesForWords) {
                stringBuilder.append(index).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static String sortWord(String word) {
        char[] tempArray = word.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}