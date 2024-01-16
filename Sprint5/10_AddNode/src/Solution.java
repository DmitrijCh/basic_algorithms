public class Solution {
    public static Node insert(Node root, int key) {
        if (key < root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(new Node(null, null, key));
            } else {
                insert(root.getLeft(), key);
            }
        }
        if (key >= root.getValue()) {
            if (root.getRight() == null) {
                root.setRight(new Node(null, null, key));
            } else {
                insert(root.getRight(), key);
            }
        }
        return root;
    }

    private static void test() {
        Node node1 = new Node(null, null, 7);
        Node node2 = new Node(node1, null, 8);
        Node node3 = new Node(null, node2, 7);
        Node newHead = insert(node3, 6);
        assert newHead == node3;
        assert newHead.getLeft().getValue() == 6;
    }
}