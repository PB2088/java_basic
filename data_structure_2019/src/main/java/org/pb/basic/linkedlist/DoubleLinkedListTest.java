package org.pb.basic.linkedlist;

/**
 * @author boge.peng
 * @create 2019-06-11 23:04
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Hero> list = new DoubleLinkedList<>();

        list.insertAfter(new Hero(1,"宋江","及时雨"));
        list.insertAfter(new Hero(3,"吴用","智多星"));
        list.insertAfter(new Hero(2,"卢俊义","玉麒麟"));
        list.insertAfter(new Hero(4,"扈三娘","一丈青"));
        list.insertHead(list.getHead(),new Hero(0,"彭波","我是老大"));
        list.displayList();

        System.out.println("---------------remove after------------------");

        list.remove("卢");

        list.displayList();

        System.out.println(list.findByLastIndex(3));
    }
}
