package Capitulo15.CursoJavaUdemy;

import Capitulo15.CursoJavaUdemy.DominioException.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestaReserva {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("Room Number");
            int number = teclado.nextInt();
            System.out.println("CheckIn data: ");
            Date checkIn = sdf.parse(teclado.next());
            System.out.println("CheckOut data: ");
            Date checkOut = sdf.parse(teclado.next());

            Reserva reserva = new Reserva(number, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com as novas datas para atualização: ");
            System.out.println("CheckIn data: ");
            checkIn = sdf.parse(teclado.next());
            System.out.println("CheckOut data: ");
            checkOut = sdf.parse(teclado.next());

            reserva.updateDates(checkIn, checkOut);

            System.out.println("Reserva: " + reserva);
        }
        catch(ParseException e)
        {
            System.out.println("Data inválida");
        }
        catch(DomainException e)
        {
            System.out.println(e.getMessage());
        }


        teclado.close();
    }
}
