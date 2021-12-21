package datastrucutres.trees;

public class Node {
    int key;
    String value;
    Node leftChild, rightChild;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        leftChild = rightChild = null;
    }
}
