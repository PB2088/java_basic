package org.pb.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Java8内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 *      void accept(T t);
 *
 * Supplier<T> : 供给型接口
 *      T get();
 *
 * Function<T, R> : 函数型接口
 *      R apply(T t);
 *
 * Predicate<T> : 断言型接口
 *      boolean test(T t);
 *
 * @author boge.peng
 * @create 2019-04-17 23:48
 */
public class LambdaFunInterfaceTest {

    @Test
    public void testFunction() {
        String s = firstCharOnlyToUpper("aAAAAAAA",(word) -> {
            return word.isEmpty()
                    ? word :
                    new StringBuilder(word.length())
                            .append(word.substring(0,1).toUpperCase())
                            .append(word.substring(1).toLowerCase())
                            .toString();
        });

        System.out.println(s);
    }

    private String firstCharOnlyToUpper(String str , Function<String,String> fun) {
        return fun.apply(str);
    }

    @Test
    public void testSupplier() {
        List<Integer> integers = produceRandomNum(10, () -> (int) (Math.random() * 100));
        integers.forEach(System.out::println);
    }

    private List<Integer> produceRandomNum(int num,Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<=num;i++) {
            list.add(supplier.get());
        }

        return list;
    }

    @Test
    public void testConsumer() {
        happy(10000,(m) -> {
            System.out.println("杨总喜欢大宝剑,每次消费" + m + "元");
        });
    }

    public void happy(double money,Consumer<Double> consumer) {
        consumer.accept(money);
    }

}
