package org.pb.binarytree;

import java.util.Random;

public class BinaryTreeApp {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Random random = new Random();

		long[] values = {38,26,72,55,90,41,60,78,92,43,58,62,74,80,76};
		for(long value:values) {
			tree.insert(value);
		}
		tree.displayNode(tree.getRoot());
		System.out.println();
		System.out.println("最小节点："+tree.minimum().getiData());
		System.out.println("最大节点："+tree.maximum().getiData());
		long keyValue = 74;
		System.out.println("删除节点"+keyValue+"后：");
		tree.deleteChildNodes(keyValue);
		tree.displayNode(tree.getRoot());

        long startTime = System.nanoTime();
        Node node = tree.find(78);
        System.out.println(node);
        long endTime = System.nanoTime();
        System.out.println("find() 耗时："+(endTime-startTime));

        Node node1 = tree.findKey(78);
        System.out.println(node1);
        long endTime2 = System.nanoTime();
        System.out.println("findKey() 耗时："+(endTime2-endTime));
    }
}
