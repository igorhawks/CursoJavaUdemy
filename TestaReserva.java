package Capitulo15Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestaReserva {
    public static void main(String[] args) throws ParseException {
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room Number");
        int number = teclado.nextInt();
        System.out.println("CheckIn data: ");
        Date checkIn = sdf.parse(teclado.next());
        System.out.println("CheckOut data: ");
        Date checkOut = sdf.parse(teclado.next());

        if(!checkOut.after(checkIn))
        {
            System.out.println("Erro, Data do checkOut não é posterior a data de checkIn");
        }
        else
        {
            Reserva reserva = new Reserva(number,checkIn,checkOut);
            System.out.println("Reserva: "+ reserva);

            System.out.println();
            System.out.println("Entre com as novas datas para atualização: ");
            System.out.println("CheckIn data: ");
            checkIn = sdf.parse(teclado.next());
            System.out.println("CheckOut data: ");
            checkOut = sdf.parse(teclado.next());

            String erro = reserva.updateDates(checkIn,checkOut);
            if(erro!=null)
            {
                System.out.println("Erro: " + erro);
            }
            else
            {
                System.out.println("Reserva: " + reserva);
            }
        }
        teclado.close();
    }
}
