package ComputerSecurity;

public class Function {
	public static boolean SimpleNumb(int x) {
		boolean flag = false;
		int count = 0;
		for (int i = 2; i < x/2; i++) {
			if (Math.floorMod(x, i) == 0) {
				count++;
			}
		}
		if (count == 0) {
			flag = true;
		}
		return flag;
	}
	public static int MutualSimpleNumber(int a, int b) {
		if (b == 0) {
			return a;
		}
		return MutualSimpleNumber(b, a % b);
	}
	public static void main(String[] args) {
		System.out.println(MutualSimpleNumber(5, 22));
	}
}
