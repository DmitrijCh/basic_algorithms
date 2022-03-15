public class Solution {
    public static void solution(Node<String> head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}