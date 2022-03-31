/* Принцип работы алгоритма: 
 Алгоритм основан на двумерное динамическом программировании, в котором промежуточные результаты сохраняются в 
матрице с размерами l1 x l2, где l1 - длина первой строки, l2 -длина второй строки. 
 В матрице будут храниться редакционные расстояния (то есть количество символов, которые нужно изменить, чтобы 
строка 1 стала идентичной строке 2. 
 Базовым случаем, когда длины первой и второй строк будут равны 0, то редакционное расстояние также будет равно 0. 
 При длине первой строки 0, первая строка в матрице будет строка последовательных числе, длиной, равной длине второй строки. 
    Переходом динамики будет определение минимального значения из: 
        - значения ячейки слева от текущей + 1, dp[i][j - 1] + 1; 
        - значения ячейки выше от текущей + 1, dp[i - 1][j] + 1; 
        - значения ячейки выше и слева от текущей, dp[i - 1][j - 1] + 1 если буквы на текущей позиции в первой и второй 
          строках различны, + 0 - в обратном случае. 
 Порядок вычислений в матрице: матрица будет заполняться сверху вниз, слева направо. 
 Ответом будет нижний правый элемент матрицы. 
 С целью сокращения используемой памяти для сохранения результатов вычисления используются два массива. 
*/ 
 
/* Временная сложность  O(l1 * l2): 
 Временная сложность будет складываться из:
    - итерации по каждому символу 1 строки, O(l1), где l1 - длина первой строки, 
    - итерации по каждому символу 2 строки, O(l2), где l2 - длина второй строки, 
    - определения минимума из трех величин, O(1). 
*/ 
 
/* Пространственная сложность O(l2 + 1): 
 С учетом примененной оптимизации пространственная сложность складывается из:
    - строки матрицы, равной длине второй строки плюс единица, так как отсчет в матрице начинается с единицы. 
    - еще одной строки матрицы такой же длины. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String stringFirst = bufferedReader.readLine();
        String stringSecond = bufferedReader.readLine();
        System.out.println(distance(stringFirst, stringSecond));
    }

    public static int distance(String stringFirst, String stringSecond) {
        int[] dp = new int[stringSecond.length() + 1];
        int[] dpPrev = new int[stringSecond.length() + 1];

        for (int j = 0; j <= stringSecond.length(); j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= stringFirst.length(); i++) {
            System.arraycopy(dp, 0, dpPrev, 0, dpPrev.length);

            dp[0] = i;
            for (int j = 1; j <= stringSecond.length(); j++) {
                int cost = (stringFirst.charAt(i - 1) != stringSecond.charAt(j - 1)) ? 1 : 0;
                dp[j] = min(
                        dpPrev[j] + 1,
                        dp[j - 1] + 1,
                        dpPrev[j - 1] + cost
                );
            }
        }

        return dp[dp.length - 1];
    }

    private static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
} 