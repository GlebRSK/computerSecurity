package ComputerSecurity;
import java.util.Random;

import ComputerSecurity.*;
public class ShamirsSecretSharing {
	public static int EncryptSSS(int m) {
		Random myRand = new Random();
		int p = myRand.nextInt(100);
		while ((!Function.SimpleNumb(p)) || (p < m)) {
			 p = myRand.nextInt(100 + m/2);
		}
		System.out.println(p);
		int Ca = myRand.nextInt(p - 1) + 2;
		int Cb = myRand.nextInt(p - 1) + 2;
		while ((Function.MutualSimpleNumber(p - 1, Ca) != 1) || (Ca == p)) {
			Ca = myRand.nextInt(p - 4) + 2;
		}
		while ((Function.MutualSimpleNumber(p - 1, Cb) != 1) || (Cb == p)) {
			Cb = myRand.nextInt(p - 4) + 2;
		}
		System.out.println(Ca);
		System.out.println(Cb);
		int Da = Euclid.EuAlg(p - 1, Ca);
		int Db = Euclid.EuAlg(p - 1, Cb);
		System.out.println("Da= " + Da + " Db= " + Db);
		int x1 = Alg1.RapidPOW(m, Ca, p);
		System.out.println("x1= " + x1);
		int x2 = Alg1.RapidPOW(x1, Cb, p);
		System.out.println("x2= " + x2);
		int x3 = Alg1.RapidPOW(x2, Da, p);
		System.out.println("x3= " + x3);
		int x4 = Alg1.RapidPOW(x3, Db, p);
		return x4;
	}
	public static void main(String[] args) {
		System.out.println(EncryptSSS(102));
	}
	
}
