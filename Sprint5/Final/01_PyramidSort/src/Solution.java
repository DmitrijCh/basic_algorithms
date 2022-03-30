/* Принцип работы алгоритма:
 Алгоритм состоит из двух частей:
    - добавления элементов в кучу;
    - извлечения элементов из кучи.
 После этого исходный массив ялвяется упорядоченным. Куча реализована на ArrayList. Добавление элементов проихсодит в конец0
массива. Далее запускается механизм siftUp. В котором элемент сравнивается элемент со своим родителем. Функция siftUp выполняется
рекурсивно до тех пор, пока либо не дойдет до вершины кучи, либо функция сравнения элементов не вернет fail.
 После того, как все элементы добавлены в кучу, начинается процесс извлечения самого максимального элементе, то есть берется вершина кучи.
 Каждый раз, когда удаляется вершина в куче, она заменяется заключительным элементом из кучи и запускается механизм siftDown.
 Элемент сравнивается со своими потомками. Функция выполняется рекурсивно до тех пор, пока либо не пройдет всю высоту кучи,
либо пока функция сравнения не вернет fail.
 После того, как все элементы извлечены из кучи в первоначальный массив, он становится упорядоченным.
*/

/* Временная сложность:
 Временная сложность будет складываться из:
   - помещения элемента в кучу     O(H);
   - извлечения элемента из кучи   O(H).
 Где H - высота кучи. Так как куча заполняется строго последовательно слева направо, то высота не превосходит logN.
 Таких итераций будет совершено N раз, где N - количество элементов во входном массиве.
 Таким образом итоговая сложность алгоритма будет составлять O(NlogN).
*/

/* Пространственная сложность:
 Пространственная сложность в реализованном алгоритме будет складываться из:
   - массив для кучи;
   - рекурсивных вызовов siftUp (стек вызовов). В худшем случае произведение количество элементов в куче на глубину рекурсии (высоту кучи), то есть O(NlogN);
   - рекурсивынх вызовов siftDown (стек вызовов). В худшем случае произведение количество элементов в куче на глубину рекурсии (высоту кучи), то есть O(NlogN).
 Таким образом суммарная пространственная сложность будет составлять O(NlogN), где N - количество элементов во входном массиве.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int participantQuantity = Integer.parseInt(bufferedReader.readLine());
        Participant[] participants = new Participant[participantQuantity];
        for (int i = 0; i < participantQuantity; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String login = stringTokenizer.nextToken();
            int solvedProblems = Integer.parseInt(stringTokenizer.nextToken());
            int penalty = Integer.parseInt(stringTokenizer.nextToken());
            participants[i] = new Participant(login, solvedProblems, penalty);
        }

        heapSort(participants);
        result(participants);
    }

    public static void heapSort(Participant[] participants) {
        List<Participant> heap = new ArrayList<>();

        for (Participant participant : participants) {
            heapAdd(heap, participant);
        }

        for (int j = 0; j < participants.length; j++) {
            participants[j] = getMaxPriority(heap);
        }
    }

    private static void heapAdd(List<Participant> heap, Participant key) {
        heap.add(key);
        siftUp(heap, heap.size() - 1);
    }

    private static Participant getMaxPriority(List<Participant> heap) {
        Participant result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        siftDown(heap, 0);
        return result;
    }


    private static void siftDown(List<Participant> heap, int index) {
        int left = 2 * index + 1;
        int right = left + 1;
        if (left >= heap.size()) {
            return;
        }

        int indexLargest;
        if (right < heap.size() && isLess(heap.get(left), heap.get(right))) {
            indexLargest = right;
        } else {
            indexLargest = left;
        }

        if (isLess(heap.get(index), heap.get(indexLargest))) {
            swap(heap, index, indexLargest);
            siftDown(heap, indexLargest);
        }
    }

    private static void siftUp(List<Participant> heap, int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = (index - 1) / 2;
        if (isGreater(heap.get(parentIndex), heap.get(index))) {
            swap(heap, parentIndex, index);
            siftUp(heap, parentIndex);
        }
    }

    static boolean isLess(Participant participant1, Participant participant2) {
        return compare(participant1, participant2) < 0;
    }

    static boolean isGreater(Participant participant1, Participant participant2) {
        return compare(participant1, participant2) > 0;
    }

    private static int compare(Participant participant1, Participant participant2) {
        if (participant1.getProblems() < participant2.getProblems()) {
            return -1;
        } else if (participant1.getProblems() > participant2.getProblems()) {
            return 1;
        }
        if (participant1.getPenalty() > participant2.getPenalty()) {
            return -1;
        } else if (participant1.getPenalty() < participant2.getPenalty()) {
            return 1;
        }
        return participant1.getLogin().compareTo(participant2.getLogin());
    }

    private static void swap(List<Participant> heap, int index1, int index2) {
        Participant tmp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, tmp);
    }

    private static void result(Participant[] participants) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Participant participant : participants) {
            stringBuffer.append(participant.getLogin()).append("\n");
        }
        System.out.println(stringBuffer);
    }
}

class Participant implements Comparable<Participant> {
    private final String login;
    private final int problems;
    private final int penalty;

    public Participant(String login, int solvedProblems, int penalty) {
        this.login = login;
        this.problems = solvedProblems;
        this.penalty = penalty;
    }

    public String getLogin() {
        return login;
    }

    public int getProblems() {
        return problems;
    }

    public int getPenalty() {
        return penalty;
    }

    @Override
    public int compareTo(Participant that) {
        int result = Integer.compare(this.getProblems(), that.getProblems());
        if (result == 0) {
            result = Integer.compare(that.getPenalty(), this.getPenalty());
        }
        if (result == 0) {
            result = this.getLogin().compareTo(that.getLogin());
        }
        return result;
    }
}
