package org.pb.util;

import java.util.List;

public final class CommonFunctions {
	public static boolean isEmpty(Object obj) {
		return obj == null || obj.toString().trim().length() == 0;
	}
	
	public static boolean isEmpty(List<Object> objs) {
		return objs == null || objs.size() == 0;
	}
}
