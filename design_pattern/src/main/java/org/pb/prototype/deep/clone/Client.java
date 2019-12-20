package org.pb.prototype.deep.clone;

import org.pb.util.CommonUtils;

/**
 * @author bo.peng
 * @create 2019-12-20 10:19
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepCloneableTarget target = new DeepCloneableTarget("DeepCloneableTarget","DeepCloneableTarget.class");

        DeepPrototype deepPrototype = new DeepPrototype("deepPrototype",target);

        DeepPrototype clonePrototype = deepPrototype.deepClone();

        System.out.println("deepPrototype = " + deepPrototype);
        System.out.println("clonePrototype = " + clonePrototype);

        System.out.println("===========================改变一下================================");
        clonePrototype.getDeepCloneableTarget().setCloneName("123456");

        System.out.println("deepPrototype = " + deepPrototype);
        System.out.println("clonePrototype = " + clonePrototype);

    }
}
