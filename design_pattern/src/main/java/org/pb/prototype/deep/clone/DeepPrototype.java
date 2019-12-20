package org.pb.prototype.deep.clone;

import org.pb.util.CommonUtils;

import java.io.*;

/**
 * 深度克隆原型对象类
 * @author bo.peng
 * @create 2019-12-20 10:14
 */
public class DeepPrototype implements Cloneable, Serializable {
    /** 名称 */
    private String name;

    /** 深度克隆目标对象 */
    private DeepCloneableTarget deepCloneableTarget;

    public DeepPrototype(String name, DeepCloneableTarget deepCloneableTarget) {
        this.name = name;
        this.deepCloneableTarget = deepCloneableTarget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepCloneableTarget getDeepCloneableTarget() {
        return deepCloneableTarget;
    }

    public void setDeepCloneableTarget(DeepCloneableTarget deepCloneableTarget) {
        this.deepCloneableTarget = deepCloneableTarget;
    }

    @Override
    public String toString() {
        return String.format("DeepPrototype[name=%s,deepCloneableTarget.hashCode=%d,deepCloneableTarget=%s]",name,deepCloneableTarget.hashCode(),deepCloneableTarget.toString());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 使用对象序列化实现深度克隆
     * @return
     */
    protected DeepPrototype deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try  {
            /* 序列化：将对象序列化到字节数组输出流中 */
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            /* 反序列化： */
            ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

            return (DeepPrototype) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            CommonUtils.close(ois,oos,bos);
        }

        return null;
    }
}
