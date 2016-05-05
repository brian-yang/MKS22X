import java.util.NoSuchElementException;

public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	// Set methods
	public void setLeftNode(Node l) { left = l; }
	public void setRightNode(Node r) { right = r; }
	public void setValue(T value) { data = value; }
	// Get methods
	public Node getLeftNode() { return left; }
	public Node getRightNode() { return right; }
	public T getValue() { return data; }

	// Purpose: return height of tree
	public int height() {
	    if (left != null && right != null) {
	    	return Math.max(left.height(), right.height()) + 1;
	    } else if (left != null) {
	    	return left.height() + 1;
	    } else if (right != null) {
	    	return right.height() + 1;
	    }
	    return 1;
	}

	// Purpose: add value to tree
	public void add(T value) {
	    // adds to new node
	    if (data == null) {
		data = value;
	    }
	    // if T is greater than the argument, return 1
	    // if less than, return -1
	    else if (data.compareTo(value) > 0) {
		if (left == null) {
		    left = new Node();
		    left.setValue(value);
		} else {
		    left.add(value);
		}
	    } else {
		if (right == null) {
		    right = new Node();
		    right.setValue(value);
		} else {
		    right.add(value);
		}
	    }
	}

	// Purpose: remove value from tree
	public void remove(T value) {
	    removeRecur(value);
	}

	private boolean removeRecur(T value) {
	    // Checks if node's value matches
	    if (data.compareTo(value) == 0) {
		if (left.numChildren() == 0) {
		    data = left.getValue();
		    left = null;
		    return true;
		} else {
		    data = findGreatest(left);
		    return true;
		}
	    }

	    // Look at the children of the current node
	    else {
		if (left != null) {
		    // Left
		    if (left.getValue().compareTo(value) == 0 &&
			left.numChildren() == 1) {
			// doesn't matter if one child is null
			setLeftNode(left.getLeftNode());
			setRightNode(left.getRightNode());
			return true;
		    } else if (left.getValue().compareTo(value) == 0 &&
			       left.numChildren() == 0) {
			left = null;
			return true;
		    } else if (left.removeRecur(value)) {
			return true;
		    }
		}

		if (right != null) {
		    // Right
		    if (right.getValue().compareTo(value) == 0 &&
			right.numChildren() == 1){
			// doesn't matter if one child is null
			setLeftNode(right.getLeftNode());
			setRightNode(right.getRightNode());
			return true;
		    } else if (right.getValue().compareTo(value) == 0 &&
			       right.numChildren() == 0) {
			right = null;
			return true;
		    } else if (right.removeRecur(value)) {
			return true;
		    }
		}
		return false;
	    }
	}

        private T findGreatest(Node n) {
	    // Checks if there are no right nodes left
	    // that could possibly have a max value within the subtree
	    // if so, return the value of the current node and shift
	    // subtree up
	    if (n.getRightNode() == null) {
		T newValue = n.getValue();
		n = n.getLeftNode();
		return newValue;
	    }
	    // Checks right nodes for max values
	    // if end found, return value of the end right node
	    // and remove end right node
	    if (n.getRightNode().numChildren() == 0) {
		T newValue = n.getRightNode().getValue();
		Node oldNode = n.getRightNode();
		oldNode = null;
		return newValue;
	    }
	    return findGreatest(n.getRightNode());
	}

	// Purpose: return the number of children that a node has
	public int numChildren() {
	    int sum = 0;
	    if (left != null) {
		sum += 1;
	    }
	    if (right != null) {
		sum += 1;
	    }
	    return sum;
	}

	// toString
	public String toString() {
	    String toRet = data + " ";
	    //========================
	    if (left == null) {
		toRet += "_" + " ";
	    } else {
		toRet += left;
	    }
	    //========================
	    if (right == null) {
		toRet += "_" + " ";
	    } else {
		toRet += right;
	    }
	    //========================
	    return toRet;
	}

	// Purpose: checks if the tree contains a value
	public boolean contains(T value) {
	    // Base Case
	    if (height() == 1) {
		return data.compareTo(value) == 0;
	    }
	    // Recursion
	    if (data.compareTo(value) == 0) {
		return true;
	    } else if (data.compareTo(value) > 0) {
		if (left != null) {
		    return left.contains(value);
		}
	    } else if (data.compareTo(value) < 0) {
		if (right != null) {
		    return right.contains(value);
		}
	    }
	    return false;
	}
    }

    // Root node
    private Node root;

    //OUTER methods here are wrapper methods for the root

    // Returns the height of the BSTree
    public int getHeight(){
	if (isEmpty()) {
	    return 0;
	}
	return root.height();
    }

    // Adds values to the BSTree
    public void add(T value){
	//check for empty before you do things with root.
	if (isEmpty()) {
	    root = new Node();
	}
	root.add(value);
    }

    // Removes values from the BSTree
    public void remove (T value) {
    	if (isEmpty() || !root.contains(value)) {
    	    throw new NoSuchElementException();
    	}
	// deletes root node if it has 0 children and contains the
	// desired value
    	if (root.numChildren() == 0) {
    	    T oldValue = root.getValue();
    	    root = null;
    	}
	// replaces root node with left or right node if it has 1 child
	// and contains the desired value
	else if (root.numChildren() == 1 &&
		   root.getValue().compareTo(value) == 0) {
	    T oldValue;
	    if (root.getLeftNode() != null) {
		oldValue = root.getLeftNode().getValue();
		root = root.getLeftNode();
	    } else {
		oldValue = root.getRightNode().getValue();
		root = root.getRightNode();
	    }
	} else {
	    root.remove(value);
	}
    }

    // Returns the BSTree in String form
    public String toString(){
	//check for empty before you do things with root.
	if (isEmpty()) {
	    return "";
	}
	return root.toString();
    }

    // Checks if the BSTree contains a value
    public boolean contains(T value){
	//check for empty before you do things with root.
	if (isEmpty()) {
	    return false;
	}
	return root.contains(value);
    }

    // Checks if the BSTree is empty
    public boolean isEmpty() {
	return root == null;
    }
}
