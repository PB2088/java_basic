package org.pb.basic.hashtable;

import org.pb.basic.linkedlist.LinkedList;
import org.pb.util.ToolsUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * 哈希表
 *
 * @author boge.peng
 * @create 2019-08-06 21:58
 */
public class HashTable<K, V> {

    private EntryLinked<?, ?>[] table;

    private int size;

    /** 默认大小 */
    private static final int DEFAULT_SIZE = 10;

    private static final int MAX_SIZE = Integer.MAX_VALUE;

    public HashTable(int size) {
        this.size = size < 0 ? DEFAULT_SIZE : size > MAX_SIZE ? MAX_SIZE : size;
        init();
    }

    private void init() {
        table = new EntryLinked[size];
        for (int i = 0; i < size; i++) {
            table[i] = new EntryLinked<>();
        }
    }

    private static class Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    private static class EntryLinked<K, V> {
        Entry<K, V> head;

        public void add(Entry<K, V> entry) {
            if (Objects.isNull(head)) {
                head = entry;
                return;
            }

            Entry<K, V> current = head;
            while (Objects.nonNull(current.next)) {
                if (entry.hash == current.hash && entry.key.equals(current.key)) {
                    current.value = entry.value;
                    break;
                }
                current = current.next;
            }

            if (entry.hash == current.hash && entry.key.equals(current.key)) {
                current.value = entry.value;
            } else {
                current.next = entry;
            }

        }

        public void displayList(int no) {
            if (ToolsUtils.isEmpty(this.head)) {
                System.out.printf("第%d个链表空空如也,没有数据~~\n",(no+1));
                return;
            }

            System.out.printf("第%d个链表数据:\n",(no+1));
            Entry current = this.head;
            while (Objects.nonNull(current.next)) {
                System.out.println(current.value);
                current = current.next;
            }
            System.out.println(current.value);
        }

        public V get(int hash, K key) {
            if (Objects.isNull(head)) {
                return null;
            }

            Entry<K, V> current = head;
            while (Objects.nonNull(current.next)) {
                if (hash == current.hash && key.equals(current.key)) {
                    return current.value;
                }
                current = current.next;
            }

            if (hash == current.hash && key.equals(current.key)) {
                return current.value;
            }

            return null;
        }
    }

    public void put(K key, V value) {
        if (Objects.isNull(key) || Objects.isNull(value)) {
            throw new NullPointerException();
        }

        EntryLinked<?, ?>[] tab = table;

        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;

        EntryLinked entryLinked = tab[index];

        entryLinked.add(new Entry(hash,key,value));
    }

    public V get(K key) {
        if (Objects.isNull(key)) {
            throw new NullPointerException();
        }

        EntryLinked<?, ?>[] tab = table;

        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;

        EntryLinked entryLinked = tab[index];
        return (V) entryLinked.get(hash,key);
    }

    public void list() {
        for (int i = 0; i < table.length; i++) {
            table[i].displayList(i);
        }
    }
}
