package org.pb.java8;

import org.junit.Before;
import org.junit.Test;
import org.pb.bean.Address;
import org.pb.bean.Employee;
import org.pb.bean.Status;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author boge.peng
 * @create 2019-04-20 18:13
 */
public class StreamAPITest {

    private List<Employee> emps;

    @Before
    public void setUp() {
        emps = Arrays.asList(
                new Employee(101, "彭波", 18, 7999, new Address(22, "浙江", "杭州", "乔司"), Status.BUSY),
                new Employee(102, "皮皮虾", 25, 8999, new Address(22, "上海", "浦东", "玉兰"),Status.VACATION),
                new Employee(103, "三狗子子", 23, 6999, new Address(23),Status.FREE),
                new Employee(104, "二狗子", 22, 2999, new Address(23),Status.FREE),
                new Employee(105, "大狗子", 38, 8000, new Address(23),Status.BUSY),
                new Employee(106, "垒垒", 21, 5999, new Address(23),Status.FREE)
        );
    }

    @Test
    public void testStreamFilter() {
        Stream<Employee> stream = emps.stream()
                .filter(e -> {
                    return !Objects.equals(e.getAddress().getProvince(),null) && !Objects.equals(e.getAddress()
                            .getCity(),null);
                });

        List<Employee> employees = stream.collect(Collectors.toList());

        employees.forEach(System.out::println);
    }

    @Test
    public void testLimit() {
        emps.stream().limit(3).forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        emps.stream().skip(4).forEach(System.out::println);
    }

    @Test
    public void testMap() {
        List<String> strs = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        strs.stream().map((str) -> str.toUpperCase())
        .forEach(System.out::println);

        System.out.println("");

        emps.stream().map(Employee::getName).forEach(System.out::println);
    }

    /**
     * 检查是否匹配所有元素
     */
    @Test
    public void testAllMatch() {
        boolean match = emps.stream().allMatch((e) -> e.getStatus() == Status.FREE);
        System.out.println(match);
    }

    @Test
    public void testAnyMatch() {
        boolean anyMatch = emps.stream().anyMatch(e -> e.getStatus() == Status.VACATION);
        System.out.println(anyMatch);
    }

    @Test
    public void testNoneMatch() {
        boolean noneMatch = emps.stream().noneMatch(e -> e.getStatus() == Status.VACATION);
        System.out.println(noneMatch);
    }

    @Test
    public void testFindFirst() {
        Optional<Employee> first = emps.stream().findFirst();
        System.out.println(first.get());
    }

    @Test
    public void testReduce() {
        System.out.println(emps.stream().map(Employee::getSalary)
                .reduce(Double::sum).get());
    }

    @Test
    public void testCollect() {
        List<String> names = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names);
    }

    @Test
    public void testCollect02() {
        //总数
        Long count = emps.stream().collect(Collectors.counting());
        System.out.println(count);

        //平均值
        Double avgSalary = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avgSalary);

        //总和
        Double summary = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(summary);

        //最大值
        Optional<Employee> max = emps.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        //最小值
        Optional<Double> min = emps.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

        //分组
        Map<Status, List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        String s = emps.stream().map(Employee::getName).collect(Collectors.joining("-"));
        System.out.println(s);

    }
}
