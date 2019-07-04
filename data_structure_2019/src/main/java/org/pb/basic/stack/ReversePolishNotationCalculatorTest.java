package org.pb.basic.stack;

import java.math.BigDecimal;

/**
 * @author boge.peng
 * @create 2019-06-19 0:22
 */
public class ReversePolishNotationCalculatorTest {
    public static void main(String[] args) {
        BigDecimal calculate = ReversePolishNotationCalculator.build("12.8+(2-3.55)*4+10/5.0").calculate();
        System.out.println("计算结果: " + calculate);
    }
}
