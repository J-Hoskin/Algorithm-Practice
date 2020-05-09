package DataStructures;

public class Node <T>{
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public void addToTail(T data){
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = this;

        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }
}
