package guias.guia4.LinearList;

public class Node {
    private Object head;
    private Node tail;

    public Node(Object head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node getTail() {
        return tail;
    }

    public Object getHead() {
        return head;
    }

    public void setHead(Object head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
