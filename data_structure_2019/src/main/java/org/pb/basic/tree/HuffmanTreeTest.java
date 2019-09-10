package org.pb.basic.tree;

import org.junit.Test;

/**
 * @author bo.peng
 * @create 2019-09-10 16:23
 */
public class HuffmanTreeTest {
    @Test
    public void testCreateHuffmanTree() {
        int[] arr = {13,7,8,3,29,6,1};

        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.createHuffmanTree(arr);
        huffmanTree.preOrder();
    }
}
