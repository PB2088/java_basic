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

        /* 创建一个新节点 */
        RBTreeNode<T> newNode = new RBTreeNode<>(key, value);

        if (Objects.isNull(root)) {
            root = newNode;
        } else {
            RBTreeNode<T> currentNode = root;
            RBTreeNode<T> parentNode;
            while (Boolean.TRUE) {
                parentNode = currentNode;

                /** 处理左子树 */
                if (key < currentNode.getKey()) {
                    currentNode = currentNode.getLeftChild();
                    if (Objects.isNull(currentNode)) {
                        parentNode.setLeftChild(newNode);
                        newNode.setParent(parentNode);

                        break;
                    }
                    /** 处理右子树 */
                } else {
                    currentNode = currentNode.getRightChild();
                    if (Objects.isNull(currentNode)) {
                        parentNode.setRightChild(newNode);
                        newNode.setParent(parentNode);

                        break;
                    }
                }

            }
        }

        doBalance(newNode);

    }

    /**
     * 在加入一个新节点后，对红黑树进行校验并调整
     * 红黑树规则：
     * 1：每个节点不是红色就是黑色
     * 2：根总是黑色
     * 3：如果节点是红色的，那么它的子节点必须是黑色的（反之不必为真）
     * 4：每个空子节点都是黑的,这里的空子节点指的是：对非叶子节点而言，本可能有，但实际没有的那
     * 个子节点。比如一个节点只有右子节点，那么它空缺的左子节点就是空子节点。
     * 5：从根到叶节点或"空子节点"的每条路径，必须包含相同数目的黑色节点（这些黑色节点的数目也称黑色高度）
     *
     * @param localNode 新插入节点
     */
    private void doBalance(RBTreeNode<T> localNode) {
        /* 1：如果插入的是根节点，那么违反规则2，就直接把节点修改为黑色*/
        if (Objects.isNull(localNode.getParent())) {
            localNode.setRed(Boolean.FALSE);
            root = localNode;
        } else if (!localNode.getParent().isRed()) {
            /*2：如果插入节点的父节点是黑色的，说明符合规则，什么都不做*/
        } else if (localNode.getParent().isRed()) {
            RBTreeNode<T> grandfatherNode = localNode.getParent().getParent();
            RBTreeNode<T> uncleNode = null;
            if (Objects.nonNull(grandfatherNode)) {
                uncleNode = Objects.equals(grandfatherNode.getLeftChild(), localNode.getParent()) ? grandfatherNode.getRightChild() : grandfatherNode.getLeftChild();
            }

            /* 叔节点是黑色 */
            final boolean isBlackOfUncleNode = Objects.isNull(uncleNode) || !uncleNode.isRed();

            /* 当前插入节点是其父的左子节点 */
            final boolean isLeftChildOfParent = Objects.equals(localNode, localNode.getParent().getLeftChild());

            /* 当前插入节点的父节点是祖父节点的左子节点 */
            final boolean isLeftChildOfGrandfather = Objects.nonNull(grandfatherNode)
                    && Objects.equals(localNode.getParent(), grandfatherNode.getLeftChild());

            if (Objects.nonNull(uncleNode) && uncleNode.isRed()) {
                /*3：如果插入节点的父节点是红色的，且祖父结点的另一个子节点（叔叔节点）也是红色的，
                那么：将祖父节点变红，而父和叔节点变黑，然后设置祖父节点为当前节点，然后重新开始判断。*/
                grandfatherNode.setRed(Boolean.TRUE);
                localNode.getParent().setRed(Boolean.FALSE);
                uncleNode.setRed(Boolean.FALSE);

                localNode = grandfatherNode;

                doBalance(localNode);
            } else if (isBlackOfUncleNode && isLeftChildOfParent && isLeftChildOfGrandfather) {
                /*4：如果插入节点的父节点是红色，而叔节点是黑色，且插入节点是其父的左子节点，而父节点是祖父节点的左子节点，
                那么：把父节点变为黑色，祖父节点变为红色，然后对祖父节点进行右旋，然后重新开始判断。*/
                localNode.getParent().setRed(Boolean.FALSE);
                grandfatherNode.setRed(Boolean.TRUE);

                rotateWithRight(grandfatherNode);

                doBalance(localNode);
            } else if (isBlackOfUncleNode && !isLeftChildOfParent && !isLeftChildOfGrandfather) {
                /*5：如果插入节点的父节点是红色，而叔节点是黑色，且插入节点是其父的右子节点，而父节点是祖父节点的右子节点，
                那么：把父节点变为黑色，祖父节点变为红色，然后对祖父节点进行左旋，然后重新开始判断。*/
                localNode.getParent().setRed(Boolean.FALSE);
                grandfatherNode.setRed(Boolean.TRUE);

                rotateWithLeft(grandfatherNode);

                doBalance(localNode);
            } else if (isBlackOfUncleNode && !isLeftChildOfParent && isLeftChildOfGrandfather) {
                /*6：如果插入节点的父节点是红色，而叔节点是黑色，且插入节点是其父的右子节点，而父节点是祖父节点的左子节点，
                那么：把当前节点的父节点做为新的当前节点，对新的当前节点进行左旋，然后重新开始判断。*/
                RBTreeNode<T> oldParent = localNode.getParent();

                rotateWithLeft(oldParent);
                doBalance(oldParent);
            } else if (isBlackOfUncleNode && isLeftChildOfParent && !isLeftChildOfGrandfather) {
                /*7：如果插入节点的父节点是红色，而叔节点是黑色，且插入节点是其父的左子节点，而父节
                点是祖父节点的右子节点，那么：把当前节点的父节点做为新的当前节点，对新的当前节
                点进行右旋，然后重新开始判断。*/
                RBTreeNode<T> oldParent = localNode.getParent();

                rotateWithRight(oldParent);
                doBalance(oldParent);
            }
        }
    }

    /**
     * 右旋转
     *
     * @param node
     * @return
     */
    private void rotateWithRight(RBTreeNode<T> node) {
        /*记录右旋节点 原始的左子节点*/
        RBTreeNode<T> oldLeftChild = node.getLeftChild();

        /*记录右旋节点 原始的左子节点 的 右子节点*/
        RBTreeNode<T> oldLeftRightChild = null;

        if (Objects.nonNull(oldLeftChild)) {
            oldLeftRightChild = oldLeftChild.getRightChild();
        }

        if (Objects.nonNull(node.getParent())) {
            final boolean isLeftChild = Objects.equals(node, node.getParent().getLeftChild());
            if (!isLeftChild) {
                node.getParent().setRightChild(oldLeftChild);
            } else {
                node.getParent().setLeftChild(oldLeftChild);
            }
            if (Objects.nonNull(oldLeftChild)) {
                oldLeftChild.setParent(node.getParent());
            }
        } else {
            oldLeftChild.setParent(null);
            oldLeftChild.setRed(Boolean.FALSE);
            root = oldLeftChild;
        }

        if (Objects.nonNull(oldLeftChild)) {
            oldLeftChild.setRightChild(node);
        }
        node.setParent(oldLeftChild);

        node.setLeftChild(oldLeftRightChild);
        if (Objects.nonNull(oldLeftRightChild)) {
            oldLeftRightChild.setParent(node);
        }

    }

    /**
     * RR型，左旋转
     *
     * @param node
     * @return
     */
    private void rotateWithLeft(RBTreeNode<T> node) {
        RBTreeNode<T> oldRightChild = node.getRightChild();
        RBTreeNode<T> oldRightLeftChild = null;

        if (Objects.nonNull(oldRightChild)) {
            oldRightLeftChild = oldRightChild.getLeftChild();
        }

        /* 旋转节点的父节点 */
        if (Objects.nonNull(node.getParent())) {
            final boolean isLeftChild = Objects.equals(node, node.getParent().getLeftChild());
            /* 当前节点是父节点的左子节点 */
            if (isLeftChild) {
                node.getParent().setLeftChild(oldRightChild);
            } else {
                node.getParent().setRightChild(oldRightChild);
            }
            if (Objects.nonNull(oldRightChild)) {
                oldRightChild.setParent(node.getParent());
            }
        } else {
            oldRightChild.setParent(null);
            oldRightChild.setRed(Boolean.FALSE);
            root = oldRightChild;
        }

        if (Objects.nonNull(oldRightChild)) {
            oldRightChild.setLeftChild(node);
        }
        node.setParent(oldRightChild);

        node.setRightChild(oldRightLeftChild);
        if (Objects.nonNull(oldRightLeftChild)) {
            oldRightLeftChild.setParent(node);
        }
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
