package org.pb.java8;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pb.bean.Employee;

import java.util.*;

/**
 * @author boge.peng
 * @create 2019-04-14 20:21
 */
public class LambdaTest {

    private List<Employee> emps;

    @Before
    public void setUp() {
        emps = Arrays.asList(
                new Employee(101,"彭波",18,7999),
                new Employee(102,"皮皮虾",25,8999),
                new Employee(103,"三狗子子",23,6999),
                new Employee(104,"二狗子",22,2999),
                new Employee(105,"大狗子",38,8000),
                new Employee(106,"垒垒",21,5999)
        );
    }

    @Test
    public void testLambda01() {
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };

        TreeSet<String> ts = new TreeSet<>(com);

        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
    }

    @Test
    public void testLambda02() {
        Comparator<String> com = (x,y) -> Integer.compare(x.length(),y.length());
        TreeSet<String> ts = new TreeSet<>(com);
    }

    //需求：获取年龄小于35的员工信息
    public List<Employee> filterEmployee(List<Employee> emps,MyPredicate<Employee> predicate) {
        List<Employee> results = new ArrayList<>();
        for (Employee emp : emps) {
            if(predicate.test(emp)) {
                results.add(emp);
            }
        }

        return results;
    }

    /**
     * Lambda表达式
     */
    @Test
    public void testLambda03() {
        List<Employee> employees = filterEmployee(emps, (e) -> e.getAge() <= 35);
        System.out.println(employees);
    }

    /**
     * Stream API
     */
    @Test
    public void testLambda04() {
        emps.stream()
                .filter((e)->e.getAge() <= 35)
                .limit(2)
                .forEach(System.out::println);
    }

}
