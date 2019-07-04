package org.pb.basic.stack;

import org.pb.constant.OperatorPriorityEnum;
import org.pb.util.ToolsUtils;

/**
 * @author boge.peng
 * @create 2019-06-15 23:04
 */
public class Calculator {
    /**
     * 中缀表达式
     */
    private String expression;

    /**
     * 操作数栈
     */
    private Stack<Integer> numStack;

    /**
     * 操作符栈
     */
    private Stack<Character> operatorStack;

    public Calculator(String expression) {
        this.expression = expression;

        numStack = new ArrayStack<>(10);
        operatorStack = new ArrayStack<>(10);
    }

    public boolean isOperator(char opt) {
        return opt == OperatorPriorityEnum.OPERATOR_ADD.getOperator() ||
                opt == OperatorPriorityEnum.OPERATOR_SUB.getOperator() ||
                opt == OperatorPriorityEnum.OPERATOR_MUL.getOperator() ||
                opt == OperatorPriorityEnum.OPERATOR_DIV.getOperator() ||
                opt == OperatorPriorityEnum.OPERATOR_BRACKET_LEFT.getOperator() ||
                opt == OperatorPriorityEnum.OPERATOR_BRACKET_RIGHT.getOperator();
    }

    /**
     * 计算前缀表达式的值
     *
     * @return
     */
    public Integer calculate() {
        checkExpression(expression);

        char[] chars = expression.toCharArray();
        StringBuilder numBuffer = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {

            if (!isOperator(chars[i])) {
                numBuffer.append(chars[i]);

                if (i != chars.length -1 && !isOperator(chars[i+1])) {
                    continue;
                }
                numStack.push(Integer.valueOf(numBuffer.toString()));
                numBuffer.setLength(0);
            }

            if (isOperator(chars[i])) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(chars[i]);
                } else {
                    if (OperatorPriorityEnum.getPriorityByOperator(chars[i]) <= OperatorPriorityEnum
                            .getPriorityByOperator(operatorStack.peek()) && operatorStack.peek() !=
                            OperatorPriorityEnum.OPERATOR_BRACKET_LEFT.getOperator()) {
                        doCalculate(operatorStack.pop());

                        operatorStack.push(chars[i]);
                    } else {
                        //处理带小括号的情况
                        if (chars[i] == OperatorPriorityEnum.OPERATOR_BRACKET_RIGHT.getOperator()) {
                            while (operatorStack.peek() != OperatorPriorityEnum.OPERATOR_BRACKET_LEFT.getOperator()) {
                                doCalculate(operatorStack.pop());
                            }
                            operatorStack.pop();
                        } else {
                            operatorStack.push(chars[i]);
                        }
                    }
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            doCalculate(operatorStack.pop());
        }

        return numStack.pop();
    }

    private void doCalculate(Character ch) {
        Integer temp = null;
        switch (ch) {
            case '+':
                temp = add();
                break;
            case '-':
                temp = sub();
                break;
            case '*':
                temp = mul();
                break;
            case '/':
                temp = div();
                break;
            default:
                numStack.push((Integer) (ch - '0'));
                break;
        }
        if (temp != null) {
            numStack.push(temp);
        }
    }

    private void checkExpression(String expression) {
        if (ToolsUtils.isEmpty(expression)) {
            throw new RuntimeException("表达式为空!");
        }
    }

    private Integer div() {
        Integer first = numStack.pop();
        Integer second = numStack.pop();
        return second / first;
    }

    private Integer mul() {
        Integer first = numStack.pop();
        Integer second = numStack.pop();
        return first * second;
    }

    private Integer sub() {
        Integer first = numStack.pop();
        Integer second = numStack.pop();
        return second - first;
    }

    private Integer add() {
        Integer first = numStack.pop();
        Integer second = numStack.pop();
        return first + second;
    }

    public static void main(String[] args) {
        String exp = "7+5+3*8-2";

        char[] chars = exp.toCharArray();
        for (char ch : chars) {
            System.out.println((int) (ch - '0'));
        }
    }

}
