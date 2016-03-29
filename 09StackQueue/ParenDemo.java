public class ParenDemo {
    public static void main(String[] args) {
	String input = "()()(([[]]))";
	if (args.length > 0) {
	    input = args[0];
	    System.out.println( isMatching(input) ); 
	} else {
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}	
    }
    
    public static boolean isMatching(String s) {
	MyStack<Character> openParens = new MyStack<Character>();
	for (int i = 0; i < s.length(); i++) {
	    if (isOpen(s.charAt(i))) {
		openParens.push( s.charAt(i) );
	    } else if (isClosing( s.charAt(i)) ) {
		if ( openParens.isEmpty() || s.charAt(i) != getMatch( openParens.peek()) ) {
		    return false;
		}
		openParens.pop();
	    }
	}
	return openParens.isEmpty();
    }

    private static boolean isOpen(char c) {
	return "<{[(".contains(Character.toString(c));
    }

    private static boolean isClosing(char c) {
	return ">}])".contains(Character.toString(c));
    }

    private static char getMatch(char c) {
	if (c == '<') {
	    return '>';
	} else if (c == '{') {
	    return '}';
	} else if (c == '[') {
	    return ']';
	} else {
	    return ')';
	}
    }
}
