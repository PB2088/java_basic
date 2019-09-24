package org.pb.basic.tree;

import java.util.*;

/**
 * @author bo.peng
 * @create 2019-09-15 16:01
 */
public class HuffmanCode {
    private static final Map<Byte, String> HUFF_MAN_CODE_MAP = new HashMap();

    private static final Map<String, Byte> HUFF_MAN_NODE_CODE_MAP = new HashMap();

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();

        HuffmanCode huffmanCode = new HuffmanCode();

        byte[] huffmanBytes = huffmanCode.huffmanZip(contentBytes);

        System.out.println(Arrays.toString(huffmanBytes));

        byte[] bytes = huffmanCode.decode(huffmanBytes);
        System.out.println(new String(bytes));
    }

    /**
     * 赫曼编码压缩
     *
     * @param contentBytes 待压缩的字节数组
     * @return 压缩后的字节数组
     */
    public byte[] huffmanZip(byte[] contentBytes) {
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.createHuffmanTree(createTreeNodeList(contentBytes));

        getHuffmanCodes(huffmanTree.getRoot(), "", new StringBuilder());

        return zip(contentBytes, HUFF_MAN_CODE_MAP);
    }

    /**
     * 根据字节数组创建赫夫曼树节点列表
     *
     * @param bytes
     * @return
     */
    private static List<HuffmanTree.TreeNode<Byte>> createTreeNodeList(byte[] bytes) {
        Map<Byte, Integer> counts = new HashMap<>(100);
        for (byte aByte : bytes) {
            Integer count = counts.get(aByte);
            if (Objects.isNull(count)) {
                counts.put(aByte, 1);
            } else {
                counts.put(aByte, count + 1);
            }
        }

        List<HuffmanTree.TreeNode<Byte>> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanTree.TreeNode<>(entry.getValue(), entry.getKey()));
        }

        return nodes;
    }

    /**
     * @param node          待处理的节点
     * @param code          路径：左子节点是0,右子节点是1
     * @param stringBuilder 用于拼接路径
     * @return
     */
    private <T> void getHuffmanCodes(HuffmanTree.TreeNode<T> node, String code, StringBuilder
            stringBuilder) {
        StringBuilder codeStringBuilder = new StringBuilder(stringBuilder);
        codeStringBuilder.append(code);
        if (Objects.nonNull(node)) {
            if (Objects.isNull(node.getData())) {
                /** 向左递归 */
                getHuffmanCodes(node.getLeftChild(), "0", codeStringBuilder);

                /** 向左递归 */
                getHuffmanCodes(node.getRightChild(), "1", codeStringBuilder);
            } else {
                HUFF_MAN_CODE_MAP.put((Byte) node.getData(), codeStringBuilder.toString());
                HUFF_MAN_NODE_CODE_MAP.put(codeStringBuilder.toString(), (Byte) node.getData());
            }
        }
    }

    /**
     * 根据赫夫曼编码表进行字节压缩
     *
     * @param bytes
     * @param huffmanCodes
     * @return
     */
    private byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(huffmanCodes.get(aByte));
        }

        int len = stringBuilder.length() % 8 == 0 ? stringBuilder.length() / 8 : stringBuilder.length() / 8 + 1;

        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if (i + 8 > stringBuilder.length()) {
                huffmanCodeBytes[index++] = (byte) Integer.parseInt(stringBuilder.substring(i), 2);
            } else {
                huffmanCodeBytes[index++] = (byte) Integer.parseInt(stringBuilder.substring(i, i + 8), 2);
            }
        }

        return huffmanCodeBytes;
    }

    public byte[] decode(byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            stringBuilder.append(byteToBitString(huffmanBytes[i]));
        }

        List<Byte> byteList = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int step = 1;
            boolean isRunning = true;
            while (isRunning) {
                String key = stringBuilder.substring(i, i + step);
                Byte b = HUFF_MAN_NODE_CODE_MAP.get(key);

                if (Objects.nonNull(b)) {
                    byteList.add(b);

                    isRunning = false;
                    i = i + step;
                } else {
                    step++;
                }
            }
        }

        byte[] bytes = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            bytes[i] = byteList.get(i);
        }

        return bytes;
    }

    /**
     * 字节转为二进制字符串
     *
     * @param b
     * @return
     */
    private String byteToBitString(byte b) {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }
}
