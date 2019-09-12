package org.pb.basic.tree;

import org.pb.util.ToolsUtils;

import java.util.Objects;

/**
 * 顺序二叉树
 * @author boge.peng
 * @create 2019-08-19 22:51
 */
public class ArrayBinaryTree {
    private long[] array;

    public ArrayBinaryTree(long[] array) {
        this.array = array;
    }

    public void preOrder() {
        preOrder(0);
    }

    /**
     * 前序遍历
     * @param index 数组下标
     */
    private void preOrder(int index) {
        if (ToolsUtils.isEmpty(array)) {
            System.out.println("数组为空,不能按照二叉树的前序遍历");
            return;
        }

        /** 输出当前元素 */
        System.out.print(array[index] + "\t");

        /** 向左递归遍历 */
        final int leftNodeIndex = 2 * index + 1;
        if (leftNodeIndex < array.length ) {
            preOrder(leftNodeIndex);
        }

        final int rightNodeIndex = 2 * index + 2;
        if (rightNodeIndex < array.length) {
            preOrder(rightNodeIndex);
        }
    }
}
