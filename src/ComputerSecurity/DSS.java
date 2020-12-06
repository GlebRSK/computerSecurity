package ComputerSecurity;

import java.util.Random;

public class DSS {
	public static void D(int message) {
		Random myRand = new Random();
		int p = myRand.nextInt(100), q = myRand.nextInt(100), x = myRand.nextInt(p), k = myRand.nextInt(p);
		while((!Function.SimpleNumb(p)) || (p < 10)) {
			p = myRand.nextInt(100);
		}
		//System.out.println(p);
		while((!Function.SimpleNumb(q)) || (q < 10) || (q == p)) {
			q = myRand.nextInt(100);
		}
		//System.out.println(q);
		
		while((!Function.SimpleNumb(x)) || (x < 10) || (x == p)) {
			x = myRand.nextInt(p - 1);
		}
		//System.out.println(x);
		int y = Alg1.RapidPOW(q, x, p);
		//System.out.println(y);
		int h = 3;
		while((!Function.SimpleNumb(k)) || (k < 10) || (k == p)) {
			k = myRand.nextInt(p - 1);
		}
		//System.out.println("k= " + k);
		int r = Alg1.RapidPOW(q, k, p);
		//System.out.println(r);
		int s = Math.floorMod((h - x*r)*(Euclid.EuAlg(p - 1, k)), p - 1);
		System.out.println("s= " + s);
		System.out.println("Signature scheme: " + message + " " + r + " " + s);
		int LeftPart = Math.floorMod(Alg1.RapidPOW(y, r, p) * Alg1.RapidPOW(r, s, p), p);
		int RightPart = Alg1.RapidPOW(q, h, p);
		System.out.println(LeftPart + " " + RightPart);
	}
	public static void main(String[] args) {
		//D(100);
		int r = Alg1.RapidPOW(5, 3, 23);
		System.out.println(r);
		int s = Math.floorMod((15 - 11*10)*(Euclid.EuAlg(22,3)), 22);
		System.out.println("s= " + s);
		int y = Alg1.RapidPOW(5, 11, 23);
		System.out.println("y= " + y);
		int LeftPart = Math.floorMod(Alg1.RapidPOW(22, 10, 23) * Alg1.RapidPOW(10, 5, 23), 23);
		int RightPart = Alg1.RapidPOW(5, 15, 23);
		System.out.println(LeftPart + " " + RightPart);
	}
}
