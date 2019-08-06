package org.pb.basic.hashtable;

import java.util.Hashtable;
import java.util.Objects;

/**
 * 哈希表
 *
 * @author boge.peng
 * @create 2019-08-06 21:58
 */
public class HashTable<K, V> {

    private EntryLinkd<?, ?>[] table;

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

    private static class EntryLinkd<K, V> {
        Entry<K, V> head;

        public void add(Entry<K, V> entry) {
            if (Objects.isNull(head)) {
                head = entry;
                return;
            }

            Entry<K, V> current = head;
            while (Objects.nonNull(current.next)) {
                current = current.next;
            }

            current.next = entry;
        }
    }

    public V put(K key, V value) {
        if (Objects.isNull(key) || Objects.isNull(value)) {
            throw new NullPointerException();
        }

        int hash = key.hashCode();
        EntryLinkd<?,?>[] tab = table;
        int index = hash % tab.length;
        EntryLinkd entryLinkd = tab[index];


        addEntry(hash,key,value,index);

        return null;

    }

    private void addEntry(int hash, K key, V value, int index) {

    }
}
