package org.pb.basic.algorithm;

/**
 * 动态规划-背包问题
 *
 * @author bo.peng
 * @create 2019-11-25 9:31
 */
public class DynamicProgramming {

    /** 背包能容纳的总重量 */
    private static final int PACKAGE_WEIGHT = 10;

    /** 初始化物品列表 */
    private static Package[] packages = {
            new Package("a", 6, 2),
            new Package("b", 3, 2),
            new Package("c", 5, 6),
            new Package("d", 4, 5),
            new Package("e", 6, 4)
    };

    public static void main(String[] args) {
        knapsackProblem();
    }

    /**
     * 背包问题算法
     */
    public static void knapsackProblem() {
        int[][] bestValues = new int[packages.length+1][PACKAGE_WEIGHT+1];

        for (int i = 0; i <= packages.length; i++) {
            for (int j = 0; j <= PACKAGE_WEIGHT; j++) {
                if (i == 0 || j == 0) {
                    //临界情况
                    bestValues[i][j] = 0;
                } else {
                    if (j < packages[i - 1].getWeight()) {
                        //当第n件物品重量大于包的重量时，最佳值取前n-1件的
                        bestValues[i][j] = bestValues[i - 1][j];
                    } else {
                        //当第n件物品重量小于包的重量时，分两种情况，分别是装第n件或不装，比较取最大
                        int iWeight = packages[i - 1].getWeight();
                        int iValue = packages[i - 1].getValue();
                        bestValues[i][j] = Math.max(bestValues[i - 1][j], iValue + bestValues[i - 1][j - iWeight]);
                    }
                }
            }
        }

        System.out.print(""+bestValues[packages.length][PACKAGE_WEIGHT]);
    }

    static class Package {
        /** 物品名称 */
        private String name;

        /** 物品价值 */
        private int value;

        /** 物品重量 */
        private int weight;

        public Package(String name, int value, int weight) {
            this.name = name;
            this.value = value;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }
    }
}
