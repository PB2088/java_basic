package org.pb.util;

import org.pb.stack.util.StackX;
/**
 * 
 *<p>
 *description:中缀表达式转后缀表达式
 *</p>
 * @author ex_pengbo
 * @since 2014-7-16
 * @see
 */
public final class PostfixConvertUtil {
	private StackX<Character> theStack;
	private String infixStr;
	private StringBuffer postfixStr;
	
	public PostfixConvertUtil(String infix) {
		this.infixStr = infix;
		int stackSize = (infixStr == null || infixStr.length()==0)?1:infixStr.length();
		this.theStack = new StackX<Character>(stackSize);
		this.postfixStr = new StringBuffer();
	}
	
	public String doTrans() throws Exception {
		
		if (CommonFunctions.isEmpty(infixStr)) {
			throw new Exception("中缀表达式为空!");
		}
		
		char[] infixCharArray = infixStr.toCharArray();
		
		for (int i=0;i<infixCharArray.length;i++) {
			char ch = infixCharArray[i];
			
			switch (ch) {
			case Constants.OPERATOR_ADD:
			case Constants.OPERATOR_SUB:
				getOpr(ch,getPrece(ch));
				break;
			case Constants.OPERATOR_MUL:
			case Constants.OPERATOR_DIV:
				getOpr(ch,getPrece(ch));
				break;
			case Constants.OPERATOR_BRACKET_LEFT:
				theStack.push(ch);
				break;
			case Constants.OPERATOR_BRACKET_RIGHT:
				getParen();
				break;
			default:
				postfixStr.append(ch);
				break;
			}
		}
		while (!theStack.isEmpty()) {
			postfixStr.append(theStack.pop());
		}
		return postfixStr.toString();
	}

	private void getParen() {
		while (!theStack.isEmpty()) {
			char chX = theStack.pop();
			if (chX == Constants.OPERATOR_BRACKET_LEFT) {
				break;
			} else {
				postfixStr.append(chX);
			}
		}
	}

	private void getOpr(char opThis, int prec1) {
		while (!theStack.isEmpty()) {
			char opTop = theStack.pop();
			if (opTop == Constants.OPERATOR_BRACKET_LEFT) {
				theStack.push(opTop);
				break;
			} else {
				int prec2 = getPrece(opTop);
				if (prec2 < prec1) {
					theStack.push(opTop);
					break;
				} else {
					postfixStr.append(opTop);
				}
			}
		}
		theStack.push(opThis);
	}
	
	private Integer getPrece(char oper) {
		if (oper == Constants.OPERATOR_ADD || oper == Constants.OPERATOR_SUB) {
			return Constants.OPERATOR_PRIORITY_1;
		} else {
			return Constants.OPERATOR_PRIORITY_2;
		}
	}

    public static void main(String[] args) {
        String str = "7*(2+1)*2-(5+1)-(5+3)-4";
        PostfixConvertUtil postfixConvertUtil = new PostfixConvertUtil(str);
        try {
            String postfix = postfixConvertUtil.doTrans();
            System.out.println(postfix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
