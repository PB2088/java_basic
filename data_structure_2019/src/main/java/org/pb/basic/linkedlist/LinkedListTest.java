package org.pb.basic.linkedlist;

import org.junit.Test;

/**
 * @author boge.peng
 * @create 2019-06-09 18:15
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Hero> list = new LinkedList<>();

        list.insertAfter(new Hero(1,"宋江","及时雨"));
        list.insertAfter(new Hero(3,"吴用","智多星"));
        list.insertAfter(new Hero(2,"卢俊义","玉麒麟"));
        list.insertAfter(new Hero(4,"扈三娘","一丈青"));

        //boolean result = list.remove(3);
        list.insertHead(list.getHead(),new Hero(0,"彭波","我是老大"));
        //System.out.println(result);

        list.displayList();

        System.out.println("---------------");
        list.remove(4);
        list.insertAfter(new Hero(99,"张顺","浪里白条"));
        System.out.println(list.findByLastIndex(3));
        System.out.println("---------------");
        //list.remove(new Hero(1,"宋江","及时雨"));
        list.displayList();

        System.out.println("---------------反转链表---------------");
        list.reverse();
        list.displayList();

    }

    @Test
    public void testLinkedListMerge() {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.insertAfter(1);
        linkedList1.insertAfter(3);
        linkedList1.insertAfter(5);
        linkedList1.insertAfter(7);
        linkedList1.insertAfter(9);
        linkedList1.insertAfter(11);
        linkedList1.insertAfter(17);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.insertAfter(2);
        linkedList2.insertAfter(4);
        linkedList2.insertAfter(6);
        linkedList2.insertAfter(8);
        linkedList2.insertAfter(10);
        linkedList2.insertAfter(12);
        linkedList2.insertAfter(14);
        linkedList2.insertAfter(16);

        LinkedList<Integer> mergeLinkedList = LinkedList.merge(linkedList1, linkedList2);
        mergeLinkedList.displayList();
        System.out.println("---------");
        linkedList1.displayList();
        System.out.println("---------");
        linkedList2.displayList();
    }
}
