package org.pb.basic.tree;

import java.util.Map;
import java.util.Objects;

/**
 * 线索化二叉树
 * @author boge.peng
 * @create 2019-08-28 16:40
 */
public class ThreadedBinaryTree<V> {

    private TreeNode<V> root;

    public TreeNode<V> getRoot() {
        return root;
    }

    /**
     * 通过数组构造一个二叉树(完全二叉树)
     * @param array
     * @param index
     * @return
     */
    public TreeNode createBinaryTree(V [] array,int index) {
        TreeNode treeNode = null;

        if (index < array.length) {
            treeNode = new TreeNode(index,array[index]);
            treeNode.setLeftChild(createBinaryTree(array, index * 2 + 1));
            treeNode.setRightChild(createBinaryTree(array, index * 2 + 2));
        }

        return root = treeNode;
    }



    private static class TreeNode<V> {
        /** 关键值 */
        private long key;

        /** 节点内容 */
        private V value;

        /** 左子节点 */
        private TreeNode<V> leftChild;

        /** 右子节点 */
        private TreeNode<V> rightChild;

        /** 左指针域类型  false：指向子节点; true：前驱或后继线索 */
        boolean isLeftThread = false;
        /** 右指针域类型  false：指向子节点; true：前驱或后继线索 */
        boolean isRightThread = false;

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
    }
}
