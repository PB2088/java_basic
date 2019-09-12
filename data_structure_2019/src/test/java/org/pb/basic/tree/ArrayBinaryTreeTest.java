package org.pb.basic.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * @author boge.peng
 * @create 2019-08-19 22:51
 */
public class ArrayBinaryTreeTest {

    private long[] array;

    private ArrayBinaryTree arrayBinaryTree;

    @Before
    public void setUp() {
        array = new long[]{1,2,3,4,5,6,7,8,9};
        arrayBinaryTree = new ArrayBinaryTree(array);
    }

    @Test
    public void testPreOrder() {
        arrayBinaryTree.preOrder();
    }

}
