package org.pb.basic.tree;

/**
 * @author bo.peng
 * @create 2019-08-14 12:34
 */
public class Hero {
    private long num;

    private String name;

    public Hero(long num, String name) {
        this.num = num;
        this.name = name;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
