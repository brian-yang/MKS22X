public class BSTree<T extends comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	// set/get: data/left/right
	public void setLeftNode(Node l) {
	    left = l;
	}

	public void setRightNode(Node r) {
	    right = r;
	}

	public Node getLeftNode() {
	    return left;
	}

	public Node getRightNode() {
	    return right;
	}

	//real methods here
	public int height() {
	    Node curLeft = left;
	    Node curRight = right;
	}

	public void add(T value) {
	}

	public String toString() {
	    return "";
	}

	public boolean contains(T value) {
	    return false;
	}
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	if (!isEmpty()) {
	    return root.height();
	}
	return 0;
    }

    public void add(T value){
	//check for empty before you do things with root.
	if (!isEmpty()) {
	    root.add(value);
	}
    }
    public String toString(){
	//check for empty before you do things with root.
	if (!isEmpty()) {
	    return root.toString();
	}
	return "";
    }
    public boolean contains(T value){
	if (!isEmpty()) {
	    return root.contains(value);
	}
	return false;
    }
    
    public boolean isEmpty() {
	return root == null;
    }
}
