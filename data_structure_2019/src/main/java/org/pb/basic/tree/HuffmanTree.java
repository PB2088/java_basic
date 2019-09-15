package org.pb.basic.tree;

import org.pb.util.ToolsUtils;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 赫夫曼树
 *
 * @author bo.peng
 * @create 2019-09-10 15:21
 */
public class HuffmanTree {

    private TreeNode root;

    public void createHuffmanTree(int[] array) {
        List<TreeNode<Integer>> treeNodes = createTreeNodeListByArray(array);

        createHuffmanTree(treeNodes);
    }

    public <T> void createHuffmanTree(List<TreeNode<T>> treeNodes) {
        while (treeNodes.size() > 1) {
            Collections.sort(treeNodes);

            /** 取出权值最小和权值次小的节点 */
            TreeNode leftNode = treeNodes.get(0);
            TreeNode rightNode = treeNodes.get(1);

            /** 使用权值最小和权值次小的节点构建一个新的二叉树  */
            TreeNode parent = new TreeNode(leftNode.weight + rightNode.weight);
            parent.leftChild = leftNode;
            parent.rightChild = rightNode;


            treeNodes.remove(leftNode);
            treeNodes.remove(rightNode);
            treeNodes.add(parent);
        }

        this.root = treeNodes.get(0);
    }


    /**
     * 前序遍历赫夫曼树
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode node) {
        System.out.println(node);

        if (Objects.nonNull(node.leftChild)) {
            preOrder(node.leftChild);
        }

        if (Objects.nonNull(node.rightChild)) {
            preOrder(node.rightChild);
        }

    }

    /**
     * 创建节点列表
     *
     * @param array
     * @return
     */
    private static List<TreeNode<Integer>> createTreeNodeListByArray(int[] array) {
        if (ToolsUtils.isEmpty(array)) {
            return Collections.emptyList();
        }

        List<TreeNode<Integer>> nodeList = new ArrayList<>();
        for (int i : array) {
            nodeList.add(new TreeNode(i));
        }
        return nodeList;
    }

    public TreeNode getRoot() {
        return root;
    }

    protected static class TreeNode<T> implements Comparable<TreeNode> {
        /**
         * 节点权值
         */
        private int weight;

        /**
         * 数据域
         */
        private T data;

        /**
         * 左子节点
         */
        private TreeNode leftChild;

        /**
         * 右子节点
         */
        private TreeNode rightChild;

        public TreeNode(int weight) {
            this.weight = weight;
        }

        public TreeNode(int weight, T data) {
            this.weight = weight;
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "weight=" + weight +
                    ", data=" + data +
                    '}';
        }

        @Override
        public int compareTo(TreeNode o) {
            return this.weight - o.weight;
        }
    }
}


