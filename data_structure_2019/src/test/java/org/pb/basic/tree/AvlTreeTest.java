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

        avlTree.insert(20,null);
        avlTree.insert(17,null);
        avlTree.insert(21,null);
        avlTree.insert(14,null);
        avlTree.insert(18,null);
        avlTree.insert(12,null);
        avlTree.insert(19,null);
    }

    @Test
    public void testHeight() {
        avlTree.inOrder(avlTree.getRoot());

        System.out.println(avlTree.getHeight(avlTree.inOrderSearch(avlTree.getRoot(),8)));
        System.out.println(avlTree.getHeight(avlTree.getRoot().getRightChild()));
        System.out.println(avlTree.getHeight(avlTree.getRoot().getLeftChild()));
    }

    /**
     * LL型，右旋转
     */
    @Test
    public void testRotateWithRight() {
        avlTree = new AvlTree<>();

        avlTree.insert(20,null);
        avlTree.insert(17,null);
        avlTree.insert(21,null);
        avlTree.insert(14,null);
        avlTree.insert(18,null);
        avlTree.insert(12,null);

        System.out.println("当前树根节点：" + avlTree.getRoot());
        avlTree.inOrder(avlTree.getRoot());
    }

    /**
     * RR型，左旋转
     */
    @Test
    public void testRotateWithLeft() {
        avlTree = new AvlTree<>();

        avlTree.insert(2,null);
        avlTree.insert(1,null);
        avlTree.insert(4,null);
        avlTree.insert(3,null);
        avlTree.insert(5,null);
        avlTree.insert(6,null);

        System.out.println("当前树根节点：" + avlTree.getRoot());
        avlTree.inOrder(avlTree.getRoot());
    }

    /**
     * LR型， 先左旋，再右旋
     */
    @Test
    public void testRotateWithLeftRight() {
        avlTree = new AvlTree<>();

        avlTree.insert(20,null);
        avlTree.insert(17,null);
        avlTree.insert(21,null);
        avlTree.insert(14,null);
        avlTree.insert(18,null);
        avlTree.insert(19,null);

        System.out.println("当前树根节点：" + avlTree.getRoot());
        avlTree.inOrder(avlTree.getRoot());

    }

    /**
     * RL型， 先右旋，再左旋
     */
    @Test
    public void testRotateWithRightLeft() {
        avlTree = new AvlTree<>();

        avlTree.insert(5,null);
        avlTree.insert(8,null);
        avlTree.insert(7,null);

        System.out.println("当前树根节点：" + avlTree.getRoot());
        avlTree.inOrder(avlTree.getRoot());

    }
}
