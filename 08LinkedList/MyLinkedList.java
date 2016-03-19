public class MyLinkedList {
    private LNode head;
    private LNode last;
    private int size;

    public static void main(String[] args) {
	MyLinkedList l = new MyLinkedList();
	// ============ARGUMENTS===============
	int arrSize;
	if (args.length > 0) {
	    arrSize = Integer.parseInt(args[0]);
	} else {
	    arrSize = 10;
	}
	// ====================================
	for (int i = 0; i < arrSize; i++) {
	    l.add((int) (Math.random() * 100));
	}
	// toString test
	System.out.println("toString Test");
	System.out.println(l);
	System.out.println();

	// size(), get(int index) tests
	System.out.println("get tests");
	for (int i = 0; i < l.size(); i++) {
	    System.out.println(l.get(i));
	}
	System.out.println();

	// set(int index, int newValue) test
	System.out.println("set tests");
	for (int i = 0; i < l.size(); i++) {
	    System.out.println(l.set(i, (int) (Math.random() * 100)));
	}
	System.out.println(l);
	System.out.println();

	// indexOf test
	System.out.println("index of 100");
	System.out.println(l.indexOf(100));
	System.out.println();

	// add(int index, int value) test
	System.out.println("Add Tests");
	for (int i = 0; i < 1; i++) {
	    System.out.println( l.add((int) (Math.random() * l.size()), (int) (Math.random() * 100)) );
	    System.out.println(l);
	}
	System.out.println();

	// add(int index, int value) test
	System.out.println("Remove Tests");
	for (int i = 0; i < 1; i++) {
	    //System.out.println( l.remove((int) (Math.random() * l.size())) );
	    System.out.println( l.remove(0) );
	    System.out.println(l);
	}
	System.out.println();
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

    // INDEXOF METHOD

    public int indexOf(int value) {
	LNode cur = head;
	int index = 0;
	while (cur != null) {
	    if (cur.getValue() == value) {
		return index;
	    }
	    index++;
	    cur = cur.getNext();
	}
	return -1;
    }

    // ADD AND REMOVE

    public boolean add(int index, int value) {
	// edge cases
	if (index > size || index < 0) {
	    return false;
	} // CALLING add(int value) MIGHT MAKE this add function faster
	// add at index
	LNode rep = new LNode(value);
	// Connect new node to previous head
	if (index == 0) {
	    rep.setNext(head);
	    head = rep;
	} else {
	    LNode cur = head;
	    int curIndex = 0;
	    while (curIndex < index - 1) {
		cur = cur.getNext();
		curIndex++;
	    }
	    // Set current
	    rep.setNext(cur.getNext());
	    cur.setNext(rep);
	}
	size++;
	return true;
    }

    public boolean remove(int index) {
	if (size() == 0 || index >= size || index < 0) {
	    return false;
	}
	// Set head to next node after removed first node
	if (index == 0) {
	    head = head.getNext();
	} else {
	    LNode cur = head;
	    int curIndex = 0;
	    while (curIndex < index - 1) {
		cur = cur.getNext();
		curIndex++;
	    }
	    if (index == size - 1) {
		last = cur;
	    }
	    // Set current
	    cur.setNext(cur.getNext().getNext());
	}
	size--;
	return true;
    }

    // ADD TO END AND TOSTRING METHODS

    public boolean add(int value) {
	if (head == null) {
	    head = new LNode(value);
	    last = head;
	} else {
	    last.setNext(new LNode(value));
	    last = last.getNext();
	}
	size++;
	return true;
    }

    public String toString() {
	String arr = "[";
	LNode p = head;
	while (p != null){
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
