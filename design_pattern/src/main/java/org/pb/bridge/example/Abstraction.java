package org.pb.bridge.example;

/**
 * 定义抽象部分的接口
 * @author bo.peng
 * @create 2019-12-30 10:41
 */
public abstract class Abstraction {
    /** 持有一个实现部分的对象 */
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 示例操作,实现一定的功能,可能需要转调实现部分的具体实现方法
     */
    public void operation() {
        implementor.operationImpl();
    }
}
