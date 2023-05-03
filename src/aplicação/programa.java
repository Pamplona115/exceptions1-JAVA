package aplicação;

import java.util.InputMismatchException;
import java.util.Scanner;

public class programa {

	public static void main(String[] args) {
		
		mtd1();
		
		System.out.println("fim");

	}
	public static void mtd1() {
		System.out.println("------1------");
		mtd2();
		System.out.println("------1------");
	}
	public static void mtd2() {
		System.out.println("------2------");
		Scanner sc = new Scanner(System.in);

		try {
			String[] v = sc.nextLine().split(" ");
			int p = sc.nextInt();
			System.out.println(v[p]);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("não há essa posição");
			e.printStackTrace();
			sc.next();
		} 
		catch (InputMismatchException e) {
			System.out.println("digite um número");
		}
		System.out.println("------2------");

		sc.close();

	}

}
