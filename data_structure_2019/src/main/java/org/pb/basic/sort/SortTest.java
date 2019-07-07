package org.pb.basic.sort;

import org.junit.Before;
import org.junit.Test;
import org.pb.util.DateUtil;

import java.util.Date;
import java.util.Random;

/**
 * @author boge.peng
 * @create 2019-07-06 22:22
 */
public class SortTest {

    private Sort sort;

    private long[] array;

    private static final int MAX_SIZE = 100000;

    @Before
    public void setUp() {
        array = new long[MAX_SIZE];

        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            array[i] = random.nextLong();
        }
    }

    @Test
    public void testBubbleSort() {
        System.out.printf("排序前:%s", DateUtil.parseDateToStr(new Date(), DateUtil.FormatPattern
                .DATE_TIME_FORMAT_PATTERN));

        sort = new BubbleSort();
        sort.sort(array);

        System.out.printf("\n排序后:%s", DateUtil.parseDateToStr(new Date(), DateUtil.FormatPattern
                .DATE_TIME_FORMAT_PATTERN));
    }

    @Test
    public void testSelectSort() {
        System.out.printf("排序前:%s", DateUtil.parseDateToStr(new Date(), DateUtil.FormatPattern
                .DATE_TIME_FORMAT_PATTERN));

        sort = new SelectSort();
        sort.sort(array);

        System.out.printf("\n排序后:%s", DateUtil.parseDateToStr(new Date(), DateUtil.FormatPattern
                .DATE_TIME_FORMAT_PATTERN));
    }

    @Test
    public void testInsertSort() {
        System.out.printf("排序前:%s", DateUtil.parseDateToStr(new Date(), DateUtil.FormatPattern
                .DATE_TIME_FORMAT_PATTERN));
        System.out.println();

        sort = new InsertSort();
        sort.sort(array);

        System.out.printf("\n排序后:%s\n", DateUtil.parseDateToStr(new Date(), DateUtil.FormatPattern
                .DATE_TIME_FORMAT_PATTERN));
        System.out.println();
    }

    @Test
    public void testShellSort() {
        System.out.printf("排序前:%s", DateUtil.parseDateToStr(new Date(), DateUtil.FormatPattern
                .DATE_TIME_FORMAT_PATTERN));

        sort = new ShellSort();
        sort.sort(array);

        System.out.printf("\n排序后:%s", DateUtil.parseDateToStr(new Date(), DateUtil.FormatPattern
                .DATE_TIME_FORMAT_PATTERN));
    }
}
