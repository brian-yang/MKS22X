public class Recursion implements hw01 {
    public String name() {
	return "Yang,Brian";
    }

    public double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	double guess = n / 2;
	return guessBetter(n, guess);
    }

    // Recursively calculates a new guess and checks for accuracy
    // to the nearest thousandth of a percent
    public double guessBetter(double n, double guess) {
	if ((Math.abs(n - guess * guess) / n) * 100.0 < 0.001) {
	    return guess;
	}
	guess = (n / guess + guess) / 2;
	return guessBetter(n, guess);
    }		  
}
