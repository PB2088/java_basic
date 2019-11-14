package org.pb.basic.tree234;

/**
 * 2-3-4树节点类
 * @author bo.peng
 * @create 2019-11-13 13:46
 */
public class Node234 {
    /** 存放多个识别数据项 */
    private KeyItem[] keyItems = new KeyItem[3];

    /** 最多存放4个子节点对象 */
    private Node234[] childrens = new Node234[4];

    /** 父节点对象 */
    private Node234 parent;

    /** 用来记录本节点存放识别数据项的个数 */
    private int itemNum;

    /**
     * 插入识别数据项
     * @param keyItem
     * @return
     */
    public int insertKeyItem(KeyItem keyItem) {
        return 0;
    }

    /**
     * 删除一个识别数据项
     * @return
     */
    public KeyItem removeKeyItem() {
        return null;
    }

    /**
     * 根据识别数据查找识别数据项
     * @param key
     * @return
     */
    public KeyItem findKeyItem(int key) {
        return null;
    }

    /**
     * 连接子节点
     * @param childrenIndex
     * @param childNode
     */
    public void connectChild(int childrenIndex,Node234 childNode) {

    }

    /**
     * 断开某个子节点的连接
     * @param childrenIndex
     */
    public void disconnectChild(int childrenIndex) {

    }

    /**
     * 获取某个子节点
     * @param childIndex
     * @return
     */
    public Node234 getChildren(int childIndex) {
        return null;
    }

    public Node234 getParent() {
        return parent;
    }
}
