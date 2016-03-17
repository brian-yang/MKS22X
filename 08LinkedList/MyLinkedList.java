public class MyLinkedList {
    private LNode head;
    private int size;

    public static void main(String[] args) {
	MyLinkedList l = new MyLinkedList();
	for (int i = 0; i < 10; i++) {
	    l.add((int) (Math.random() * 100));
	}
	// toString test
	System.out.println(l);
	// size(), get(int index) tests
	for (int i = 0; i < l.size(); i++) {
	    System.out.println(l.get(i));
	}
	System.out.println();
	// set(int index, int newValue) test
	for (int i = 0; i < l.size(); i++) {
	    System.out.println(l.set(i, 100));
	}
	System.out.println(l);
    }

    // BASIC GET AND SET METHODS

    public int size() {
	return size;
    }

    public int get(int index) {
	LNode cur = head;
	for (int i = 0; i < index; i++) {
	    cur = cur.getNext();
	}
	return cur.getValue();
    }

    public int set(int index, int newValue) {
	LNode cur = head;
	for (int i = 0; i < index; i++) {
	    cur = cur.getNext();
	}
	int old = cur.getValue();
	cur.setValue(newValue);
	return old;
    }

    // ADD TO END AND TOSTRING METHODS

    public boolean add(int value) {
	if (head == null) {
	    head = new LNode(value);
	    size = 1;
	    return true;
	} else {
	    LNode cur = head;
	    while (cur.getNext() != null) {
		cur = cur.getNext();
	    }
	    cur.setNext(new LNode(value));
	}
	size += 1;
	return true;
    }

    public String toString() {
	String arr = "[";
	LNode p = head;
	while(p != null){
	    arr += p.getValue();
	    if (p.getNext() != null){
		arr += ", ";
	    }
	    p = p.getNext();
	}
	arr += "]";
	return arr;
    }

    // ================================================
    // ================================================

    /*
     * LNODE INNER CLASS
     */

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
