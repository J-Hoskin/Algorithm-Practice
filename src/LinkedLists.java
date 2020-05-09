import DataStructures.Node;

import java.util.HashSet;

public class LinkedLists {

    //region 2.1

    /* DESCRIPTION: Remove duplicates from an unsorted linked list */

    // Using temporary buffer
    void removeDupes1(Node<Integer> head){
        if(head == null){
            return;
        }

        HashSet<Integer> itemCount = new HashSet<>();

        Node<Integer> currentNode = head;
        Node<Integer> previousNode = null;

        while(currentNode != null){
            if(itemCount.contains(currentNode.data)){
                previousNode.next = currentNode.next;
            }
            else{
                itemCount.add(currentNode.data);
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    // Using no temporary buffer
    void removeDupes2(Node<Integer> head){
        if(head == null){
            return;
        }

        Node<Integer> currentNode = head;

        Node<Integer> comparisonNode;
        Node<Integer> previousNode = head;

        while(currentNode.next != null){
            comparisonNode = currentNode.next;
            while(comparisonNode != null){
                if(comparisonNode.data.equals(currentNode.data)){
                    previousNode.next = comparisonNode.next;
                }
                previousNode = comparisonNode;
                comparisonNode = comparisonNode.next;
            }
            currentNode = currentNode.next;
        }

    }



    //endregion
}
