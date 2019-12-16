package org.pb.factory.tradition;

/**
 * @author bo.peng
 * @create 2019-12-15 17:05
 */
public abstract class Pizza {
    /** 名称 */
    private String name;

    public String getName() {
        return name;
    }

    public Pizza(String name) {
        this.name = name;
    }

    /**
     * 准备原材料
     */
    public abstract void prepare();

    /**
     * 烘烤
     */
    public void bake() {
        System.out.printf("烘烤%s披萨\n", name);
    }

    /**
     * 切割
     */
    public void cut() {
        System.out.printf("切割 %s 披萨\n", name);
    }

    /**
     * 打包
     */
    public void box() {
        System.out.printf("打包 %s 披萨\n", name);
    }

}
