/* Принцип работы алгоритма: 
Сначала находится искомый узел. Если такого узла нет, то возвращается корень дерева. Само дерево остается без изменений. 
Далее определяется к какому варианту относится удаляемый узел: 
   - является листом; 
   - имеет только левого потомка; 
   - имеет только правого потомка; 
   - имеет левого и правого сына. 
Далее описывается реализация каждого из перечисленных случаев: 
   - В случае, если удалемый узел является листом, то у его родителя нужно выставить null вместо ссылки на этот удялаемый узел. 
   - В случае, если удаляемый узел имеет только левого потомка, то у родительского узла нужно выставить ссылку на левого потомка 
     удаляемого узла вместо ссылки на удаляемый узел. 
   - В случае, если удаляемый узел имеет только правого потомка, то у родительского узла нужно выставить ссылку на правого потомка 
     удаляемого узла вместо ссылки на удаляемый узел. 
   - В случае, если удаляемый узел имеет и левого и правого потомка, то нужно найти элемент наследник. Это будет самый правый элемент л 
     евого поддерева. Если у этого элемента есть правое поддерево, то привязать его к родителю найденного узла справа. Найденный узел 
     делается родителем левого и правого поддеревьев и заменяет удалемый узел у его родителя. 
/* 
 
/* Временная сложность  O(logN): 
Временная сложность будет складываться из: 
   - нахождения нужного узла, в худшем слечае это O(H); 
   - удалении узла, это либо O(1), либо O(оставшейся части дерева) в случае, если после удаления узлаостаются два поддерева, при этом в
   первом пункте высота составляла менее чем O(H) + O(1). 
В итоге суммарая временная сложность в среднем составляет O(logN), где N - количество элементов в дереве. 
*/ 
 
/* Пространственная сложность O(N): 
Пространственная сложность составляет O(N), где N - количество элементов в дереве. Дополнительные структуры данных не создаются. 
*/

public class Solution {
    public static Node remove(Node root, int key) {
        if (root == null) {
            return null;
        }

        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;

        while (currentNode.getValue() != key) {
            parentNode = currentNode;
            if (key < currentNode.getValue()) {
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return root;
            }
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            root = deleteNode(root, currentNode, parentNode, isLeftChild, null);
        } else if (currentNode.getRight() == null) {
            root = deleteLeftChild(root, currentNode, parentNode, isLeftChild);
        } else if (currentNode.getLeft() == null) {
            root = deleteRightChild(root, currentNode, parentNode, isLeftChild);
        } else {
            Node heir = getHeir(currentNode);
            root = deleteNode(root, currentNode, parentNode, isLeftChild, heir);
        }

        return root;
    }

    private static Node deleteNode(Node root, Node currentNode, Node parentNode, boolean isLeftChild, Node heir) {
        if (currentNode == root) {
            root = heir;
        } else if (isLeftChild) {
            parentNode.setLeft(heir);
        } else {
            parentNode.setRight(heir);
        }
        return root;
    }

    private static Node deleteLeftChild(Node root, Node currentNode, Node parentNode, boolean isLeftChild) {
        if (currentNode == root) {
            root = currentNode.getLeft();
        } else if (isLeftChild) {
            parentNode.setLeft(currentNode.getLeft());
        } else {
            parentNode.setRight(currentNode.getLeft());
        }
        return root;
    }

    private static Node deleteRightChild(Node root, Node currentNode, Node parentNode, boolean isLeftChild) {
        if (currentNode == root) {
            root = currentNode.getRight();
        } else if (isLeftChild) {
            parentNode.setLeft(currentNode.getRight());
        } else {
            parentNode.setRight(currentNode.getRight());
        }
        return root;
    }

    public static Node getHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getLeft();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getRight();
        }

        if (heirNode != node.getLeft()) {
            parentNode.setRight(heirNode.getLeft());
            heirNode.setLeft(node.getLeft());
        }
        heirNode.setRight(node.getRight());
        return heirNode;
    }

    /**
     * Comment it before submitting
     * private static class Node {
     * private int value;
     * private Node left;
     * private Node right;
     * <p>
     * Node(Node left, Node right, int value) {
     * this.left = left;
     * this.right = right;
     * this.value = value;
     * }
     * <p>
     * public int getValue() {
     * return value;
     * }
     * <p>
     * public Node getRight() {
     * return right;
     * }
     * <p>
     * public void setRight(Node right) {
     * this.right = right;
     * }
     * <p>
     * public Node getLeft() {
     * return left;
     * }
     * <p>
     * public void setLeft(Node left) {
     * this.left = left;
     * }
     * <p>
     * public void setValue(int value) {
     * this.value = value;
     * }
     * }
     **/

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
} 