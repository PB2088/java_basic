package org.pb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author bo.peng
 * @create 2019-08-13 10:27
 */
public class Test {
    public static void main(String[] args) throws ParseException {

        StringBuilder sqlBuf = new StringBuilder();
        sqlBuf.append("(?,");
        System.out.println(sqlBuf);

        sqlBuf.replace(sqlBuf.length() -1, sqlBuf.length(), ")");

        System.out.println(sqlBuf);


        System.out.println(String.format("wf_workitems_%03d", 3));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(sdf.format(new Date())));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        startDate = cal.getTime();

        System.out.println(startDate);
    }
}
