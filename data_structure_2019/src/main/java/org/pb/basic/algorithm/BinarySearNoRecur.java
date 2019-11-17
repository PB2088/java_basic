package org.pb.basic.algorithm;

import org.pb.basic.search.Search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearNoRecur implements Search {
    public static void main(String[] args) {
        long[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 22, 25, 38, 42, 65, 72, 81, 99};

        Search search = new BinarySearNoRecur();
        System.out.println(search.search(array, 8));
    }
    @Override
    public List<Integer> search(long[] array, long findVal) {
        int left = 0;
        int right = array.length -1;
        List<Integer> indexs = new ArrayList<>();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > findVal) {
                right = mid - 1;
            } else if (array[mid] < findVal) {
                left = mid + 1;
            } else {
                indexs.add(mid);
                break;
            }
        }

        return indexs;
    }
}
