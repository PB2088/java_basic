package org.pb.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

/**
 *  通用工具类
 * @author bo.peng
 *
 */
public final class ToolsUtils {
    /** 数字正则表达式 */
    private static final String NUMBER_REG = "^[-\\+]?[.\\d]*$";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REG);

    /** 匹配+ - * / ()运算符 */
    private static final String SYMBOL = "\\+|-|\\*|/|\\(|\\)";

	private ToolsUtils() {}
	
	public static <T> boolean isEmpty(T obj) {
		return obj==null || obj.toString() == null || "".equals(obj.toString().trim());
	}

	public static <E> boolean isEmpty(List<E> objs) {
		return objs == null || objs.isEmpty();
	}

	public static <T> boolean isEmpty(T[] objs) {
		return objs == null || objs.length ==0;
	}

    public static <T> boolean notEmpty(T obj) {
        return !isEmpty(obj);
    }

    public static <E> boolean notEmpty(List<E> objs) {
        return !isEmpty(objs);
    }

    public static <T> boolean notEmpty(T[] objs) {
        return !isEmpty(objs);
    }

    /**
     * 是否为数字(int,double,float,long)
     * @param s 待匹配的字符串
     * @return 匹配结果
     */
    public static boolean isNumber(String s) {
        return NUMBER_PATTERN.matcher(s).matches();
	}

    /**
     * 判断是否为运算符
     * @param s 待匹配的字符串
     * @return 匹配结果
     */
	public static boolean isSymbol(String s) {
	    return s.matches(SYMBOL);
    }

    private static final String AUCTION_BOOST_CAR_LIST_CACHE_KEY = "AUCTION_BOOST_CAR_LIST_CACHE_KEY_%s";
    public static void main(String[] args) {
        System.out.println(String.format(AUCTION_BOOST_CAR_LIST_CACHE_KEY, "2019-7-25"));


        String uri = "/eapi/lubao/auction/verifySession.do";
        String url = "http://localhost:8080/eapi/lubao/auction/verifySession.do";

        System.out.println(url.replace(uri, "/logout.do"));


        System.out.println(Math.round(2137.5));
        System.out.println(BigDecimal.valueOf(21824234.9782342240020424).setScale(2,BigDecimal.ROUND_HALF_DOWN));
    }
}
