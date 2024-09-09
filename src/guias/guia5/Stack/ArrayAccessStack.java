package guias.guia5.Stack;

public class ArrayAccessStack<E> extends ArrayStack<E> implements AccessStack<E> {

    private int pops;
    private int pushes;

    @Override
    public E pop() {
        pops++;
        return super.pop();
    }

    @Override
    public void push(E elem) {
        pushes++;
        super.push(elem);
    }

    @Override
    public int getPopAccesses() {
        return pops;
    }

    @Override
    public int getPushAccesses() {
        return pushes;
    }
}
