/* Принцип работы алгоритма: 
 Алгоритм основан на двумерное динамическом программировании, в котором промежуточные результаты могут сохраняться в 
матрице с размерами sum / 2 + 1 на N + 1, где sum - сумма всех элементов входного массива, N - количество элементов 
во входном массиве. С целью оптимизации использования памяти сохраняется только один столбец, то есть используется 
массив размером sum / 2 + 1. 
 В массиве dp будет храниться логический тип данных, который говорит: 
    - равна ли текущая полусумма (j) минус исследуемый элемент (arr[i]) сумме уже исследованных элементов, 
    - или текущая полусумма равна текущему исследуемому элементу. 
 Базовым случаем, когда проверяется пустое подмножество из входного массива, будет значение ложь в каждой ячейке массива dp. 
 Переход динамики: в каждую клетку массива можно перейти из ячейки с индексом j - arr[i]. 
 Формула перехода: значение в текущей ячейки верно, если: 
    - верно значение в любой ячейке с индексом j - arr[i], 
    - исследуемый элемент равен текущей полусумме j == arr[i]. 
 Порядок вычислений в массиве: вычисления происходят от заключительного элемента к первому. Такие итерации совершаются для 
каждого элемента их входного массива. 
 Ответ будет располагаться в заключительной ячейке массива dp после всех итераций. 
*/ 
 
/* Временная сложность O(N * sum/2), что равносильно O(N * sum): 
 Временная сложность будет складываться из : 
    - итерации по всем элементам входного массива, 0(N), где N - количество элементов во входном массиве, 
    - итерации по каждому целому числу от полусуммы всех элементов входного массива, O(sum/2), где sum - сумма элементов 
      входного массива, до значения текущего исследуемого элемента. В худшем случае O(sum/2) итераций. 
    - сравнения ячеек, O(1). 
*/ 
 
/* Пространственная сложность: 
 Пространственная сложность состоит из хранения массива размером sum/2+1, или в нотации O большое равносильно O(sum). 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numbersQuantity = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[numbersQuantity];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < numbersQuantity; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        System.out.println(partition(numbers) ? "True" : "False");
    }

    static boolean partition(int[] array) {
        int sum = 0;

        for (int k : array) {
            sum += k;
        }
        if (sum % 2 != 0) {
            return false;
        }

        boolean[] dp = new boolean[sum / 2 + 1];

        for (int i = 0; i <= sum / 2; i++) {
            dp[i] = false;
        }
        for (int k : array) {
            for (int j = sum / 2; j >= k; j--) {
                if (dp[j - k] || j == k) {
                    dp[j] = true;
                }
            }
        }
        return dp[sum / 2];
    }
} 