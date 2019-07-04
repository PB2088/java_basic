package org.pb.basic.stack;

import org.pb.util.PostfixExpressionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author boge.peng
 * @create 2019-06-18 23:57
 */
public class ReversePolishNotationCalculator {
    /**
     * 中缀表达式
     */
    private String infixExpression;

    private Stack<String> stack;

    private ReversePolishNotationCalculator(String infixExpression) {
        this.infixExpression = infixExpression;
        stack = new ArrayStack<>(16);
    }

    public static ReversePolishNotationCalculator build(String infixExpression) {
        return new ReversePolishNotationCalculator(infixExpression);
    }

    /**
     * 完整版的逆波兰计算器
     *
     * @return 最终计算结果
     */
    public BigDecimal calculate() {
        List<String> suffixList = PostfixExpressionUtils.build(infixExpression).transform();

        return doCaculate(suffixList);
    }

    /**
     * 根据后缀表达试计算结果
     *
     * @param suffixList
     * @return
     */
    private BigDecimal doCaculate(List<String> suffixList) {

        suffixList.stream().forEach(suffix -> {

            BigDecimal temp = null;
            switch (suffix) {
                case "+":
                    temp = add();
                    break;
                case "-":
                    temp = sub();
                    break;
                case "*":
                    temp = mul();
                    break;
                case "/":
                    temp = div();
                    break;
                default:
                    stack.push(suffix);
                    break;
            }
            if (temp != null) {
                stack.push(temp.toString());
            }
        });

        return new BigDecimal(stack.pop());
    }

    private BigDecimal div() {
        String first = stack.pop();
        String second = stack.pop();
        return new BigDecimal(second).divide(new BigDecimal(first));
    }

    private BigDecimal mul() {
        String first = stack.pop();
        String second = stack.pop();
        return new BigDecimal(first).multiply(new BigDecimal(second));
    }

    private BigDecimal sub() {
        String first = stack.pop();
        String second = stack.pop();
        return new BigDecimal(second).subtract(new BigDecimal(first));
    }

    private BigDecimal add() {
        String first = stack.pop();
        String second = stack.pop();
        return new BigDecimal(first).add(new BigDecimal(second));
    }
}
