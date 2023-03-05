import java.util.Scanner;

public class Random {
	public static void main(String [] args) {
		// iteration
		for(int i = 1; i <= 100; i++) {
			if(i % 5 == 0) {
				return;
			}
			System.out.println(i);
		}
		
		System.out.println("Hello");
	}
	
	boolean isPrime(int num) {
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
