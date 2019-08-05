package org.pb.basic.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 斐波那契查找
 *
 * @author boge.peng
 * @create 2019-08-03 12:36
 */
public class FibonacciSearch implements Search {

    private static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        long[] array = {1, 8, 10, 89, 102, 208, 309, 1000, 1024, 1234};

        List<Integer> integerList = new FibonacciSearch().search(array, 1234);

        System.out.println(integerList);
    }

    @Override
    public List<Integer> search(long[] array, long findVal) {
        int low = 0;
        int high = array.length - 1;

        /** 斐波那契分割数值的下标 */
        int k = 0;
        long[] f = fib();

        while (high > f[k] - 1) {
            k++;
        }

        long[] temp = Arrays.copyOf(array, (int) f[k]);
        Arrays.fill(temp, high + 1, temp.length, array[high]);

        List<Integer> indexList = new ArrayList<>();
        while (low <= high) {
            int mid = low + (int) f[k - 1] - 1;

            if (findVal < temp[mid]) {
                high = mid -1;
                k --;
            } else if (findVal > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    indexList.add(mid);
                } else {
                    indexList.add(high);
                }

                break;
            }
        }

        return indexList;
    }

    /**
     * 构建斐波那契数列
     *
     * @return
     */
    public static long[] fib() {
        long[] f = new long[MAX_SIZE];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < MAX_SIZE; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }
}
