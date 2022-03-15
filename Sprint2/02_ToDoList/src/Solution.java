class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}

public class Solution {
    public static void solution(Node<String> head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("f", null);
        Node<String> node2 = new Node<>("xqpaljn ybtaxc iep", node3);
        Node<String> node1 = new Node<>("zaaxv lixopvt nwexmhv", node2);
        Node<String> node0 = new Node<>("brbawcphm cnbd vjytjmnrz ctbgxdptg", node1);
        solution(node0);
    }
}