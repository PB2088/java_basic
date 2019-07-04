package org.pb.basic.array;

/**
 * @author boge.peng
 * @create 2019-06-03 23:50
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chess = initChess(15, 11);

        System.out.println("未转换的二维数组:");
        printArray(chess);

        int[][] sparseArray = transformSparseArray(chess);

        System.out.println("转换后的稀疏数组:");
        printArray(sparseArray);

        int[][] revertArray = revertArray(sparseArray);

        System.out.println("还原后的二维数组:");
        printArray(revertArray);
    }

    /**
     * 将稀疏数组还原为二维数组
     * @param sparseArray
     * @return
     */
    private static int[][] revertArray(int[][] sparseArray) {
        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];

        doRevert(sparseArray,array);

        return array;
    }

    private static void doRevert(int[][] sparseArray, int[][] array) {
        for (int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
    }

    /**
     * 将二维数组转换成稀疏数组
     *
     * @param chess
     * @return
     */
    private static int[][] transformSparseArray(int[][] chess) {
        int count = countEffectiveNum(chess);
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = chess.length;
        sparseArray[0][1] = chess[0].length;
        sparseArray[0][2] = count;

        doTransform(chess,sparseArray);

        return sparseArray;
    }

    /**
     * 执行转换操作
     * @param chess
     * @param sparseArray
     */
    private static void doTransform(int[][] chess, int[][] sparseArray) {
        int index = 1;
        for (int i = 0; i < chess.length; i++) {
            for (int ii = 0; ii < chess[i].length; ii++) {
                if (chess[i][ii] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = ii;
                    sparseArray[index][2] = chess[i][ii];

                    index++;
                }
            }
        }
    }

    /**
     * 统计二维数组中有效数据
     *
     * @param chess
     * @return
     */
    private static int countEffectiveNum(int[][] chess) {
        int count = 0;
        for (int[] arry : chess) {
            for (int i : arry) {
                if (i != 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void printArray(int[][] chess) {
        for (int[] arry : chess) {
            for (int i : arry) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

    private static int[][] initChess(int row, int column) {
        int[][] chess = new int[row][column];

        chess[1][2] = 1;
        chess[2][3] = 2;

        return chess;
    }
}
