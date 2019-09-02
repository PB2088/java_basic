package org.pb.basic.tree;

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

            /** 记录节点的父节点（后序线索化遍历时使用） */
            if (Objects.nonNull(treeNode.getLeftChild())) {
                treeNode.getLeftChild().setParent(treeNode);
            }

            /** 记录节点的父节点（后序线索化遍历时使用） */
            if (Objects.nonNull(treeNode.getRightChild())) {
                treeNode.getRightChild().setParent(treeNode);
            }
        }

        return root = treeNode;
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
        if (Objects.isNull(node)) {
            return;
        }

        /** 线索化左子树 */
        inOrderThreadedNodes(node.getLeftChild());

        /** 线索化当前节点 */
        //左指针为空,将左指针指向前驱节点
        if (Objects.isNull(node.getLeftChild())) {
            /** 当前节点的左指针指向前驱节点 */
            node.setLeftChild(prevNode);
            /** 修改当前节点的左指针的类型 */
            node.setLeftThreaded(Boolean.TRUE);
        }

        //前一个节点的后继节点指向当前节点
        if (Objects.nonNull(prevNode) && Objects.isNull(prevNode.getRightChild())) {
            prevNode.setRightChild(node);
            prevNode.setRightThreaded(Boolean.TRUE);
        }

        //每处理一个节点后,让当前节点是下一个节点的前驱节点
        prevNode = node;

        /** 线索化右子树 */
        inOrderThreadedNodes(node.getRightChild());
    }

    public void inOrderThreadedList() {
        inOrderThreadedList(root);
    }

    private void inOrderThreadedList(TreeNode node) {

        while (Objects.nonNull(node)) {
            /** 找到中序遍历的开始节点 */
            while (!node.isLeftThreaded() && Objects.nonNull(node.getLeftChild())) {
                node = node.getLeftChild();
            }

            System.out.println(node.getValue());

            //如果当前节点的左指针指向的是后续节点,就一直输出
            while (node.isRightThreaded()) {
                //获取当前节点的后续节点
                node = node.getRightChild();
                System.out.println(node.getValue());
            }

            node = node.getRightChild();

        }
    }

    /**
     * 前序线索化二叉树
     */
    public void preOrderThreadedNodes() {
        preOrderThreadedNodes(root);
    }

    /**
     * 前序线索化二叉树
     *
     * @param node
     */
    private void preOrderThreadedNodes(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        /** 处理当前节点,左指针为空,将左指针指向前驱节点 */
        if (Objects.isNull(node.getLeftChild())) {
            node.setLeftChild(prevNode);
            node.setLeftThreaded(Boolean.TRUE);
        }

        /** 前一个节点的后继节点指向当前节点 */
        if (Objects.nonNull(prevNode) && Objects.isNull(prevNode.getRightChild())) {
            prevNode.setRightChild(node);
            prevNode.setRightThreaded(Boolean.TRUE);
        }

        /** 每处理完一个节点,让当前节点是下一个节点的前驱节点 */
        prevNode = node;

        /** 线索化左子树 */
        if (!node.isLeftThreaded()) {
            preOrderThreadedNodes(node.getLeftChild());
        }

        /** 线索化右子树 */
        if (!node.isRightThreaded()) {
            preOrderThreadedNodes(node.getRightChild());
        }
    }

    /**
     * 前序遍历线索化二叉树
     */
    public void preOrderThreadedList() {
        preOrderThreadedList(root);
    }

    /**
     * 前序遍历线索化二叉树(按照后继线索遍历)
     *
     * @param node
     */
    private void preOrderThreadedList(TreeNode node) {
        while (Objects.nonNull(node)) {
            while (!node.isLeftThreaded()) {
                System.out.println(node.getValue());
                node = node.getLeftChild();
            }

            System.out.println(node.getValue());

            node = node.getRightChild();

        }
    }

    public void postOrderThreadedNodes() {
        postOrderThreadedNodes(root);
    }

    /**
     * 后序线索化二叉树
     *
     * @param node
     */
    private void postOrderThreadedNodes(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        if (!node.isLeftThreaded()) {
            postOrderThreadedNodes(node.getLeftChild());
        }

        if (!node.isRightThreaded()) {
            postOrderThreadedNodes(node.getRightChild());
        }

        /** 处理当前节点,左指针为空,将左指针指向前驱节点 */
        if (Objects.isNull(node.getLeftChild())) {
            node.setLeftChild(prevNode);
            node.setLeftThreaded(Boolean.TRUE);
        }

        /** 前一个节点的后继节点指向当前节点 */
        if (Objects.nonNull(prevNode) && Objects.isNull(prevNode.getRightChild())) {
            prevNode.setRightChild(node);
            prevNode.setRightThreaded(Boolean.TRUE);
        }

        /** 每处理完一个节点,让当前节点是下一个节点的前驱节点 */
        prevNode = node;
    }

    /**
     * 前序遍历线索化二叉树
     */
    public void postOrderThreadedList() {
        postOrderThreadedList(root);
    }

    /**
     * 后序遍历线索化二叉树
     *
     * @param node
     */
    private void postOrderThreadedList(TreeNode node) {

        while (Objects.nonNull(node) && !node.isLeftThreaded()) {
            node = node.getLeftChild();
        }

        TreeNode preNode = null;
        while (Objects.nonNull(node)) {

            if (node.isRightThreaded()) {
                System.out.println(node.getValue());

                preNode = node;
                node = node.getRightChild();
            } else {

                if (node.getRightChild() == preNode) {
                    System.out.println(node.getValue());

                    if (node == root) {
                        return;
                    }

                    preNode = node;
                    node = node.parent;
                } else {
                    node = node.getRightChild();
                    while(Objects.nonNull(node) && !node.isLeftThreaded()) {
                        node = node.getLeftChild();
                    }
                }

            }
        }

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
        private boolean leftThreaded;
        /**
         * 右指针域类型  false：指向子节点; true：前驱或后继线索
         */
        private boolean rightThreaded;

        /**
         * 父节点指针(后续线索化使用)
         */
        private TreeNode<V> parent;

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

        public TreeNode<V> getParent() {
            return parent;
        }

        public void setParent(TreeNode<V> parent) {
            this.parent = parent;
        }
    }
}
