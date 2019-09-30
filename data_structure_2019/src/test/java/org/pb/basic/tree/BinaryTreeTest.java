package org.pb.basic.tree;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author bo.peng
 * @create 2019-08-14 12:33
 */
public class BinaryTreeTest {

    private BinaryTree<Hero> binaryTree;

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();

        binaryTree.insert(9,new Hero(9,"宋江"));
        binaryTree.insert(8,new Hero(8,"卢俊义"));
        binaryTree.insert(11,new Hero(11,"吴用"));
        binaryTree.insert(13,new Hero(13,"林冲"));
        binaryTree.insert(12,new Hero(12,"鲁智深"));
        binaryTree.insert(10,new Hero(10,"花荣"));
        binaryTree.insert(7,new Hero(7,"李应"));
        binaryTree.insert(14,new Hero(14,"鲁智深"));
        binaryTree.insert(5,new Hero(5,"董平"));
        binaryTree.insert(6,new Hero(6,"杨志"));
        binaryTree.insert(2,new Hero(2,"索超"));
        binaryTree.insert(1,new Hero(1,"武松"));
    }

    @Test
    public void testInsert() {
        binaryTree = new BinaryTree();

        binaryTree.insert(9,new Hero(9,"宋江"));
        binaryTree.insert(8,new Hero(8,"卢俊义"));
        binaryTree.insert(11,new Hero(11,"吴用"));
        binaryTree.insert(13,new Hero(13,"林冲"));
        binaryTree.insert(12,new Hero(12,"鲁智深"));
        binaryTree.insert(10,new Hero(10,"花荣"));
        binaryTree.insert(7,new Hero(7,"李应"));
        binaryTree.insert(14,new Hero(14,"鲁智深"));
        binaryTree.insert(5,new Hero(5,"董平"));
        binaryTree.insert(6,new Hero(6,"杨志"));
        binaryTree.insert(2,new Hero(2,"索超"));
        binaryTree.insert(1,new Hero(1,"武松"));

        System.out.println("中序遍历:");
        binaryTree.inOrder(binaryTree.getRoot());

        System.out.println("前序遍历:");
        binaryTree.preOrder(binaryTree.getRoot());

        System.out.println("后序遍历:");
        binaryTree.postOrder(binaryTree.getRoot());

    }

    @Test
    public void testPreOrderSearch() {
        Hero hero = binaryTree.preOrderSearch(003);
        System.out.println(hero);
    }

    @Test
    public void testInOrderSearch() {
        Hero hero = binaryTree.inOrderSearch(007);
        System.out.println(hero);
    }

    @Test
    public void testPostOrderSearch() {
        Hero hero = binaryTree.postOrderSearch(007);
        System.out.println(hero);
    }

    @Test
    public void testSearchParent() {
        BinaryTree.TreeNode treeNode = binaryTree.postOrderSearch(binaryTree.getRoot(), 7);

        BinaryTree.TreeNode parentNode = binaryTree.searchParentNode(treeNode);

        System.out.println(parentNode.getValue());
    }

    @Test
    public void testDeleteNode() {
        System.out.println("删除节点前:");
        binaryTree.inOrder(binaryTree.getRoot());

        binaryTree.deleteNode(9);

        System.out.println("删除节点后:");
        binaryTree.inOrder(binaryTree.getRoot());
    }
}
