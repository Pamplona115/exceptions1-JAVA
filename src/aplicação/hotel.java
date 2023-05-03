package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.reserva;

public class hotel {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("nùmero do quarto: ");
		int n = sc.nextInt();
		System.out.print("Check=in(dd/mm/aaaa): ");
		Date ci = sdf.parse(sc.next());
		System.out.print("Check=out(dd/mm/aaaa): ");
		Date co = sdf.parse(sc.next());

		if (!co.after(ci)) {
			System.out.println("ERRO: Check-Out deve ser depois do Check-In.");
		} 
		else {
			reserva r = new reserva(n, ci, co);
			System.out.println(r);
			System.out.println();
			System.out.println("Update da reserva");
			System.out.print("Check=in(dd/mm/aaaa): ");
			ci = sdf.parse(sc.next());
			System.out.print("Check=out(dd/mm/aaaa): ");
			co = sdf.parse(sc.next());
			Date agr = new Date();
			if (ci.before(agr) || co.before(agr)) {
				System.out.println("ERRO: As datas não são atuais.");
			} 
			else if (!co.after(ci)) {
				System.out.println("ERRO: Check-Out deve ser depois do Check-In.");
			}
			else {
				r.update(ci, co);
				System.out.println(r);
			}

		}

		sc.close();
	}

}
