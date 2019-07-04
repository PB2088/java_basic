package org.pb.app;

import org.pb.util.CalculatePostfixUtil;
import org.pb.util.PostfixConvertUtil;

public class CalculatePostfixTestApp {

	/**
	 *<p>
	 *description:
	 *</p>
	 *@param args
	 * @author ex_pengbo
	 * @see
	 */
	public static void main(String[] args) {
		String infix = "3*(4+5)-6/(1+2)";
		PostfixConvertUtil convertUtil = new PostfixConvertUtil(infix);
		String postfix = "";
		try {
			postfix = convertUtil.doTrans();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("后缀表达式："+postfix);
		CalculatePostfixUtil postfixUtil = new CalculatePostfixUtil(postfix);
		
		Integer postfixValue=null;
		try {
			postfixValue= postfixUtil.doCalculate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("后缀表达式计算结果："+postfixValue);
	}

}
