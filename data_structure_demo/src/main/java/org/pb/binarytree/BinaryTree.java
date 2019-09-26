package org.pb.binarytree;

import java.util.Objects;

public class BinaryTree {
	private Node root;
	
	public Node getRoot() {
		return root;
	}

	/**
	 * 查找节点
	 * @param keyValue
	 * @return
	 */
	public Node find(long keyValue) {
		Node current = root;
		while(current.getiData() != keyValue) {
			if(keyValue < current.getiData()) {
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
			
			if(current == null) {
				return null;
			}
		}
		
		return current;
	}

	public Node findKey(long keyValue) {
	    return findKey(keyValue,root);
    }

    private Node findKey(long keyValue,Node node) {
	    if (Objects.isNull(node) || (node != null && node.getiData() == keyValue)) {
	        return node;
        } else {
            Node node1 = findKey(keyValue, node.getLeftChild());
            Node node2 = findKey(keyValue, node.getRightChild());

            if (!Objects.equals(node1,null) && Objects.equals(node1.getiData(),keyValue)) {
                return node1;
            } else if (!Objects.equals(node2,null) && Objects.equals(node2.getiData(),keyValue)) {
                return node2;
            } else {
                return null;
            }
        }
    }
	
	/**
	 * 插入节点
	 * @param keyValue
	 */
	public void insert(long keyValue) {
		Node newNode = new Node();
		newNode.setiData(keyValue);
		
		if(root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(keyValue <current.getiData()) {
					current = current.getLeftChild();
					if(current == null) {
						parent.setLeftChild(newNode);
						return;
					}
				} else {
					current = current.getRightChild();
					if (current == null) {
						parent.setRightChild(newNode);
						return;
					}
				}
			}
		}
	}
	
	/**
	 * 中序遍历
	 * @param localRoot
	 */
	public void  inOrder(Node localRoot) {
		if(localRoot != null) {
			inOrder(localRoot.getLeftChild());
			System.out.print(localRoot.getiData() + " ");
			inOrder(localRoot.getRightChild());
		}
	}
	
	public void displayNode(Node localRoot) {
		System.out.print("{");
		inOrder(localRoot);
		System.out.print("}");
        System.out.println("");
    }
	
	/**
	 * 查找最小值
	 * @return
	 */
	public Node minimum() {
		Node current = root;
		Node last =null ;
		while(current != null) {
			last = current;
			current = current.getLeftChild();
		}
		return last;
	}
	
	/**
	 * 查找最大值
	 * @return
	 */
	public Node maximum() {
		Node current = root;
		Node last =null ;
		while(current != null) {
			last = current;
			current = current.getRightChild();
		}
		return last;
	}
	
	
	/**
	 * 删除子节点
	 * @param keyValue
	 */
	public void deleteChildNodes(long keyValue) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.getiData() != keyValue) {
			parent = current;
			
			if(keyValue < current.getiData()) {
				isLeftChild = true;
				current = current.getLeftChild();
			} else {
				isLeftChild = false;
				current = current.getRightChild();
			}
			
			if (current == null) {
				throw new RuntimeException("要删除的节点不存在!");
			}
		}
		
		if(current.getLeftChild() == null && current.getRightChild() == null) {
			if(current == root) {
				root = null;
			} else if(isLeftChild) {
				parent.setLeftChild(null);
			} else{
				parent.setRightChild(null);
			}
		} else if(current.getRightChild() == null) {
			if(current == root) {
				root = current.getLeftChild();
			} else if(isLeftChild) {
				parent.setLeftChild(current.getLeftChild());
			} else {
				parent.setRightChild(current.getLeftChild());
			}
			
		} else if(current.getLeftChild() == null) {
			if(current == root) {
				root = current.getRightChild();
			} else if(isLeftChild) {
				parent.setLeftChild(current.getRightChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}
			
		} else {
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			successor.setLeftChild(current.getLeftChild());
		}
	}
	
	/**
	 * 获取后继节点
	 * @param node
	 * @return
	 */
	private Node getSuccessor(Node node) {
		Node current = node.getRightChild();
		Node successorParent = node;
		Node successor = node;
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeftChild();
		}
		
		if (successor != node.getRightChild()) {
			successorParent.setLeftChild(successor.getRightChild());
			successor.setRightChild(node.getRightChild());
		}
		
		return successor;
	}
}
