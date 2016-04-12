public class Driver {
    public static void main(String[] args) {
	BetterMaze bm = new BetterMaze("data2.dat");
	bm.setAnimate(true);
	bm.solveDFS();
	System.out.println(bm);
    }
}
