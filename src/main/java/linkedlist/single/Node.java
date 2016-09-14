package linkedlist.single;

/**
 * Created by Ramshankar on 9/14/16.
 */
public class Node {

    public int data;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node nextNode;





}
