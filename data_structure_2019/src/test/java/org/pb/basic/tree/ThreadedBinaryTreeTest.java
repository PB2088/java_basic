package org.pb.basic.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author boge.peng
 * @create 2019-08-19 22:51
 */
public class ThreadedBinaryTreeTest {

    private Hero[] array;

    private ThreadedBinaryTree threadedBinaryTree;

    @Before
    public void setUp() {
        array = Arrays.asList(new Hero(1, "宋江"), new Hero(2, "卢俊义")
                , new Hero(3, "吴用"), new Hero(4, "公孙胜")
                , new Hero(5, "关胜"), new Hero(6, "林冲")
                , new Hero(7, "秦明"), new Hero(8, "呼延灼")
                , new Hero(9, "花荣")
        ).toArray(new Hero[0]);

        threadedBinaryTree = new ThreadedBinaryTree();

        threadedBinaryTree.createBinaryTree(array,0);
    }

    @Test
    public void testCreateBinaryTree() {
        System.out.println(threadedBinaryTree.getRoot());
    }

    @Test
    public void testInOrderThreadedNodes() {
        threadedBinaryTree.inOrderThreadedNodes();
    }

    @Test
    public void testInOrderThreadedList() {

        threadedBinaryTree.inOrderThreadedNodes();

        threadedBinaryTree.inOrderThreadedList();
    }

    @Test
    public void testPreOrderThreadedNodes() {
        threadedBinaryTree.preOrderThreadedNodes();
    }


    @Test
    public void testPreOrderThreadedList() {
        threadedBinaryTree.preOrderThreadedNodes();

        threadedBinaryTree.preOrderThreadedList();
    }

    @Test
    public void testPostOrderThreadedNodes() {
        threadedBinaryTree.postOrderThreadedNodes();
    }

    @Test
    public void testPostOrderThreadedList() {
        threadedBinaryTree.postOrderThreadedNodes();

        threadedBinaryTree.postOrderThreadedList();
    }

}
