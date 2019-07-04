package org.pb.basic.recursion;

import java.util.Arrays;

/**
 * 迷宫
 *
 * @author boge.peng
 * @create 2019-07-03 22:11
 */
public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[12][12];

        /** 第一行和最后一行设置为墙 */
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }

        /** 第一列和最后一列设置为墙 */
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map[0].length -1] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;

        //map[map.length-2][map[0].length-2] = 3;
        findWay(map,1,1);

        System.out.println("小球走过并标识过的地图情况:");
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[i].length; i1++) {
                System.out.print(map[i][i1] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * 小球找路
     * @param map 地图: 0表示没有走过, 1表示墙,2表示通路可以走,3表示已经走过,但是走不通
     *            策略: 下->右->上-左
     * @param row
     * @param column
     * @return
     */
    private static boolean findWay(int[][] map,int row,int column) {
        if (map[map.length-2][map[0].length-2] == 2) {
            return true;
        } else {
            if (map[row][column] == 0) {
                map[row][column] = 2;

                /** 向下走 */
                if (findWay(map,row +1 ,column)) {
                    return true;
                /** 向右走 */
                } else if (findWay(map,row,column + 1)) {
                    return true;
                /** 向上走 */
                } else if (findWay(map,row -1,column)) {
                    return true;
                /** 向上走 */
                } else if (findWay(map,row,column -1)) {
                    return true;
                } else {
                    map[row][column] = 3;
                    return false;
                }

            } else {
                return false;
            }
        }
    }
}
