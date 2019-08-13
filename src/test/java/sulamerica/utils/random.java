package sulamerica.utils;

import java.util.Random;

public class random {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			Random rdm = new Random();
			System.out.println((rdm.nextInt(15)+1)* 1); 	
			rdm.nextInt(3);
		}
	}
}