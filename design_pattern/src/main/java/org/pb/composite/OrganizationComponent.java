package org.pb.composite;

/**
 * 组合模式抽象父类
 * @author bo.peng
 * @create 2020-03-02 14:42
 */
public abstract class OrganizationComponent {
    /** 名称 */
    private String name;

    /** 说明 */
    private String description;

    /**
     * 添加
     * @param component
     */
    protected void add(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除
     * @param component
     */
    protected void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    /**
     * 打印
     */
    protected abstract void print();

    public OrganizationComponent(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
