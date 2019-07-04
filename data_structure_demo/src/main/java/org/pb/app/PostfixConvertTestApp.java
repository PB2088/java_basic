package org.pb.app;

import org.pb.util.PostfixConvertUtil;

public class PostfixConvertTestApp {
	public static void main(String[] args) {
		String infix = "3*(2+6)-8/(2+2)";
		PostfixConvertUtil convertUtil = new PostfixConvertUtil(infix);
		String postfix = "";
		try {
			postfix = convertUtil.doTrans();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(postfix);
	}
}
