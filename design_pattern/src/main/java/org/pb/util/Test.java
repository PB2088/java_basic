package org.pb.util;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * @author bo.peng
 * @create 2020-01-14 16:42
 */
public class Test {
    public static void main(String[] args) {
        String str3 = "测试汉字乱码";
        System.out.println(cnToUnicode(str3));

        JSONObject fmkModelData = new JSONObject();

        fmkModelData.put("partnerCode", "610000007401");
        fmkModelData.put("partnerPassWord", "DW7CHE");
        fmkModelData.put("brokenItemTaskNo", "2020011300000364");
        fmkModelData.put("biddingPrice", "14000");
        fmkModelData.put("remark", "测试汉字乱码");

        System.out.println(fmkModelData.toString());

        String jsonParse = CommonUtils.jsonParse(fmkModelData.toString());
        System.out.println(jsonParse);

        try {
            System.out.println("中文转Unicode之后处理结果：");
            System.out.println(new JSONObject(new String(jsonParse.getBytes(),"UTF-8")).getString("remark"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }
}
