import java.util.ArrayList;


public class BinarySearchTree {

	public static Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public boolean findNodeByValue(int val) {
		Node current = Node.deepCopy(root);
		
		while (current != null) {
			if (current.value == val) {
				return true;
			} else if (current.value >= val) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}
	
	public boolean findNodeByCount(int val) {
		
		Node current = Node.deepCopy(root);
		
		while (current != null) {
			if (current.count == 3) {
				return true;
			} else if (current.value >= val) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}
	
	public void deleteNode(int val) {
		deleteNodeUtil(root, val);
	}
	
	private void deleteNodeUtil(Node node, int val) {
		
		if (root == null) {
			return;
		}
		
		if (val < node.value) {
			
			deleteNodeUtil(node.getLeft(), val);
			
		} else if ( val > node.value){
			
			deleteNodeUtil(node.getRight(), val);
			
		} else {		//found the node

			Node successor = node.getRight();
			
			if (node.getLeft() != null && node.getRight() != null) { // two children in the tree
				if (successor != null) {
					
					successor = getSuccessor(successor);
					node.setValue(successor.getValue());
					
				}
				
			} else if (node.getLeft() == null && node.getRight() != null) { // node has a right child
				
				if (node.getParent().getRight() == node) {		// node is a rightChild of parent
					
					node.getParent().setRight(node.getRight());
					node.getRight().setParent(node.getParent());
					
				} else {										//node is a leftChild of a parent
					
					node.getParent().setLeft(node.getRight());
					node.getRight().setParent(node.getParent());
					
				}
				
			} else if (node.getLeft() != null && node.getRight() == null) { // node has a left child
				
				if (node.getParent().getRight() == node) { // node is a rightChild
					
					node.getParent().setRight(node.getLeft());
					node.getLeft().setParent(node.getParent());
					
				} else {
					
					node.getParent().setLeft(node.getLeft());
					node.getLeft().setParent(node.getParent());
					
				}
			} else { // node has no children
				
				if( node.getParent().getRight() == node) { //the node is the rightChild of the parent
					
					node.getParent().setRight(null);
					
				} else { // the node is a leftChild of the parent
					node.getParent().setRight(null);
				}
			}
		}					
	}
	
	private Node getSuccessor(Node successor) {
		if (successor != null) {
			successor = successor.getLeft();
		}
		return successor;
	}
	
	
	
	public void insertNode(long val) {		
		insertNodeUtil(root, val);
	}
	
	private void insertNodeUtil(Node tree, long val) {
		
		if (tree == null) {
			
			tree = new Node(tree, val);
			
		}
		
/*		if (tree.getValue() == val) {
			
			tree.incCount();
			return;
			
		}*/
		
		if (tree.getValue() > val) {
			
			if (tree.getLeft() == null) {
				
				tree.setLeft(new Node(tree, val));
				
			} else {
				
				insertNodeUtil(tree.getLeft(), val);
				
			}
			
		}
		
		if (tree.getValue() < val) {
			
			if (tree.getRight() == null) {
				tree.setRight(new Node(tree, val));
			} else {
				insertNodeUtil(tree.getRight(), val);	
			}
		}
	}
	
	public String toString() {
		
		toStringUtil(root);
		return "done";
		
	}
	
	private static void toStringUtil( Node node ) {
		if (node != null) {
			toStringUtil(node.getLeft());
			System.out.println(node.getValue());
			toStringUtil(node.getRight());
		}
	}
}
