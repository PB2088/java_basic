package org.pb.basic.tree;

import org.junit.Test;

/**
 * @author bo.peng
 * @create 2019-08-14 12:33
 */
public class BinaryTreeTest {

    private BinaryTree<Hero> binaryTree;

    @Test
    public void testInser() {
        binaryTree = new BinaryTree();

        binaryTree.insert(005,new Hero(005,"宋江"));
        binaryTree.insert(003,new Hero(003,"卢俊义"));
        binaryTree.insert(006,new Hero(006,"吴用"));
        binaryTree.insert(002,new Hero(002,"林冲"));
        binaryTree.insert(004,new Hero(004,"鲁智深"));
        binaryTree.insert(007,new Hero(007,"花荣"));

        System.out.println("中序遍历:");
        binaryTree.inOrder(binaryTree.getRoot());

        System.out.println("前序遍历:");
        binaryTree.preOrder(binaryTree.getRoot());

        System.out.println("后序遍历:");
        binaryTree.postOrder(binaryTree.getRoot());

    }

}
