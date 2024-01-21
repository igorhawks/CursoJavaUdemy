package Capitulo15Exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duration()
    {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);

    }

    public String updateDates( Date checkIn, Date checkOut)
    {
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now))
        {
            return "erro, data passada";
        }

        if(!checkOut.after(checkIn))
        {
            return "erro, CheckOut anterior ao checkIn";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;

    }

    @Override
    public String toString()
    {
        return "Room: " + this.roomNumber
                +", checkIn: "+sdf.format(checkIn)
                +", checkOut: " + sdf.format(checkOut)
                +", "+duration()+" nights";
    }

}
