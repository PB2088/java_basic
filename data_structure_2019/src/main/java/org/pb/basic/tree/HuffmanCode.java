package org.pb.basic.tree;

import java.util.*;

/**
 * @author bo.peng
 * @create 2019-09-15 16:01
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();

        System.out.println(contentBytes.length);

        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.createHuffmanTree(createTreeNodeList(contentBytes));

        huffmanTree.preOrder();
    }

    /**
     * 根据字节数组创建赫夫曼树节点列表
     * @param bytes
     * @return
     */
    public static List<HuffmanTree.TreeNode<Byte>> createTreeNodeList(byte[] bytes) {
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte aByte : bytes) {
            Integer count = counts.get(aByte);
            if (Objects.isNull(count)) {
                counts.put(aByte,1);
            } else {
                counts.put(aByte,count+1);
            }
        }

        List<HuffmanTree.TreeNode<Byte>> nodes = new ArrayList<>();
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanTree.TreeNode<>(entry.getValue(),entry.getKey()));
        }

        return nodes;
    }
}
