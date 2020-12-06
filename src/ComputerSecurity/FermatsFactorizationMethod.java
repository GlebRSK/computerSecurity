package ComputerSecurity;

public class FermatsFactorizationMethod {
	public static void Search (int n) {
		int s = (int)Math.ceil(Math.sqrt(n));
		int i = 1;
		double y = 2;
		boolean flag = true;
		while (flag) {
		    y = Math.sqrt(((int)Math.pow(s + i, 2)) - n);
			if (y - Math.ceil(y) == 0) {
				flag = false;
			}
		    i++;
		}
		System.out.println(i);
		int a = s + i - 1 + (int)y;
		int b = s + i - 1 - (int)y;
		System.out.println("a " + a + " b " + b);
	}
	public static void main(String[] args) {
		Search(2231);
	}
}
