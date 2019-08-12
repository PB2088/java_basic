package org.pb.basic.tree;

import javax.swing.tree.TreeNode;
import java.util.Objects;

/**
 * 二叉树
 * @author bo.peng
 * @create 2019-08-12 15:16
 */
public class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public <T> void insert(long key,T value) {
        TreeNode newNode = new TreeNode<>(key,value);

        if (Objects.isNull(root)) {
            root = newNode;
            return;
        }

        TreeNode currentNode = root;
        TreeNode parent;
        while (true) {
            parent = currentNode;
            if (key < currentNode.key ) {
                currentNode = currentNode.getLeftChild();
                if (Objects.isNull(currentNode)) {
                    parent.setLeftChild(newNode);
                    break;
                }
            } else {
                currentNode = currentNode.getRightChild();
                if (Objects.isNull(currentNode)) {
                    parent.setRightChild(newNode);
                    break;
                }
            }
        }
    }

    /**
     * 二叉树节点类
     * @param <T>
     */
    private static class TreeNode<T> {
        private long key;

        private T value;

        private TreeNode<T> leftChild;

        private TreeNode<T> rightChild;

        public TreeNode(long key, T value) {
            this.key = key;
            this.value = value;
        }

        public long getKey() {
            return key;
        }

        public void setKey(long key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode<T> leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode<T> rightChild) {
            this.rightChild = rightChild;
        }
    }

}


