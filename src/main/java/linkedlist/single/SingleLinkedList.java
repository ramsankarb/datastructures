package linkedlist.single;

/**
 * Created by Ramshankar on 9/14/16.
 */
public class SingleLinkedList {
    public Node list;

    public SingleLinkedList(int data) {
        this.list = new Node(data);
        this.list.setNextNode(null);
    }

    public void addData(int data){
        Node addNode = new Node(data);
        addNode.setNextNode(this.list);
        this.list=addNode;
    }
    @Override
    public String toString() {
        Node currentNode=new Node();
        if(list!=null){
            System.out.println("SingleLinkedList.toString -:" + list.getData());
            currentNode=list.getNextNode();
            while (currentNode!=null){
                System.out.println("SingleLinkedList.toString :" + currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
        }
        return "true";
    }
}
