public class MyLinkedList {
    private LNode head;
 
    public boolean add(int value) {
	if (head == null) {
	    head = new LNode(value);
	    return true;
	} else {	    
	}
	return false;
    }
   
    public String toString() {
	String arr = "[";
	arr += "]";
	return arr;
    }

    private class LNode {
	private int num;
	private LNode node;
	
	public LNode(int num) {
	    this.num = num;
	}

	public int getValue() {
	    return num;
	}

	public void setValue(int num) {
	    this.num = num;
	}

	public LNode getNext() {
	    return node;
	}

	public void setNext(LNode node) {
	    this.node = node;
	}
    }
}
