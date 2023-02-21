public class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
    public Color color;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", color=" + color +
                '}';
    }

    public Node(int value, boolean isRoot) {
        this.value = value;
        if (isRoot) {
            this.color = Color.BLACK;
        }
        else {
            this.color = Color.RED;
        }
    }
    public Node(){

    }
}
