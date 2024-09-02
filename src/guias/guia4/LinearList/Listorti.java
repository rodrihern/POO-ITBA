package guias.guia4.LinearList;

public class Listorti implements LinearList{
    private Node first;
    private Node last;

    @Override
    public void add(Object obj) {
        Node newNode = new Node(obj, null);
        if(first == null) {
            first = last = newNode;
        }
        else {
            last.setTail(newNode);
            last = newNode;
        }
    }

    private Node findNode(int i) {
        if(i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int j = 0;
        Node current = first;
        while(current != null) {
            if(i == j) {
                return current;
            }
            current = current.getTail();
            j++;
        }
        throw new IllegalArgumentException("No element at index %d".formatted(i));
    }

    @Override
    public Object get(int i) {
        return findNode(i).getHead();
    }

    @Override
    public void set(int i, Object obj) {
        findNode(i).setHead(obj);
    }

    @Override
    public void remove(int i) {
        if(i < 0 || first == null) {
            throw new IndexOutOfBoundsException();
        }
        if(i == 0) {
            first = first.getTail();
        } else {
            Node prev = findNode(i-1);
            if(prev.getTail() == null) {
                throw new IndexOutOfBoundsException();
            }
            prev.setTail(prev.getTail().getTail());
        }

    }

    @Override
    public int indexOf(Object obj) {
        Node current = first;
        for(int i = 0; current != null; i++, current = current.getTail()) {
            if(obj.equals(current.getHead())) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public int size() {
        int i;
        Node current = first;
        for(i = 0; current != null; i++) {
            current = current.getTail();
        }
        return i;
    }

}
