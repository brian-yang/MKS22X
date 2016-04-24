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

	// return height of tree
	public int height() {
	    if (data == null) {
		return 0;
	    }
	    if (left != null && right != null) {
		return Math.max(left.height(), right.height()) + 1;
	    } else if (left != null) {
		return left.height() + 1;
	    } else if (right != null) {
		return right.height() + 1;
	    }
	    return 1;
	}

	// add value to tree
	public void add(T value) {
	    if (data == null) {
		data = value;
		System.out.println("text");

	    } else if (data.compareTo(value) > 0) {
		// if the integer is greater than the argument, return 1
		// if less than, return -1
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

	// public T remove(T value) {
	//     if (data.compareTo(value) == 0) {
	// 	if (numChildren() == 1) {
	// 	    if (left != null) {
	// 		data = left.getValue();
	// 		left = null;
	// 	    } else {
	// 		data = right.getValue();
	// 		right = null;
	// 	    }
	// 	} else if (numChildren() == 2) {

	// 	}
	//     }

	//     if (left != null) {
	// 	if (left.getData().compareTo(value) == 0) {
	// 	    if (left.numChildren() > 0) {
	// 		left.remove(value);
	// 	    } else {
	// 		left = null;
	// 	    }
	// 	}
	//     }

	//     if (right != null) {
	// 	if (right.getData().compareTo(value) == 0) {
	// 	    if (right.numChildren() > 0) {
	// 		right.remove(value);
	// 	    } else {
	// 		right = null;
	// 	    }
	// 	}
	//     }

	// }



	// toString
	public String toString() {
	    if (data == null) {
		return "";
	    } else {
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
	}

	public boolean contains(T value) {
	    // base cases
	    if (height() == 0) {
		return false; // if no elements in tree
	    } else if (height() == 1) {
		return data.compareTo(value) == 0;
	    }
	    // recursion
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

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	if (isEmpty()) {
	    return 0;
	}
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
	if (isEmpty()) {
	    root = new Node();
	}
	root.add(value);
    }

    // public T remove (T value) {
    // 	if (isEmpty() || !root.contains(value)) {
    // 	    throw new NoSuchElementException();
    // 	}
    // 	if (root.getValue().compareTo(value) == 0 &&
    // 	    root.height() == 1) {
    // 	    T oldValue = root.getValue();
    // 	    root = null;
    // 	    return oldValue;
    // 	}
    // 	return root.remove(value);
    // }

    public String toString(){
	//check for empty before you do things with root.
	if (isEmpty()) {
	    return "";
	}
	return root.toString();
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	if (isEmpty()) {
	    return false;
	}
	return root.contains(value);
    }

    public boolean isEmpty() {
	return root == null;
    }
}
