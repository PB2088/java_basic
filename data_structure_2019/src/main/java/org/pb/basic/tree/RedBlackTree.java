package org.pb.basic.tree;

import java.util.Objects;

/**
 * 红黑树
 *
 * @author boge.peng
 * @create 2019-10-14 16:51
 */
public class RedBlackTree<T extends Comparable<T>> {

    private RBTreeNode<T> root;

    public RBTreeNode<T> getRoot() {
        return root;
    }

    public void insert(long key, T value) {
        root = insert(root, key, value);
    }

    private RBTreeNode<T> insert(RBTreeNode<T> node, long key, T value) {
        if (Objects.isNull(node)) {
            return new RBTreeNode<>(key, value);
        }

        if (node.key == key) {
            return node;
        }

        if (key < node.key) {
            RBTreeNode<T> leftChildNode = insert(node.leftChild, key, value);
            node.leftChild = leftChildNode;
            leftChildNode.setParent(node);
        } else {
            RBTreeNode<T> rightChildNode = insert(node.rightChild, key, value);
            node.rightChild = rightChildNode;
            rightChildNode.setParent(node);
        }

        return doBalance(node);
    }

    /**
     * 处理平衡特性
     * @param localNode 根节点
     * @return 平衡后新的根节点
     */
    private RBTreeNode<T> doBalance(RBTreeNode<T> localNode) {


        return null;
    }

    /**
     * LL型，右旋转
     *
     * @param node
     * @return
     */
    private RBTreeNode<T> rotateWithRight(RBTreeNode<T> node) {
        RBTreeNode<T> newNode = node.leftChild;

        node.leftChild = newNode.rightChild;

        newNode.rightChild = node;

        return newNode;
    }

    /**
     * RR型，左旋转
     *
     * @param node
     * @return
     */
    private RBTreeNode<T> rotateWithLeft(RBTreeNode<T> node) {
        RBTreeNode<T> newNode = node.rightChild;

        node.rightChild = newNode.leftChild;

        newNode.leftChild = node;

        return newNode;
    }

