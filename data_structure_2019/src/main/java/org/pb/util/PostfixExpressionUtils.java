package org.pb.util;

import org.pb.basic.stack.ArrayStack;
import org.pb.basic.stack.Stack;
import org.pb.constant.OperatorPriorityEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 后缀表达式转换工具类
 *
 * @author bo.peng
 * @create 2019-06-18 11:14
 */
public class PostfixExpressionUtils {

    /**
     * 中缀表达式
     */
    private String infixExpression;

    /**
     * 运算符栈
     */
    private Stack<Character> stack;

    public static PostfixExpressionUtils build(String infixExpression) {
        return new PostfixExpressionUtils(infixExpression);
    }

    private PostfixExpressionUtils(String infixExpression) {
        this.infixExpression = infixExpression;
        stack = new ArrayStack<>(16);
    }

    /**
     * 中缀表达式转后缀表达式
     *
     * @return 转换后的后缀表达式数组
     */
    public List<String> transform() {
        if (ToolsUtils.isEmpty(infixExpression.replaceAll("\\s+",""))) {
            throw new RuntimeException("中缀表达式为空!");
        }

        char[] chars = infixExpression.replaceAll("\\s+","").toCharArray();
        List<String> suffixList = new ArrayList<>();

        StringBuilder numBuff = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {

            //处理多位数和小数
            String str = String.valueOf(chars[i]);
            if (!ToolsUtils.isSymbol(str)) {
                numBuff.append(str);
                if (i < chars.length - 1 && !ToolsUtils.isSymbol(String.valueOf(chars[i + 1]))) {
                    continue;
                } else {
                    suffixList.add(numBuff.toString());
                    numBuff.setLength(0);
                }
            }

            final boolean isSymbol = ToolsUtils.isSymbol(str);
            if (isSymbol) {
                //如果栈顶元素为空,或者当前运算符为'(',或者当前运算符的优先级大于栈顶元素,则直接入栈
                if (stack.isEmpty() || chars[i] == OperatorPriorityEnum.OPERATOR_BRACKET_LEFT.getOperator()
                        || (chars[i] != OperatorPriorityEnum.OPERATOR_BRACKET_RIGHT.getOperator() && OperatorPriorityEnum.getPriorityByOperator(chars[i]) > OperatorPriorityEnum.getPriorityByOperator(stack.peek()))) {
                    stack.push(chars[i]);
                    continue;
                }

                //当前运算符的优先级小于或等于栈顶元素,则出栈并把栈顶元素存入List中
                if (OperatorPriorityEnum.getPriorityByOperator(chars[i]) <= OperatorPriorityEnum.getPriorityByOperator(stack.peek())) {
                    while (!stack.isEmpty() && stack.peek() != OperatorPriorityEnum.OPERATOR_BRACKET_LEFT.getOperator()) {
                        suffixList.add(String.valueOf(stack.pop()));
                    }
                    stack.push(chars[i]);
                    continue;
                }

                if (chars[i] == OperatorPriorityEnum.OPERATOR_BRACKET_RIGHT.getOperator()) {
                    while (!stack.isEmpty() && stack.peek() != OperatorPriorityEnum.OPERATOR_BRACKET_LEFT.getOperator()) {
                        suffixList.add(String.valueOf(stack.pop()));
                    }
                    stack.pop();
                    continue;
                }

            }
        }

        while (!stack.isEmpty()) {
            suffixList.add(String.valueOf(stack.pop()));
        }

        return suffixList;
    }

    public static void main(String[] args) {
        PostfixExpressionUtils postfixExpressionUtils = PostfixExpressionUtils.build("30.5*(3-1)+ 50-2");
        System.out.println(postfixExpressionUtils.transform());
    }

}
