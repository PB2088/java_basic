package org.pb.basic.tree;

import javax.swing.tree.TreeNode;
import java.util.Objects;

/**
 * 二叉树
 *
 * @author boge.peng
 * @create 2019-08-11 23:51
 */
public class BinaryTree<V> {

    private TreeNode<V> root;

    public TreeNode<V> getRoot() {
        return root;
    }

    public void insert(long key, V value) {
        TreeNode<V> newNode = new TreeNode<>(key, value);
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
     *
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
     * 前序遍历查找
     *
     * @param key
     */
    public V preOrderSearch(long key) {
        TreeNode treeNode = preOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (V) treeNode.value : null;
    }

    private TreeNode preOrderSearch(TreeNode node, long key) {
        if (Objects.isNull(node) || key == node.key) {
            return node;
        }

        TreeNode treeNode = preOrderSearch(node.leftChild, key);
        if (Objects.nonNull(treeNode)) {
            return treeNode;
        }

        return preOrderSearch(node.rightChild, key);
    }

    /**
     * 中序遍历
     *
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
     * 中序遍历查找
     *
     * @param key
     * @return
     */
    public V inOrderSearch(long key) {
        TreeNode treeNode = inOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (V) treeNode.value : null;
    }

    private TreeNode inOrderSearch(TreeNode node, long key) {
        TreeNode treeNode = null;
        if (Objects.nonNull(node)) {
            treeNode = inOrderSearch(node.leftChild, key);
        }

        if (Objects.nonNull(treeNode)) {
            return treeNode;
        }

        if (Objects.nonNull(node) && key == node.key) {
            return node;
        }

        if (Objects.nonNull(node)) {
            treeNode = inOrderSearch(node.rightChild, key);
        }

        return treeNode;
    }

    /**
     * 后序遍历
     *
     * @param localRoot
     */
    public void postOrder(TreeNode<V> localRoot) {
        if (Objects.nonNull(localRoot)) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot);
        }
    }

    /**
     * 后序遍历查找
     *
     * @param key
     * @return
     */
    public V postOrderSearch(long key) {
        TreeNode treeNode = inOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (V) treeNode.value : null;
    }

    private TreeNode postOrderSearch(TreeNode node, long key) {
        TreeNode treeNode = null;
        if (Objects.nonNull(node)) {
            treeNode = postOrderSearch(node.leftChild, key);
        }

        if (Objects.nonNull(treeNode)) {
            return treeNode;
        }

        if (Objects.nonNull(node)) {
            treeNode = postOrderSearch(node.rightChild, key);
        }

        if (Objects.nonNull(node) && key == node.key) {
            return node;
        }

        return treeNode;
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
