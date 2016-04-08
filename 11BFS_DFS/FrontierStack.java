import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    // Implemented using a Stack<T> (built-in)
    private Stack<T> s;

    public FrontierStack() {
	s = new Stack<T>();
    }

    public void add(T element) {
	s.push(element);
    }

    public T next() {
	if (!hasNext()) {
	    throw new NoSuchElementException();
	}
	return s.pop();
    }

    public boolean hasNext() {
	return !s.isEmpty();
    }

    public String toString() {
	return s.toString();
    }
}
