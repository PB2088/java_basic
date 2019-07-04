package org.pb.java8;

import org.junit.Before;
import org.junit.Test;
import org.pb.bean.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author boge.peng
 * @create 2019-04-20 8:27
 */
public class LambdaExerciseTest {
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
    public void testEmpSortByAge() {
        Collections.sort(emps,(e1,e2) -> {
            return e1.getAge() - e2.getAge();
        });

        emps.stream().forEach(System.out::println);
    }

    @Test
    public void testMyFunction() {
        System.out.println(opt(200L, (x) -> x * 200));
    }

    private Long opt(Long param1,MyFunction myFunction) {
        return myFunction.op(param1);
    }
}
