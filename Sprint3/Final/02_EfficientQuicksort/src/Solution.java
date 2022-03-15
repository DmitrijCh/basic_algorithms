/* Принцип работы алгоритма:
 Алгоритм использует сортировку quick sort и сравнение трех полей объектов,находящихся в массиве.
 Сортировка quick sort состоит из выбора элемента для сравнения(pivot),сравнения всех элементов с pivot и отнесения э
лемента в правую или левую часть в массиве. Дополнительные еструктуры данных не используются для перекладывания элементов
массива,поэтому осуществляется перестановка элементов из левой части в правую(on-place).
 Данная последовательность действий выполняется рекурсивно для каждой части массива относительно pivot, который выбирается
новый каждую итерацию до тех пор,пока указатели с начала и конца массива не перейдут через друг друга.
 Алгоритм корректен,так как каждый элемент сравнивается с опорным элементом и кладется в правый или левый подмассив
относительно опорного элемента.Так продолжается рекурсивно до тех пор,пока длина подмассива будет равна 1 или 0.
 Подпоследовательность единичной или нулевой длины упорядочена.
 */

/* Временная сложность алгоритма: O(NlogN)
 Временная сложность алгоритма quiqsort зависит от выбора элемента для сравнения (pivot) и в худшем случае (например,
если массив упорядочем, а выбран крайний элемент) временная сложность будет O(N^2). Но в среднем случае этот алгоритм
имеет временную сложность O(NlogN). В качестве элемента для сравнения выбирается элемент, находящийся на среднем месте в
массиве. Сравнение полей объектов в массиве выполняется за константное время.
*/ 
 
/* Пространственная сложность алгоритма: O(n)
 Во время выполнения не создается дополнительных структур данных кроме исходного массива.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static class Trainee {
        final String login;
        final int solvedProblems;
        final int fine;

        Trainee(String login, int solvedProblems, int fine) {
            this.login = login;
            this.solvedProblems = solvedProblems;
            this.fine = fine;
        }

        static int partition(Trainee[] trainees, int left, int right) {
            Trainee pivot = trainees[right];
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (compare(trainees[j], pivot)) {
                    i++;
                    swap(trainees, i, j);
                }
            }
            swap(trainees, i + 1, right);
            return i + 1;
        }

        static boolean compare(Trainee left, Trainee pivot) {
            if (left.solvedProblems < pivot.solvedProblems) {
                return false;
            } else if (left.solvedProblems > pivot.solvedProblems) {
                return true;
            } else {
                if (left.fine > pivot.fine) {
                    return false;
                } else if (left.fine < pivot.fine) {
                    return true;
                } else {
                    return left.login.compareTo(pivot.login) < 0;
                }
            }
        }

        static void swap(Trainee[] trainees, int firstIndex, int secondIndex) {
            Trainee temp = trainees[firstIndex];
            trainees[firstIndex] = trainees[secondIndex];
            trainees[secondIndex] = temp;
        }

        static void quickSort(Trainee[] trainees, int left, int right) {
            if (left < right) {
                int pivot = partition(trainees, left, right);
                quickSort(trainees, left, pivot - 1);
                quickSort(trainees, pivot + 1, right);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        Trainee[] trainees = new Trainee[size];
        for (int i = 0; i < size; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            trainees[i] = new Trainee(tokenizer.nextToken(),
                    Integer.parseInt(tokenizer.nextToken()),
                    Integer.parseInt(tokenizer.nextToken()));
        }
        Trainee.quickSort(trainees, 0, size - 1);
        StringBuilder stringBuilder = new StringBuilder(" ");
        for (Trainee trainee : trainees) {
            stringBuilder.append(trainee.login).append(" ").append("\n");
        }
        System.out.println(stringBuilder);
    }
}
 