package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args){
		
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			try {
			System.out.print("Número do quarto: ");
			int numero = sc.nextInt();
			
			System.out.print("Data de Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			
			System.out.print("Data de Check-Out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("\nReserva:\n" + reserva);
			
			System.out.println("Atualizando a reserva: ");
			
			System.out.print("Data de Check-In (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Data de Check-Out (dd/MMMM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.updateData(checkIn, checkOut);
			System.out.println("\nReserva: \n" + reserva);
		}
		catch(ParseException e) {
			System.out.println("Fomato de Data Inválido.");
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Número inválido, apenas números inteiros.");
		}
		catch(RuntimeException e) {
				System.out.println("Erro inesperado");
		}
		
		sc.close();

	}

}
