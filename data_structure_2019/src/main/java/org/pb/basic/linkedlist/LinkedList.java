package org.pb.basic.linkedlist;

import java.util.Objects;

/**
 * @author boge.peng
 * @create 2019-06-09 16:49
 */
public class LinkedList<E> {
    private Node head;

    private int size;

    public LinkedList() {
        head = new Node(null, null);
        size = 0;
    }

    /**
     * 从链表末尾插入链表元素
     *
     * @param value
     */
    public void insertAfter(E value) {
        insertAfter(new Node(value, null));
    }

    /**
     * 从链表末尾插入链表元素
     *
     * @param node
     */
    public void insertAfter(Node<E> node) {
        if (Objects.isNull(head.next)) {
            head.next = node;
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
        size++;
    }

    /**
     * 从链表头部插入链表元素
     *
     * @param value
     */
    public void insertHead(Node<E> first,E value) {
        insertHead(first,new Node(value,null));
    }

    public void insertHead(Node<E> first,Node node) {
        node.next = first.next;
        first.next = node;

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

        Node<E> current = head;
        while (Objects.nonNull(current)) {
            if (Objects.nonNull(current.next) && current.next.item.toString().indexOf(o.toString()) != -1) {
                current.next = current.next.next;

                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("链表为空,删除失败!");
        }

        Node temp = head.next;
        head.next = temp.next;

        return (E) temp.item;
    }

    /**
     * 反转链表
     */
    public void reverse() {
        if (isEmpty()) {
            System.out.println("链表为空!");
            return;
        }

        Node<E> reverseHead = new Node<>(null,null);
        Node<E> current = head.next;
        while (Objects.nonNull(current)) {

            Node<E> currentNex = current.next;
            head.next = currentNex;

            current.next = reverseHead.next;
            reverseHead.next = current;

            current = currentNex;
        }

        head = reverseHead;
        reverseHead = null;
    }

    /**
     * 合并两个有序的单链表,合并之后的链表依然有序
     * @param linkedList1
     * @param linkedList2
     * @return
     */
    public static LinkedList<Integer> merge(LinkedList<Integer> linkedList1,LinkedList<Integer> linkedList2) {

        if (linkedList1.isEmpty() || linkedList2.isEmpty()) {
            System.out.println("待合并的链表为空,无法进行合并!");
            return null;
        }

        Node current1 = linkedList1.getHead().next;
        Node current2 = linkedList2.getHead().next;

        LinkedList<Integer> newLinkedList = new LinkedList<>();
        while (Objects.nonNull(current1) && Objects.nonNull(current2)) {
            if (Integer.compare((Integer) current1.item,(Integer) current2.item) > 0) {
                newLinkedList.insertAfter(((Integer) current2.item).intValue());
                current2 = current2.next;
                continue;
            }
            if (Integer.compare((Integer) current1.item,(Integer) current2.item) < 0) {
                newLinkedList.insertAfter(((Integer) current1.item).intValue());
                current1 = current1.next;
                continue;
            }
            if (Integer.compare((Integer) current1.item,(Integer) current2.item) == 0) {
                newLinkedList.insertAfter(((Integer) current1.item).intValue());
                newLinkedList.insertAfter(((Integer) current2.item).intValue());
                current1 = current1.next;
                current2 = current2.next;
                continue;
            }
        }

        if (Objects.nonNull(current1)) {
            newLinkedList.insertAfter(current1);
        }

        if (Objects.nonNull(current2)) {
            newLinkedList.insertAfter(current2);
        }

        return newLinkedList;
    }

    public boolean isEmpty() {
        return Objects.isNull(head.next);
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("空空如也,没有数据~~");
            return;
        }

        Node<E> current = head;
        while (Objects.nonNull(current)) {
            if (Objects.isNull(current.next)) {
                break;
            }
            System.out.println(current.next.item);

            current = current.next;
        }
    }


    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public Node getHead() {
        return head;
    }

    public E peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("链表为空!");
        }
        return (E) head.next.item;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
