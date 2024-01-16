public class Solution {
    public static boolean treeSolution(Node head) {
        return isAnagramTree(head.left, head.right);
    }

    public static boolean isAnagramTree(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.value == right.value) {
            return isAnagramTree(left.left, right.right) && isAnagramTree(left.right, right.left);
        } else {
            return false;
        }
    }

    private static void test() {
        Node node1 = new Node(3, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(4, null, null);
        Node node4 = new Node(3, null, null);
        Node node5 = new Node(2, node1, node2);
        Node node6 = new Node(2, node3, node4);
        Node node7 = new Node(1, node5, node6);
        assert treeSolution(node7);
    }
}