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
        Node<Integer> previousNode = head; // This doesn't need to be used if you instead use comparisonNode.next for the comparison

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

    //region 2.2

    /* DESCRIPTION: Implement a way to find the Kth element from the end of a singly linked list */
    public int returnKthElement(Node<Integer> head, int k){
        if(head == null || head.next == null){
            return -1;
        }

        Node<Integer> markerNode = head;
        Node<Integer> runnerNode = head.next;
        int currentIteration = 1;

        while(runnerNode != null){
            if(currentIteration < k){
                runnerNode = runnerNode.next;
                currentIteration++;
            }
            else{
                markerNode = markerNode.next;
                runnerNode = runnerNode.next;
            }
        }

        return currentIteration == k ? markerNode.data : -1;
    }

    //endregion
}
