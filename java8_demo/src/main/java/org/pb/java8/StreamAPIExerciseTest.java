package org.pb.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author boge.peng
 * @create 2019-04-27 14:44
 */
public class StreamAPIExerciseTest {
    /**
     * 给定一个列表,如何返回一个由每个数的平方构成的列表?
     * 给定[1,2,3,4,5] , 返回列表[1,4,9,16,25]
     */
    @Test
    public void test01() {
        Integer[] nums = {1,2,3,4,5};
        Arrays.stream(nums).map(x -> x * x).forEach(System.out::println);
    }


}
