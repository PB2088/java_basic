package org.pb.basic.stack;

/**
 * 栈接口
 * @author boge.peng
 * @create 2019-06-15 11:13
 */
public interface Stack<T> {

    /**
     * 入栈
     * @param value
     */
    void push(T value);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 判断栈满
     * @return
     */
    boolean isFull();

    /**
     * 判断栈空
     * @return
     */
    boolean isEmpty();

    /**
     * 查看栈顶元素
     * @return
     */
    T peek();

    void list();
}
