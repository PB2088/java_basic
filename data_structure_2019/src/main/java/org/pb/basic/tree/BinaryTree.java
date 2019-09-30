package org.pb.basic.tree;

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
        TreeNode treeNode = postOrderSearch(root, key);
        return Objects.nonNull(treeNode) ? (V) treeNode.value : null;
    }

    protected TreeNode postOrderSearch(TreeNode node, long key) {
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
        TreeNode targetNode = postOrderSearch(root, key);
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
    private void deleteWithOneChildNode(TreeNode targetNode) {
        final boolean isHasLeftChild = Objects.nonNull(targetNode.leftChild);

        if (targetNode == root) {
            if (isHasLeftChild) {
                root = targetNode.leftChild;
            } else {
                root = targetNode.rightChild;
            }
        } else {
            TreeNode parentNode = searchParentNode(targetNode);
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
    private void deleteWithTwoChildNodes(TreeNode targetNode) {
        TreeNode parentNode = searchParentNode(targetNode);
        TreeNode successor = getSuccessor(targetNode);

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
    private void deleteLeafNode(TreeNode targetNode) {
        TreeNode parentNode = searchParentNode(targetNode);
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
    public TreeNode searchParentNode(TreeNode targetNode) {
        return searchParentNode(root, targetNode);
    }

    private TreeNode searchParentNode(TreeNode searchNode, TreeNode targetNode) {
        if (Objects.isNull(searchNode)) {
            return null;
        }

        if (searchNode.leftChild == targetNode || searchNode.rightChild == targetNode) {
            return searchNode;
        }

        TreeNode treeNode = searchParentNode(searchNode.leftChild, targetNode);
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
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode current = node.getRightChild();
        TreeNode successorParent = node;
        TreeNode successor = node;

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


    protected static class TreeNode<V> {
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
