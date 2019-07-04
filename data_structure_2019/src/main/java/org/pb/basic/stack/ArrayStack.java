package org.pb.basic.stack;

/**
 * @author boge.peng
 * @create 2019-06-15 14:31
 */
public class ArrayStack<T> implements Stack<T> {

    /**
     * 栈最大大小
     */
    private int maxSize;
    private T[] stackArray;
    /**
     * 栈顶指针
     */
    private int top;

    /**
     * 默认栈大小
     */
    private static final int DEFAULT_STACK_SIZE = 5;

    private static final int MAX_STACK_SIZE = 64;

    public ArrayStack(int size) {
        maxSize = size <= 0 ? DEFAULT_STACK_SIZE : size > MAX_STACK_SIZE ? MAX_STACK_SIZE : size;
        stackArray = (T[]) new Object[maxSize];

        top = -1;
    }

    @Override
    public void push(T value) {
        if (isFull()) {
            System.out.println("栈已满,入栈失败!");
            return;
        }
        stackArray[++top] = value;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空,出栈失败!");
        }
        return stackArray[top--];
    }

    @Override
    public boolean isFull() {
        return top == maxSize -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空,出栈失败!");
        }
        return stackArray[top];
    }

    @Override
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        for(int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stackArray[i]);
        }
    }
}
