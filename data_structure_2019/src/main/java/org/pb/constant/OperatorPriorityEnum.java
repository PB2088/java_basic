package org.pb.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author boge.peng
 * @create 2019-06-16 0:30
 */
public enum OperatorPriorityEnum {
    /** '+'操作符 */
    OPERATOR_ADD('+',1),
    /** '-'操作符 */
    OPERATOR_SUB('-',1),

    OPERATOR_MUL('*',2),
    OPERATOR_DIV('/',2),

    OPERATOR_BRACKET_LEFT('(',3),
    OPERATOR_BRACKET_RIGHT(')',3);

    /** 操作符 */
    private char operator;

    /** 优先级 */
    private int priority;

    private static final Map<Character,OperatorPriorityEnum> ENUM_CACHE = new HashMap<>();

    static {
        ENUM_CACHE.put(OPERATOR_ADD.operator,OPERATOR_ADD);
        ENUM_CACHE.put(OPERATOR_SUB.operator,OPERATOR_SUB);
        ENUM_CACHE.put(OPERATOR_MUL.operator,OPERATOR_MUL);
        ENUM_CACHE.put(OPERATOR_DIV.operator,OPERATOR_DIV);
        ENUM_CACHE.put(OPERATOR_BRACKET_LEFT.operator,OPERATOR_BRACKET_LEFT);
        ENUM_CACHE.put(OPERATOR_BRACKET_RIGHT.operator,OPERATOR_BRACKET_RIGHT);
    }

    public static int getPriorityByOperator(char operator) {
        if (ENUM_CACHE.containsKey(operator)) {
            return ENUM_CACHE.get(operator).priority;
        }
        return -1;
    }

    private OperatorPriorityEnum(char operator,int priority) {
        this.operator = operator;
        this.priority = priority;
    }

    public char getOperator() {
        return operator;
    }

    public int getPriority() {
        return priority;
    }

}
