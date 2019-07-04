package org.pb.app;

public class InfixApp {
	public static void main(String[] args) {
		//String inputStr = "A*(B+C)-D/(E+F)";
		String inputStr = "";
		InToPost inToPost = new InToPost(inputStr);
		String output = inToPost.doTrans();
		System.out.println(output);
	}
}
