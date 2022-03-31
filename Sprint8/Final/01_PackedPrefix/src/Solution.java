/* Принцип работы алгоритма:
 Распаковыаем все строки в массив unpackedStrings. Для этого используем методы decodeString и decode. decodeString
инициирует выполнение рекурсивного decode. Используем переменную pass, для итерации по всем символам строки. Если встречаем
цифру, добавляем в count. При встрече символа '[', передвигаем итератор pass и снова запускаем рекурсию, получивраспакованную
подстроку между символами '[' и ']', далее кладем ее столько раз, сколько у нас получилось в счетчике count.
 Далее, получив в массив все распакованные строки, находим их общий префикс в методе longestCommonPrefix. В нем сравниваем
первые символы всех трех строк, пока не получаем несовпадение.
*/

/* Временная сложность:
Декодирование занимает О(n), где n - это кол-во всех запакованных строк
ычисление общего префикса О(len * n), где len - это длина первой строки, а n - это кол-во всех распакованных строк
Получаем О(n + (len * n))
*/

/* Пространственная сложность:
Храним массив распакованных строк unpackedStrings - O(n), где n - это кол-во строк
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int pass;

    public static void main(String[] args) throws IOException {
        printCommonPrefix();
    }

    public static String decodeString(String s) {
        pass = 0;
        return decode(s);
    }

    private static String decode(String s) {
        StringBuilder out = new StringBuilder();
        int count = 0;
        while (pass < s.length()) {
            char c = s.charAt(pass);

            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                pass++;
                String insideOfParentheses = decode(s);
                while (count > 0) {
                    out.append(insideOfParentheses);
                    count--;
                }
            } else if (c == ']') {
                return out.toString();
            } else {
                out.append(c);
            }
            pass++;
        }
        return out.toString();
    }

    public static String longestCommonPrefix(String[] unpackedStrings) {
        StringBuilder out = new StringBuilder();
        for (int j = 0; j < unpackedStrings[0].length(); j++) {
            char current = unpackedStrings[0].charAt(j);
            for (String str : unpackedStrings) {
                if (str.charAt(j) != current) {
                    return out.toString();
                }
            }
            out.append(current);
        }
        return out.toString();
    }

    public static void printCommonPrefix() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] unpackedStrings = new String[n];
        for (int i = 0; i < n; i++) {
            unpackedStrings[i] = decodeString(reader.readLine());
        }
        System.out.println(longestCommonPrefix(unpackedStrings));
    }
}
