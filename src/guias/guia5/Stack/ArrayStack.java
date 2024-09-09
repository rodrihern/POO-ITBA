package guias.guia5.Stack;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private E[] elements;
    private static final int INITIAL_DIM = 10;
    private int idx;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elements = (E[]) new Object[INITIAL_DIM];
        idx = 0;
    }


    private void resize() {
        elements = Arrays.copyOf(elements, elements.length + INITIAL_DIM);
    }


    @Override
    public void push(E elem) {
        if(idx == elements.length) {
            resize();
        }
        elements[idx++] = elem;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[idx - 1];
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[--idx];
    }

    @Override
    public boolean isEmpty() {
        return idx == 0;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = idx-1; i >= 0; i--) {
            str.append(" %s ,".formatted(elements[i]));
        }
        str.setCharAt(str.length() - 1, ']');

        return str.toString();
    }




}
