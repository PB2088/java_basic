package org.pb.basic.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * @author bo.peng
 * @create 2019-10-09 14:42
 */
public class AvlTreeTest {
    private AvlTree<Integer> avlTree;

    @Before
    public void setUp() {
        avlTree = new AvlTree<>();

        avlTree.insert(5,5);
        avlTree.insert(8,8);
        avlTree.insert(10,10);
        avlTree.insert(16,16);
        avlTree.insert(20,20);
    }

    @Test
    public void testHeight() {
        avlTree.inOrder(avlTree.getRoot());

        //System.out.println(avlTree.getHeight(avlTree.inOrderSearch(avlTree.getRoot(),8)));
        System.out.println(avlTree.getHeight(avlTree.getRoot().getRightChild()));


    }
}
