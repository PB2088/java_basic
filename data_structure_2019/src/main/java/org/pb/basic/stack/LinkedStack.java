package org.pb.basic.stack;

import org.pb.basic.linkedlist.LinkedList;

/**
 * @author boge.peng
 * @create 2019-06-15 15:32
 */
public class LinkedStack<T> implements Stack<T> {
    private LinkedList<T> stackLinkedList;

    public LinkedStack() {
        stackLinkedList = new LinkedList<>();
    }

    @Override
    public void push(T value) {
        stackLinkedList.insertHead(stackLinkedList.getHead(),value);
    }

    @Override
    public T pop() {
        T temp = null;
        try {
            temp = stackLinkedList.removeFirst();
        } catch (Exception e) {
            throw new RuntimeException("栈为空,出栈失败!");
        }

        return temp;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return stackLinkedList.isEmpty();
    }

    @Override
    public T peek() {
        T temp = null;
        try {
            temp = stackLinkedList.peekFirst();
        } catch (Exception e) {
            throw new RuntimeException("栈为空!");
        }

        return temp;
    }

    @Override
    public void list() {
        stackLinkedList.displayList();
    }
}
