package org.pb.basic.hashtable;

import org.junit.Before;
import org.junit.Test;

/**
 * @author boge.peng
 * @create 2019-08-07 23:45
 */
public class HashTableTest {

    private HashTable<Integer,Employee> employeeHashTable;

    private static final int INIT_SIZE = 20;

    @Before
    public void setUp() {
        employeeHashTable = new HashTable<>(INIT_SIZE);

        employeeHashTable.put(7988,new Employee(7988,"Scott"));
        employeeHashTable.put(7376,new Employee(7376,"Smith"));
        employeeHashTable.put(7645,new Employee(7645,"皮皮虾"));
        employeeHashTable.put(7888,new Employee(7888,"波波"));
        employeeHashTable.put(7999,new Employee(7999,"三狗子"));
        employeeHashTable.put(7748,new Employee(7748,"大坑"));
        employeeHashTable.put(7980,new Employee(7980,"二狗子"));
    }

    @Test
    public void testHashTableList() {
        employeeHashTable.list();
    }

    @Test
    public void testHashTableGet() {
        System.out.println(employeeHashTable.get(7980));
    }
}
