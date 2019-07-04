package org.pb.binarytree;

public class Node {
	private long iData;
	private Node leftChild;
	private Node rightChild;
	
	public long getiData() {
		return iData;
	}

	public void setiData(long iData) {
		this.iData = iData;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

    @Override
    public String toString() {
        return "Node{" +
                "iData=" + iData +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
