package org.pb.jvm.test01;

import java.util.ArrayList;
import java.util.List;

public class Test001 {
	public static void main(String[] args) {
		List<Demo01> demo01s = new ArrayList<>();
		
		while (true) {
			demo01s.add(new Demo01());
		}
	}
}
