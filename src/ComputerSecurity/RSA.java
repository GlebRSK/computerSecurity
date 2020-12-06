package ComputerSecurity;
import java.util.Random;

import ComputerSecurity.*;
public class RSA {
	public static void RSA(int message) {
		Random myRand = new Random();
		int pb = myRand.nextInt(20), qb = myRand.nextInt(20);
		while((!Function.SimpleNumb(pb)) || (pb < 5)) {
			pb = myRand.nextInt(20);
		}
		System.out.println(pb);
		while((!Function.SimpleNumb(qb)) || (qb < 5) || (qb == pb)) {
			qb = myRand.nextInt(20);
		}
		System.out.println(qb);
		int Nb = pb * qb;
		System.out.println(Nb);
		int F = (pb - 1)*(qb - 1);
		//System.out.println(F);
		int db = myRand.nextInt(F);
		while ((Function.MutualSimpleNumber(db, F) != 1) || (db < 10)) {
			db = myRand.nextInt(F);
		}
		System.out.println("Db " + db);
		int Cb = Euclid.EuAlg(F, db);
		System.out.println("Cb" + Cb);
		int e = Alg1.RapidPOW(message, db, Nb);
		System.out.println("e " + e);
		int _message = Alg1.RapidPOW(e, Cb, Nb);
		System.out.println(_message);		
	}
	public static void main(String[] args) {
		RSA(20);
	}	
}