package org.pb.prototype.deep.clone;

import java.io.Serializable;

/**
 * @author bo.peng
 * @create 2019-12-20 10:15
 */
public class DeepCloneableTarget implements Serializable {
    /** 名称 */
    private String cloneName;

    /** class */
    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    @Override
    public String toString() {
        return String.format("DeepCloneableTarget[cloneName=%s,cloneClass=%s]",cloneName,cloneClass);
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }
}
