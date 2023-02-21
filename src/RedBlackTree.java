public class RedBlackTree {
    public Node root;

    public boolean addNode(int value) {
        if (root == null) {
            root = new Node(value, true);
            return false;
        } else {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild == null) {
                    node.leftChild = new Node(value, false);
                    return true;
                } else {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                }
            } else if (node.value < value) {
                if (node.rightChild == null) {
                    node.rightChild = new Node(value, false);
                    return true;
                } else {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                }
            } else {
                return false;
            }
        }
    }

    private void colorSwap(Node node) {
        node.color = Color.RED;
        node.leftChild.color = Color.BLACK;
        node.rightChild.color = Color.BLACK;
    }

    private Node leftTurn(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = node.rightChild;
        betweenChild.rightChild = node;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node rightTurn(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        betweenChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needBalance;
        do {
            needBalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                    needBalance = true;
                    result = rightTurn(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
            result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needBalance = true;
                result = leftTurn(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
            result.rightChild != null && result.rightChild.color == Color.RED) {
                needBalance = true;
                colorSwap(result);
            }
        } while (needBalance);
        return result;
    }
}
