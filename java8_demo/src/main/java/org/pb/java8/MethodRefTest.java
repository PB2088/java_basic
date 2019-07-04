package org.pb.java8;

import org.junit.Test;
import org.pb.bean.Employee;

import java.util.Comparator;
import java.util.function.*;

/**
 * 方法引用: 若Lambda体中的内容有方法已经实现了,我们可以使用"方法引用"
 *
 * 主要三种语法格式:
 *  对象::实例方法名
 *  类::静态方法名
 *  类::实例方法名
 *
 *  注意:
 *    (1)Lambda体中调用方法的参数列表与返回值类型,要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 *    (2)若Lambda参数列表中的第一参数是实例方法的调用者,而第二个参数是实例方法 的参数时,可以使用ClassName::method
 *
 * @author boge.peng
 * @create 2019-04-14 21:11
 */
public class MethodRefTest {
    @Test
    public void test01() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("Hello Lambda!!");

        Consumer<String> con1 = System.out::println;
        con1.accept("22222");
    }

    @Test
    public void test02() {
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> com1 = Integer::compare;
    }

    @Test
    public void test03() {
        String str1 = "AA";
        String str2 = "BB";

        BiPredicate<String,String> biPredicate = (x,y) -> x.equals(y);
        System.out.println(biPredicate.test(str1,str2));

        BiPredicate<String,String> biPredicate2 = String::equals;
        System.out.println(biPredicate2.test(str1,str2));
    }

    @Test
    public void test04() {
        Supplier<Employee> supplier = () -> new Employee();
        System.out.println(supplier.get());

        Supplier<Employee> supplier2 = Employee::new;
        System.out.println(supplier2.get());
    }

    @Test
    public void test05() {
        Function<Integer,Employee> fun = (x) -> new Employee(x);
        Employee emp = fun.apply(22);
        System.out.println(emp);

        BiFunction<Integer,String,Employee> fun2 = Employee::new;
        Employee employee = fun2.apply(11, "AA");
        System.out.println(employee);
    }

    @Test
    public void test06() {
        Function<Integer,String[]> fun = (x) -> new String[x];

        Function<Integer,String[]> fun2 = String[]::new;
        String[] strings = fun2.apply(3);
        System.out.println(strings.length);
    }

}
