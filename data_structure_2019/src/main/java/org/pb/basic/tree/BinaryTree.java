package org.pb.basic.tree;

import java.util.Objects;

/**
 * 二叉树
 * @author boge.peng
 * @create 2019-08-11 23:51
 */
public class BinaryTree<V> {

    private TreeNode<V> root;

    public TreeNode<V> getRoot() {
        return root;
    }

    public void insert(long key, V value) {
        TreeNode<V> newNode = new TreeNode<>(key,value);
        if (Objects.isNull(root)) {
            root = newNode;
            return;
        }

        TreeNode<V> currentNode = root;
        TreeNode<V> parentNode;
        while (true) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
                if (Objects.isNull(currentNode)) {
                    parentNode.setLeftChild(newNode);
                    break;
                }
            } else {
                currentNode = currentNode.rightChild;
                if (Objects.isNull(currentNode)) {
                    parentNode.setRightChild(newNode);
                    break;
                }
            }
        }
    }

    /**
     * 前序遍历
     * @param localRoot
     */
    public void preOrder(TreeNode<V> localRoot) {
        if (Objects.nonNull(localRoot)) {
            System.out.println(localRoot);
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    /**
     * 中序遍历
     * @param localRoot
     */
    public void inOrder(TreeNode<V> localRoot) {
        if (Objects.nonNull(localRoot)) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot);
            inOrder(localRoot.rightChild);
        }
    }

    /**
     * 后序遍历
     * @param localRoot
     */
    public void postOrder(TreeNode<V> localRoot) {
        if (Objects.nonNull(localRoot)) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot);
        }
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
