package org.pb.basic.tree234;

/**
 * 识别数据项
 * @author bo.peng
 * @create 2019-11-13 13:51
 */
public class KeyItem {
    private int id;

    private int data;

    public KeyItem(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "KeyItem{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
