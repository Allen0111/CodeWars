
public class Node {
	long value;
	int count;
	Node parent;
	Node left;
	Node right;
	
	Node(long value) {
		this.value = value;
		count = 0;
		parent = null;
		left = null;
		right = null;
	}
	
	Node(Node tree, long value) {
		this.value = value;
		count = 0;
		parent = tree;
		left = null;
		right = null;
	}
	
	public static Node deepCopy(Node old) {
		Node copy = new Node(old.getValue());
		copy.parent = old.getParent();
		copy.left = old.getLeft();
		copy.right = old.getRight();
		return copy;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	} 
	
	public void setLeft(Node leftChild) {
		left = leftChild;
	}
	
	public void setRight(Node rightChild) {
		right = rightChild;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public int getCount() {
		return count;
	}
	
	public int incCount() {
		return count++;
	}
	
	public long getValue() {
		return value;
	}
	
	public void setValue(long value) {
		
	}
	
}
