/* Принцип работы алгоритма:
 В основу взят алгоритм Прима. Начиная с первой вершины определяем, какое ребро, исходящее из этой вершины имеет
наибольший вес. Для этого ребра добавляются в кучу, что дает определение ребра с максимальным весом за O(1). \
 За каждую итерацию в максимальное остовное дерево (в соответствующие структуры данных) добавляются по одному ребру и
одной вершине.
 Если после обработки всех доступных из первой вершины вершин в массиве не посещенных вершин останутся вершины, значит
граф состоит более чем из одной компоненты связанности.
 После нахождения максимального остовного дерева суммируются все веса этого дерева.
*/

/* Временная сложность O(E * logV):
 Временная сложность будет складываться из:
    - просмотра вершин, которые находятся на концах ребер с максимальным весом, O(logV), так как элементы в куче, а для
    нее добавление за логарифм от глубины, а извлечение за единицу;
    - просмотра всех ребер O(E).
 В итоге суммарная временная сложность O(E * logV).
*/

/* Пространственная сложность O(V + E):
 Пространственная сложность складывается из:
    - множества для добавляемых вершин, в худшем случае O(V), где V - количество вершин;
    - множества для еще не добавленных вершин, в худшем случае O(V);
    - массива для хранения ребер максимального остовного дерева, в худшем случае O(E), где E - количество ребер.
    - кучи для хранения добавляемых ребер, в худшем случае O(E).
 Итоговая пространственная сложность будет O(V + E).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Algorithm algorithm = new Algorithm();
        algorithm.inputUndirectGraph();
        System.out.println(algorithm.findMaxSpanningTree());
    }
}

class Algorithm {

    static class Edge {
        int startVertex;
        int endVertex;
        int weight;

        public Edge(int startVertex, int endVertex, int weight) {
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.weight = weight;
        }

        public int getStartVertex() {
            return startVertex;
        }

        public int getEndVertex() {
            return endVertex;
        }

        public int getWeight() {
            return weight;
        }
    }

    Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
    int vertexQuantity;
    int edgeQuantity;
    int[][] weights;
    Set<Integer> added = new HashSet<>();
    Set<Integer> notAdded = new HashSet<>();
    List<Edge> maxSpanningTree = new ArrayList<>();
    Queue<Edge> edges = new PriorityQueue<>((o1, o2) -> o2.getWeight() - o1.getWeight());

    public void inputUndirectGraph() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        vertexQuantity = Integer.parseInt(stringTokenizer.nextToken());
        edgeQuantity = Integer.parseInt(stringTokenizer.nextToken());
        weights = new int[vertexQuantity + 1][vertexQuantity + 1];
        for (int i = 0; i < edgeQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int firstVertex = Integer.parseInt(stringTokenizer.nextToken());
            int secondVertex = Integer.parseInt(stringTokenizer.nextToken());
            if (secondVertex == firstVertex) {
                continue;
            }
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            if (!adjacentMap.containsKey(firstVertex)) {
                List<Integer> list = new ArrayList<>();
                list.add(secondVertex);
                adjacentMap.put(firstVertex, (ArrayList<Integer>) list);
            } else {
                adjacentMap.get(firstVertex).add(secondVertex);
            }

            if (!adjacentMap.containsKey(secondVertex)) {
                List<Integer> list = new ArrayList<>();
                list.add(firstVertex);
                adjacentMap.put(secondVertex, (ArrayList<Integer>) list);
            } else {
                adjacentMap.get(secondVertex).add(firstVertex);
            }
            if (weight > weights[firstVertex][secondVertex]) {
                weights[firstVertex][secondVertex] = weight;
                weights[secondVertex][firstVertex] = weight;
            }
        }

        for (int i = 1; i <= vertexQuantity; i++) {
            adjacentMap.putIfAbsent(i, null);
        }
    }

    public String findMaxSpanningTree() {
        notAdded.addAll(adjacentMap.keySet());
        int startVertex = 1;
        addVertex(startVertex);

        while (!notAdded.isEmpty() && !edges.isEmpty()) {
            Edge maxEdge = extractMax((PriorityQueue<Edge>) edges);
            if (notAdded.contains(maxEdge.getEndVertex())) {
                maxSpanningTree.add(maxEdge);
                addVertex(maxEdge.getEndVertex());
            }
        }

        if (!notAdded.isEmpty()) {
            return "Oops! I did it again";
        }

        int resultWeight = 0;
        for (Edge edge : maxSpanningTree) {
            resultWeight += weights[edge.getStartVertex()][edge.getEndVertex()];
        }

        return String.valueOf(resultWeight);
    }

    private void addVertex(int vertex) {
        added.add(vertex);
        notAdded.remove(vertex);
        if (adjacentMap.get(vertex) != null) {
            for (Integer adjacentVertex : adjacentMap.get(vertex)) {
                if (notAdded.contains(adjacentVertex)) {
                    edges.add(new Edge(vertex, adjacentVertex, weights[vertex][adjacentVertex]));
                }
            }
        }
    }

    private Edge extractMax(PriorityQueue<Edge> edges) {
        return edges.poll();
    }
}
