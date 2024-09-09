package guias.guia5.Stack;

public interface AccessStack<E> extends Stack<E> {

    int getPopAccesses();

    int getPushAccesses();
}
