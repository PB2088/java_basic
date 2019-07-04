package org.pb.linklist;

import org.junit.Test;

public class FirstLastListApp {
	
	@Test
	public void test01() {
		FirstLastList<Person> linkList = new FirstLastList<Person>();
		linkList.insertFirst(new Person("宋江","男",42));
		linkList.insertFirst(new Person("吴用","男",32));
		linkList.insertFirst(new Person("林冲","男",31));
		linkList.insertFirst(new Person("扈三娘","女",27));
		linkList.insertFirst(new Person("杨志","男",25));
		linkList.insertLast(new Person("武松","男",29));
		linkList.insertLast(new Person("潘金莲","女",25));
		
		linkList.displayList();
		System.out.println("----------test01() end-------------");
	}
	
	@Test
	public void test02() {
		LinkList<Person> linkList = new LinkList<Person>();
		linkList.insertAfter(new Person("宋江","男",42));
		linkList.insertAfter(new Person("吴用","男",32));
		linkList.insertAfter(new Person("林冲","男",31));
		linkList.insertAfter(new Person("扈三娘","女",27));
		linkList.insertAfter(new Person("杨志","男",25));
		
		linkList.displayList();
		System.out.println("----------test02() end-------------");
	}
	
	@Test
	public void test03() {
		LinkList<Person> linkList = new LinkList<Person>();
		linkList.insertAfter(new Person("宋江","男",42));
		linkList.insertAfter(new Person("吴用","男",32));
		linkList.insertAfter(new Person("林冲","男",31));
		linkList.insertAfter(new Person("扈三娘","女",27));
		linkList.insertAfter(new Person("杨志","男",25));
		linkList.insertAfter(new Person("武松","男",29));
		linkList.insertAfter(new Person("潘金莲","女",25));
		System.out.println("======删除元素之前======");
		linkList.displayList();
		linkList.deletByKeyWord("戒子cc");
		System.out.println("======删除元素之后======");
		linkList.displayList();
		System.out.println("----------test03() end-------------");
	}	
	
	@Test
	public void test04() {
		Object obj = "bbbbb";
		System.out.println("bbbbbbbbb".indexOf(obj.toString()));
		System.out.println("----------test04() end-------------");		
	}
}
