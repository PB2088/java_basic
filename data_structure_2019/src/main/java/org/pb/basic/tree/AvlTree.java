package org.pb.basic.tree;

import java.util.Objects;

/**
 * 二叉树
 *
 * @author boge.peng
 * @create 2019-08-11 23:51
 */
public class AvlTree<T> {

    private AvlTreeNode<T> root;

    public AvlTreeNode<T> getRoot() {
        return root;
    }

    public int getHeight(AvlTreeNode<T> node) {
        if (Objects.isNull(node)) {
            return 0;
        }

        return Math.max(Objects.isNull(node.leftChild) ? 0 : getHeight(node.leftChild), Objects.isNull(node.rightChild) ? 0 : getHeight(node.rightChild)) + 1;
    }

    public void insert(long key, T value) {
        AvlTreeNode<T> newNode = new AvlTreeNode<>(key, value);
        if (Objects.isNull(root)) {
            root = newNode;
            return;
        }

        AvlTreeNode<T> currentNode = root;
        AvlTreeNode<T> parentNode;
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

    private void balance(AvlTreeNode<T> localNode) {

    }

    /**
     * 前序遍历
     *
     * @param localRoot
     */
    public void preOrder(AvlTreeNode<T> localRoot) {
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
        AvlTreeNode treeNode = preOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (T) treeNode.value : null;
    }

    private AvlTreeNode preOrderSearch(AvlTreeNode node, long key) {
        if (Objects.isNull(node) || key == node.key) {
            return node;
        }

        AvlTreeNode treeNode = preOrderSearch(node.leftChild, key);
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
    public void inOrder(AvlTreeNode<T> localRoot) {
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
        AvlTreeNode treeNode = inOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (T) treeNode.value : null;
    }

    protected AvlTreeNode inOrderSearch(AvlTreeNode node, long key) {
        AvlTreeNode treeNode = null;
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
    public void postOrder(AvlTreeNode<T> localRoot) {
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
        AvlTreeNode treeNode = postOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (T) treeNode.value : null;
    }

    protected AvlTreeNode postOrderSearch(AvlTreeNode node, long key) {
        AvlTreeNode treeNode = null;
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
        AvlTreeNode targetNode = postOrderSearch(root, key);
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
     * @param targetNode
     */
    private void deleteWithOneChildNode(AvlTreeNode targetNode) {
        final boolean isHasLeftChild = Objects.nonNull(targetNode.leftChild);

        if (targetNode == root) {
            if (isHasLeftChild) {
                root = targetNode.leftChild;
            } else {
                root = targetNode.rightChild;
            }
        } else {
            AvlTreeNode parentNode = searchParentNode(targetNode);
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
    private void deleteWithTwoChildNodes(AvlTreeNode targetNode) {
        AvlTreeNode parentNode = searchParentNode(targetNode);
        AvlTreeNode successor = getSuccessor(targetNode);

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
    private void deleteLeafNode(AvlTreeNode targetNode) {
        AvlTreeNode parentNode = searchParentNode(targetNode);
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
    public AvlTreeNode searchParentNode(AvlTreeNode targetNode) {
        return searchParentNode(root, targetNode);
    }

    private AvlTreeNode searchParentNode(AvlTreeNode searchNode, AvlTreeNode targetNode) {
        if (Objects.isNull(searchNode)) {
            return null;
        }

        if (searchNode.leftChild == targetNode || searchNode.rightChild == targetNode) {
            return searchNode;
        }

        AvlTreeNode treeNode = searchParentNode(searchNode.leftChild, targetNode);
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
    private AvlTreeNode getSuccessor(AvlTreeNode node) {
        AvlTreeNode current = node.getRightChild();
        AvlTreeNode successorParent = node;
        AvlTreeNode successor = node;

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


    protected static class AvlTreeNode<T> {
        /**
         * 关键值
         */
        private long key;

        /**
         * 节点内容
         */
        private T value;

        /**
         * 左子节点
         */
        private AvlTreeNode<T> leftChild;

        /**
         * 右子节点
         */
        private AvlTreeNode<T> rightChild;

        public AvlTreeNode(long key, T value) {
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

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public AvlTreeNode<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(AvlTreeNode<T> leftChild) {
            this.leftChild = leftChild;
        }

        public AvlTreeNode<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(AvlTreeNode<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
