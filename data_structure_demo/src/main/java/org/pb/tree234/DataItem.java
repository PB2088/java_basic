package org.pb.tree234;

public class DataItem {
	private long data;
	
	public DataItem(long data) {
		this.data = data;
	}
	
	public String toString() {
		return "/" + data;
	}

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

}
