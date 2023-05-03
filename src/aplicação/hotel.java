package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.reserva;
import model.exceção.CheckException;

public class hotel {

	public static void main(String[] args)  {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("nùmero de quartos: ");
			int n = sc.nextInt();
			System.out.print("Check-in(dd/mm/aaaa): ");
			Date ci = sdf.parse(sc.next());
			System.out.print("Check-out(dd/mm/aaaa): ");
			Date co = sdf.parse(sc.next());
	
			reserva r = new reserva(n, ci, co);
			System.out.println(r);
			
			System.out.println();
			System.out.println("Update da reserva");
			System.out.print("Check-in(dd/mm/aaaa): ");
			ci = sdf.parse(sc.next());
			System.out.print("Check-out(dd/mm/aaaa): ");
			co = sdf.parse(sc.next());
			
			r.update(ci, co);
			System.out.println(r);
		}
		catch (ParseException e) {
			System.out.println("data invalida: use (dd/mm/aaaa)");
		}
		catch (CheckException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("ERROR");
		}
		
		

		sc.close();
	}

}
