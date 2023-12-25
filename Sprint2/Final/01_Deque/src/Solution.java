/* Принцип работы алгоритма:
 Добавляем в дек новые элементаы. Ессли дек не пустой, количество элементов увеличится на 1, а сам элемент будет находится
в массиве с соответствующим ему индексом firstElement или lastElement(в зависимости от того, куда добавляется элемент,
вверх или вниз). Этот индекс, соответственно, увеличится или уменьшится на 1.
 Если количество элементов в деке равно 0, вставка произойдет точно так же,индексы firstElement и lastElement останутся
прежними, указывая на один и тот же элемент. Если текущее количество элементов в деке равено максимальному количеству
элементов, добавляться элементы не будет, а программа выдаст ошибку.
 C помощью методов popFront и popBack возвращается из массива arrFirst или arrLast, элемент с индексом firstElement или
lastElement, при этом индекс верхнего элемента уменьшается, а индекс нижнего увеличивается), а количество элементов в деке
уменьшается на 1.
 Если дек пуст, возвращается ошибка.
 */

/* Временная сложность алгоритма: O(n)
 При добавлении элемент в начало очереди. Этот элемент будет взят из очереди следующим при вызове метода popFront.
    - Сложность: O(1) т.к. не требуется расширение массива.
 При добавлении нового элемента в конец дека, смещаться будет индекс последнего элемента вниз, пока не достигнет 0, затем
продолжит с верхней границы массива.
 Этот элемент будет взят из очереди следующим при вызове метода popBack.
    - Сложность: O(1)  т.к. не требуется расширение массива.
 Возвращает элемент из начала очереди. Если очередь пустая, возвращает "error".
    - Сложность: O(1)
 Возвращает элемент с конца очереди. Если очередь пустая, возвращает "error".
    - Сложность: O(1)
 Так же используется цикл,котроый имеет временную сложность O(n).
*/

/* Пространственная сложность алгоритма: O(n)
 Так как я использую maxDeckSize, котроая хранит в себе все данные, переданные ей на вход, занимает O(n)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    int[] array;
    int maxDeckSize;
    int size = 0;
    int firstElement = 0;
    int lastElement = 0;

    public Solution(int maxDeckSize) {
        this.maxDeckSize = maxDeckSize;
        array = new int[maxDeckSize];
    }

    static public void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int numberCommand = Integer.parseInt(bufferedReader.readLine());
        int maxDeckSize = Integer.parseInt(bufferedReader.readLine());
        Solution testFinal1 = new Solution(maxDeckSize);
        for (int i = 0; i < numberCommand; i++) {
            String[] array = bufferedReader.readLine().split(" ");
            switch (array[0]) {
                case "push_front" -> builder.append(testFinal1.pushFront(Integer.parseInt(array[1])));
                case "push_back" -> builder.append(testFinal1.pushBack(Integer.parseInt(array[1])));
                case "pop_back" -> builder.append(testFinal1.popBack()).append("\n");
                case "pop_front" -> builder.append(testFinal1.popFront()).append("\n");
            }
        }
        System.out.println(builder.append("\n"));
    }

    public String pushFront(int value) {
        if (size == 0) {
            lastElement = firstElement;
            array[firstElement] = value;
            size++;
        } else if (size == maxDeckSize) {
            return "error" + "\n";
        } else {
            firstElement++;
            if (firstElement >= maxDeckSize) {
                firstElement = 0;
            }
            array[firstElement] = value;
            size++;
        }
        return "";
    }

    public String pushBack(int value) {
        if (size == 0) {
            firstElement = lastElement;
            array[lastElement] = value;
            size++;
        } else if (size == maxDeckSize) {
            return "error" + "\n";
        } else {
            lastElement--;
            if (lastElement < 0) {
                lastElement = maxDeckSize - 1;
            }
            array[lastElement] = value;
            size++;
        }
        return "";
    }

    public String popBack() {
        if (size != 0) {
            int arrLast = array[lastElement];
            String str = Integer.toString(arrLast);
            lastElement++;
            if (lastElement >= maxDeckSize) {
                lastElement = 0;
            }
            size--;
            return str;
        } else {
            return "error";
        }
    }

    public String popFront() {
        if (size != 0) {
            int arrFirst = array[firstElement];
            String str = Integer.toString(arrFirst);
            firstElement--;
            if (firstElement < 0) {
                firstElement = maxDeckSize - 1;
            }
            size--;
            return str;
        } else {
            return "error";
        }
    }
}