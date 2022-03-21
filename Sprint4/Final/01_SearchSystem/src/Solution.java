/* Принцип работы алгоритма:
Для каждого слова в тексте вычисляется количество раз, сколько это слово встречается в тексте.
Таким образом создается хеш-таблица где ключами являются слова, а значениями являются вложенные
хеш-таблицы, где ключами являются номера текстов, а значениями являются частота, с которой встречается
слово в тексте. Создание такой таблицы называется построением обратного поискового индекса (inverted index).
Далее для каждого слова из запроса делается запрос в хеш-таблицу и возвращается сколько раз встречается это
слово в каждом тексте. Далее происходит суммирование частот слов по текстам и таким образом вычисляется
самый релевантный текст к запросу.
*/

/* Временная сложность:
Для создания хеш-таблицы потребуется просмотреть все тесты со всеми словами в них O(N(текстов) * M(слов в текстах)),
где N - количество тестов, M - количество слов в этих текстах.
Для поиска каждого запроса, для каждого уникального слова из запроса сделать запрос к хэш-таблице и
проитерировать по хеш-таблице номер текста : частота слова, то есть O(N(запросов) * M(слов в запросах) * К(слов в текстах)).
*/

/* Пространственная сложность: O(N * M)
Создается хеш-таблица (количество уникальных слово в текстах : (количество текстов : частота).
Пространственная сложность такой хэш-таблицы будет O(M(слов в текстах) * N(текстов)).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static final int RELEVANT_DOCUMENTS = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, HashMap<Integer, Integer>> textIndex = new HashMap<>();
        int amountText = Integer.parseInt(bufferedReader.readLine());
        for (int textNumber = 1; textNumber <= amountText; textNumber++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            createIndexText(textIndex, textNumber, stringTokenizer);
        }

        int numberRequests = Integer.parseInt(bufferedReader.readLine());
        StringBuffer result = new StringBuffer(" ");
        for (int queryNumber = 0; queryNumber < numberRequests; queryNumber++) {
            Map<Integer, Integer> resultForQuery = new HashMap<>();
            HashSet<String> queryWords = new HashSet<>();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            searchQuery(textIndex, resultForQuery, queryWords, stringTokenizer);

            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(resultForQuery.entrySet());
            sortResultQuery(entryList);
            addResult(result, entryList);
        }
        System.out.println(result);
    }

    private static void createIndexText(HashMap<String, HashMap<Integer, Integer>> textIndex, int textNumber, StringTokenizer stringTokenizer) {
        while (stringTokenizer.hasMoreTokens()) {
            String words = stringTokenizer.nextToken();
            if (textIndex.containsKey(words)) {
                if (textIndex.get(words).containsKey(textNumber)) {
                    int frequency = textIndex.get(words).get(textNumber) + 1;
                    textIndex.get(words).put(textNumber, frequency);
                } else {
                    textIndex.get(words).put(textNumber, 1);
                }
            } else {
                var texts = new HashMap<Integer, Integer>();
                texts.put(textNumber, 1);
                textIndex.put(words, texts);
            }
        }
    }

    private static void searchQuery(HashMap<String, HashMap<Integer, Integer>> textIndex, Map<Integer, Integer> resultForQuery, HashSet<String> queryWords, StringTokenizer stringTokenizer) {
        while (stringTokenizer.hasMoreTokens()) {
            String words = stringTokenizer.nextToken();
            if (!queryWords.contains(words)) {
                queryWords.add(words);
                if (textIndex.containsKey(words)) {
                    for (Map.Entry<Integer, Integer> pair : textIndex.get(words).entrySet()) {
                        int textNumber = pair.getKey();
                        if (resultForQuery.containsKey(textNumber)) {
                            int newRelevance = pair.getValue() + resultForQuery.get(textNumber);
                            resultForQuery.put(textNumber, newRelevance);
                        } else {
                            resultForQuery.put(textNumber, pair.getValue());
                        }
                    }
                }
            }
        }
    }

    private static void sortResultQuery(List<Map.Entry<Integer, Integer>> entryList) {
        Comparator<Map.Entry<Integer, Integer>> comparator = Map.Entry.comparingByValue();
        comparator = comparator.reversed().thenComparing(Map.Entry::getKey);
        entryList.sort(comparator);
    }

    private static void addResult(StringBuffer result, List<Map.Entry<Integer, Integer>> entryList) {
        int resultRequestSize = 0;
        for (Map.Entry<Integer, Integer> pair : entryList) {
            if (resultRequestSize < RELEVANT_DOCUMENTS && pair.getValue() != 0) {
                result.append(pair.getKey()).append(" ");
                resultRequestSize++;
            }
        }
        result.append("\n");
    }
}

