/* Принцип работы алгоритма:
 Пройти по каждому символу в массиве, если элемет не является специальным символом поместить его в стек.
 Когда будет найден специальный символ, взять первые два числа из стека и произвести с ними нужное арифметическое
действие, согласно условию и всавить обратно в стек. Когда цикл будет пройден, условия выполнены, извлекается элемент из
стека и печатается.
*/

/* Временная сложность алгоритма: O(n)
 Для решения данной задачи я использовал стек. Стек — это коллекция, элементы которой получают по принципу «последним
пришёл — первым вышел» (LIFO)
 Добавление в очередь (метод push) стоит O(1), потому что добавление во входной стек стоит O(1).
 Извлечение из очереди стоит в лучшем случае O(1), когда выходной стек не пуст.
 Каждый "не специальный элемент" будет переложен из стека в стек один раз.
 Это значит, что добавление и извлечение n элементов в сумме будет стоить O(n).
 Так же используется цикл,котроый имеет временную сложность O(n).
*/

/* Пространственная сложность алгоритма: O(n)
 Так как я использую stack, котрый хранит в себе данные, занимает O(n)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution testFinal2 = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split(" ");
        System.out.println((testFinal2.stackElements(array)));
    }

    Deque<String> stack = new ArrayDeque<>();
    int firstElement;
    int secondElement;
    String specialChar;
    int expression;

    public int stackElements(String[] arr) {
        for (String s : arr) {
            switch (s) {
                case "+", "-", "*", "/" -> specialChar = s;
                default -> {
                    stack.push(s);
                    continue;
                }
            }
            switch (specialChar) {
                case "+" -> {
                    firstElement = Integer.parseInt(stack.pop());
                    secondElement = Integer.parseInt(stack.pop());
                    expression = secondElement + firstElement;
                    stack.push(Integer.toString(expression));
                }
                case "-" -> {
                    firstElement = Integer.parseInt(stack.pop());
                    secondElement = Integer.parseInt(stack.pop());
                    expression = secondElement - firstElement;
                    stack.push(Integer.toString(expression));
                }
                case "*" -> {
                    firstElement = Integer.parseInt(stack.pop());
                    secondElement = Integer.parseInt(stack.pop());
                    expression = firstElement * secondElement;
                    stack.push(Integer.toString(expression));
                }
                case "/" -> {
                    firstElement = Integer.parseInt(stack.pop());
                    secondElement = Integer.parseInt(stack.pop());
                    expression = (int) Math.round(Math.floor((double) secondElement / firstElement));
                    stack.push(Integer.toString(expression));
                }
                default -> {
                }
            }
        }
        return
                Integer.parseInt(stack.pop());
    }
}