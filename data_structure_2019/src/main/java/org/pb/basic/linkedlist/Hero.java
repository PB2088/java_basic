package org.pb.basic.linkedlist;

/**
 * @author boge.peng
 * @create 2019-06-09 17:23
 */
public class Hero {
    /** 排名 */
    private int no;

    /** 名称 */
    private String name;

    /** 昵称 */
    private String nickName;

    public Hero(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
