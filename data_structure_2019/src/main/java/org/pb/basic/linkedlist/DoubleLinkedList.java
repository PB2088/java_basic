package org.pb.basic.linkedlist;

import java.util.Objects;

/**
 * @author boge.peng
 * @create 2019-06-09 16:49
 */
public class DoubleLinkedList<E> {
    private Node head;

    private int size;

    public DoubleLinkedList() {
        head = new Node(null, null, null);
        size = 0;
    }

    /**
     * 从链表末尾插入链表元素
     *
     * @param value
     */
    public void insertAfter(E value) {
        insertAfter(new Node(null, value, null));
    }

    /**
     * 从链表末尾插入链表元素
     *
     * @param node
     */
    public void insertAfter(Node<E> node) {
        if (Objects.isNull(head.next)) {
            head.next = node;
            node.prev = head;
            size++;
            return;
        }

        Node current = head;
        while (Objects.nonNull(current)) {
            if (Objects.isNull(current.next)) {
                break;
            }
            current = current.next;
        }

        current.next = node;
        node.prev = current;
        size++;
    }

    /**
     * 从链表头部插入链表元素
     *
     * @param value
     */
    public void insertHead(Node<E> first, E value) {
        insertHead(first, new Node(null, value, null));
    }

    public void insertHead(Node<E> first, Node node) {
        if (!isEmpty()) {
            first.next.prev = node;
        }
        node.next = first.next;
        first.next = node;
        node.prev = first;

        size++;
    }

    /**
     * 按索引位置查找链表节点
     *
     * @param index
     */
    public E findByLastIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("无效的索引位置:" + index);
        }

        Node<E> current = head.next;
        for (int i = 0; i < size - index; i++) {
            current = current.next;
        }

        return current.item;

    }

    public boolean remove(Object o) {

        if (Objects.isNull(o)) {
            return false;
        }

        Node<E> current = head.next;
        while (Objects.nonNull(current)) {
            if (current.item.toString().indexOf(o.toString()) != -1) {
                current.prev.next = current.next;
                if (Objects.nonNull(current.next)) {
                    current.next.prev = current.prev;
                }

                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }


    public boolean isEmpty() {
        return Objects.isNull(head.next);
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("链表为空!");
            return;
        }

        Node<E> current = head.next;
        while (Objects.nonNull(current)) {
            if (Objects.isNull(current)) {
                break;
            }
            System.out.print("[");
            if (Objects.nonNull(current.prev)) {
                System.out.print(current.prev.item + "-->");
            }
            System.out.print(current.item + "-->");

            if (Objects.nonNull(current.next)) {
                System.out.print(current.next.item);
            }
            System.out.println("]");
            current = current.next;
        }
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