    /**
     * 前序遍历
     *
     * @param localRoot
     */
    public void preOrder(RBTreeNode<T> localRoot) {
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
    public T preOrderSearch(long key) {
        RBTreeNode treeNode = preOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (T) treeNode.value : null;
    }

    private RBTreeNode<T> preOrderSearch(RBTreeNode<T> node, long key) {
        if (Objects.isNull(node) || key == node.key) {
            return node;
        }

        RBTreeNode<T> treeNode = preOrderSearch(node.leftChild, key);
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
    public void inOrder(RBTreeNode<T> localRoot) {
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
    public T inOrderSearch(long key) {
        RBTreeNode<T> treeNode = inOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (T) treeNode.value : null;
    }

    protected RBTreeNode<T> inOrderSearch(RBTreeNode<T> node, long key) {
        RBTreeNode<T> treeNode = null;
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
    public void postOrder(RBTreeNode<T> localRoot) {
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
    public T postOrderSearch(long key) {
        RBTreeNode<T> treeNode = postOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (T) treeNode.value : null;
    }

    protected RBTreeNode<T> postOrderSearch(RBTreeNode<T> node, long key) {
        RBTreeNode<T> treeNode = null;
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

    /**
     * 删除节点
     *
     * @param key
     */
    public void deleteNode(long key) {
        if (Objects.isNull(root)) {
            System.out.println("空树,无法进行删除节点!");
            return;
        }

        /* 中序遍历查找要删除的节点 */
        RBTreeNode<T> targetNode = postOrderSearch(root, key);
        if (Objects.isNull(targetNode)) {
            System.out.println("要删除的节点不存在!");
            return;
        }

        if (Objects.isNull(targetNode.leftChild) && Objects.isNull(targetNode.rightChild)) {
            deleteLeafNode(targetNode);
        } else if (Objects.nonNull(targetNode.leftChild) && Objects.nonNull(targetNode.rightChild)) {
            deleteWithTwoChildNodes(targetNode);
        } else {
            deleteWithOneChildNode(targetNode);
        }
    }

    /**
     * 删除有一个子节点的节点
     *
     * @param targetNode
     */
    private void deleteWithOneChildNode(RBTreeNode<T> targetNode) {
        final boolean isHasLeftChild = Objects.nonNull(targetNode.leftChild);

        if (targetNode == root) {
            if (isHasLeftChild) {
                root = targetNode.leftChild;
            } else {
                root = targetNode.rightChild;
            }
        } else {
            RBTreeNode<T> parentNode = searchParentNode(targetNode);
            final boolean isLeftChildOfParentNode = (targetNode == parentNode.leftChild);

            if (isHasLeftChild && isLeftChildOfParentNode) {
                parentNode.setLeftChild(targetNode.leftChild);
            }

            if (isHasLeftChild && !isLeftChildOfParentNode) {
                parentNode.setRightChild(targetNode.leftChild);
            }

            if (!isHasLeftChild && isLeftChildOfParentNode) {
                parentNode.setLeftChild(targetNode.rightChild);
            }

            if (!isHasLeftChild && !isLeftChildOfParentNode) {
                parentNode.setRightChild(targetNode.rightChild);
            }
        }
    }

    /**
     * 删除有两个子节点的节点
     *
     * @param targetNode
     */
    private void deleteWithTwoChildNodes(RBTreeNode<T> targetNode) {
        RBTreeNode<T> parentNode = searchParentNode(targetNode);
        RBTreeNode<T> successor = getSuccessor(targetNode);

        if (targetNode == root) {
            root = successor;
        } else if (targetNode == parentNode.leftChild) {
            parentNode.setLeftChild(successor);
        } else {
            parentNode.setRightChild(successor);
        }

        successor.setLeftChild(targetNode.leftChild);
    }

    /**
     * 删除叶子节点
     *
     * @param targetNode
     */
    private void deleteLeafNode(RBTreeNode<T> targetNode) {
        RBTreeNode<T> parentNode = searchParentNode(targetNode);
        if (targetNode == root) {
            root = null;
        } else if (targetNode == parentNode.leftChild) {
            parentNode.setLeftChild(null);
        } else {
            parentNode.setRightChild(null);
        }
    }


    /**
     * 查找指定节点的父节点
     *
     * @param targetNode 目标节点
     * @return 父节点
     */
    public RBTreeNode<T> searchParentNode(RBTreeNode<T> targetNode) {
        return searchParentNode(root, targetNode);
    }

    private RBTreeNode<T> searchParentNode(RBTreeNode<T> searchNode, RBTreeNode<T> targetNode) {
        if (Objects.isNull(searchNode)) {
            return null;
        }

        if (searchNode.leftChild == targetNode || searchNode.rightChild == targetNode) {
            return searchNode;
        }

        RBTreeNode<T> treeNode = searchParentNode(searchNode.leftChild, targetNode);
        if (Objects.nonNull(treeNode)) {
            return treeNode;
        }

        return searchParentNode(searchNode.rightChild, targetNode);
    }

    /**
     * 获取中序后继节点
     *
     * @param node
     * @return
     */
    private RBTreeNode<T> getSuccessor(RBTreeNode<T> node) {
        RBTreeNode<T> current = node.getRightChild();
        RBTreeNode<T> successorParent = node;
        RBTreeNode<T> successor = node;

        while (Objects.nonNull(current)) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != node.rightChild) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }

        return successor;
    }


    protected static class RBTreeNode<T> {
        /**
         * 关键值
         */
        private long key;

        /**
         * 节点内容
         */
        private T value;

        private RBTreeNode<T> parent;

        /**
         * 左子节点
         */
        private RBTreeNode<T> leftChild;

        /**
         * 右子节点
         */
        private RBTreeNode<T> rightChild;

        private boolean red = true;

        public RBTreeNode(long key, T value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "RBTreeNode{" +
                    "key=" + key +
                    ",parent=" + (Objects.isNull(parent) ? null : parent.key) +
                    ",red=" + red +
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

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public RBTreeNode<T> getParent() {
            return parent;
        }

        public void setParent(RBTreeNode<T> parent) {
            this.parent = parent;
        }

        public RBTreeNode<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(RBTreeNode<T> leftChild) {
            this.leftChild = leftChild;
        }

        public RBTreeNode<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(RBTreeNode<T> rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isRed() {
            return red;
        }

        public void setRed(boolean red) {
            this.red = red;
        }
    }
}
