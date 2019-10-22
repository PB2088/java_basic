package org.pb.basic.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * 红黑树测试
 * @author bo.peng
 * @create 2019-10-22 16:14
 */
public class RedBlackTreeTest {

    private RedBlackTree<Integer> redBlackTree;

    @Before
    public void setUp() {
        redBlackTree = new RedBlackTree<>();
    }

    @Test
    public void testInsert() {
        redBlackTree.insert(50,50);
        redBlackTree.insert(35,35);
        redBlackTree.insert(78,78);
        redBlackTree.insert(27,27);
        redBlackTree.insert(45,45);
        redBlackTree.insert(56,56);
        redBlackTree.insert(90,90);
        redBlackTree.insert(40,40);
        redBlackTree.insert(48,48);

        System.out.println("当前根节点：" +redBlackTree.getRoot());
        redBlackTree.inOrder(redBlackTree.getRoot());
    }
}
