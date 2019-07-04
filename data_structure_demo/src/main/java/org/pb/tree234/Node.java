package org.pb.tree234;

public class Node {
	private static final int ORDER = 4;
	/** 子节点列表 */
	private Node[] childArray = new Node[ORDER];
	/** 节点元素列表 */
	private DataItem[] itemArray = new DataItem[ORDER-1];
	/** 父节点 */
	private Node parent;
	/** 节点元素个数 */
	private int numItems;
	
	/**
	 * 子节点连接该节点
	 * @param childNum
	 * @param child
	 */
	public void connectChild(int childNum,Node child) {
		childArray[childNum] = child;
		if (child != null) {
			child.parent = this;
		}
	}
	
	/**
	 * 分离子节点,并返回该子节点
	 * @param childNum
	 * @return
	 */
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}
	
	/**
	 * 获取子节点
	 * @param childNum
	 * @return
	 */
	public Node getChild(int childNum) {
		return childArray[childNum];
	}
	
	/**
	 * 获取该节点的父节点
	 * @return
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * 是否是叶子节点
	 * @return
	 */
	public boolean isLeaf() {
		return childArray[0] == null;
	}
	
	/**
	 * 获取节点元素个数
	 * @return
	 */
	public int getNumItems() {
		return numItems;
	}
	
	/**
	 * 根据索引,获取节点元素数据
	 * @param index
	 * @return
	 */
	public DataItem getItem(int index) {
		return itemArray[index];
	}
	
	/**
	 * 判断节点元素是否已满
	 * @return
	 */
	public boolean isFull() {
		return numItems == ORDER-1;
	}
	
	/**
	 * 查询元素,若找到元素,则返回索引位置,否则返回-1
	 * @param key
	 * @return
	 */
	public int findItem(long key) {
		for (int i=0;i < ORDER -1;i++) {
			if (itemArray[i] == null)
				break;
			else if (itemArray[i].getData() == key)
				return i;
		}
		return -1;
	}
	
	public int insertItem(DataItem newItem) {
		
		long newData = newItem.getData();
		
		for (int i=ORDER-2;i>=0;i--) {
			if (itemArray[i] == null) {
				continue;
			} else {
				long itemKey = itemArray[i].getData();
				if (newData < itemKey) {
					itemArray[i+1] = itemArray[i];
				} else {
					itemArray[i+1] = newItem;
					return i+1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}
	
	public DataItem removeItem() {
		DataItem temp = itemArray[numItems-1];
		itemArray[numItems-1] = null;
		numItems --;
		return temp;
	}
	
	public void displayNode() {
		for (int i=0;i<numItems;i++) {
			System.out.print(itemArray[i]);
		}
		System.out.println("/");
	}
}
