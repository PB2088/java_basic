package org.pb.basic.tree;

import javax.swing.tree.TreeNode;
import java.util.Objects;

/**
 * 线索化二叉树
 *
 * @author boge.peng
 * @create 2019-08-28 16:40
 */
public class ThreadedBinaryTree<V> {

    private TreeNode<V> root;

    private TreeNode<V> prevNode;

    public TreeNode<V> getRoot() {
        return root;
    }

    /**
     * 通过数组构造一个二叉树(完全二叉树)
     *
     * @param array
     * @param index
     * @return
     */
    public TreeNode createBinaryTree(V[] array, int index) {
        TreeNode treeNode = null;

        if (index < array.length) {
            treeNode = new TreeNode(index, array[index]);
            treeNode.setLeftChild(createBinaryTree(array, index * 2 + 1));
            treeNode.setRightChild(createBinaryTree(array, index * 2 + 2));
        }

        return root = treeNode;
    }

    public void inOrderThreadedList() {
        inOrderThreadedList(root);
    }


    private void inOrderThreadedList(TreeNode node) {

        while (Objects.nonNull(node)) {
            while (!node.isLeftThreaded() && Objects.nonNull(node.getLeftChild())) {
                node = node.getLeftChild();
            }

            System.out.println(node.getValue());

            while (node.isRightThreaded()) {
                node = node.getRightChild();
                System.out.println(node.getValue());
            }

            node = node.getRightChild();

        }


    }

    /**
     * 中序线索二叉树
     */
    public void inOrderThreadedNodes() {
        inOrderThreadedNodes(root);
    }

    /**
     * 中序线索二叉树
     *
     * @param node
     */
    private void inOrderThreadedNodes(TreeNode node) {
        /** 如果node为空,不能线索化 */
        if (Objects.nonNull(node)) {
            return;
        }

        /** 线索化左子树 */
        inOrderThreadedNodes(node.getLeftChild());

        /** 线索化当前节点 */
        //左指针为空,将左指针指向前驱节点
        if (Objects.nonNull(node.getLeftChild())) {
            node.setLeftChild(prevNode);
            node.setLeftThreaded(Boolean.TRUE);
        }

        //前一个节点的后继节点指向当前节点
        if (Objects.nonNull(prevNode) && Objects.isNull(prevNode.getRightChild())) {
            prevNode.setRightChild(node);
            prevNode.setRightThreaded(Boolean.TRUE);
        }

        prevNode = node;

        /** 线索化右子树 */
        inOrderThreadedNodes(node.getRightChild());
    }


    private static class TreeNode<V> {
        /**
         * 关键值
         */
        private long key;

        /**
         * 节点内容
         */
        private V value;

        /**
         * 左子节点
         */
        private TreeNode<V> leftChild;

        /**
         * 右子节点
         */
        private TreeNode<V> rightChild;

        /**
         * 左指针域类型  false：指向子节点; true：前驱或后继线索
         */
        boolean leftThreaded = false;
        /**
         * 右指针域类型  false：指向子节点; true：前驱或后继线索
         */
        boolean rightThreaded = false;

        public TreeNode(long key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "key=" + key +
                    ", value=" + value +
                    ", leftChild=" + (Objects.isNull(leftChild) ? null : leftChild.key) +
                    ", rightChild=" + (Objects.isNull(rightChild) ? null : rightChild.key) +
                    '}';
        }

        public long getKey() {
            return key;
        }

        public void setKey(long key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public TreeNode<V> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode<V> leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode<V> getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode<V> rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeftThreaded() {
            return leftThreaded;
        }

        public void setLeftThreaded(boolean leftThreaded) {
            this.leftThreaded = leftThreaded;
        }

        public boolean isRightThreaded() {
            return rightThreaded;
        }

        public void setRightThreaded(boolean rightThreaded) {
            this.rightThreaded = rightThreaded;
        }
    }
}
