import DataStructures.Node;

import static Factory.DataFactory.createMatrix;

public class Core {
    public static void main(String[] args){

        Node<Integer> head = new Node<>(6);
        head.addToTail(5);
        head.addToTail(3);
        head.addToTail(12);
        head.addToTail(8);
        head.addToTail(5);

        LinkedLists t = new LinkedLists();
        t.removeDupes2(head);

        Node currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }


    }
}
