package org.pb.basic.stack;

import java.util.Scanner;

/**
 * @author boge.peng
 * @create 2019-06-16 11:16
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表达式(前缀):");
        String expression = scanner.next();

        Calculator calculator = new Calculator(expression);
        System.out.println("计算结果:"+calculator.calculate());
    }
}
