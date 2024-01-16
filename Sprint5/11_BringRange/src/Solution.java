import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution {
    public static void printRange(Node root, int L, int R, BufferedWriter writer) throws IOException {
        if (root == null) {
            return;
        }

        if (root.getValue() < L) {
            printRange(root.getRight(), L, R, writer);
        } else if (root.getValue() > R) {
            printRange(root.getLeft(), L, R, writer);
        } else {
            printRange(root.getLeft(), L, R, writer);
            writer.write(String.valueOf(root.getValue()));
            writer.write("\n");
            printRange(root.getRight(), L, R, writer);
        }

        writer.flush();
    }

    private static void test() throws IOException {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(null, node1, 1);
        Node node3 = new Node(null, null, 8);
        Node node4 = new Node(null, node3, 8);
        Node node5 = new Node(node4, null, 9);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node2, node6, 5);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        printRange(node7, 2, 8, writer);
        writer.flush();
    }
}