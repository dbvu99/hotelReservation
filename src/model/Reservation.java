package model;

import java.sql.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Reservation{customer='%s', room='%s', checkInDate='%s', checkOutDate='%s'}",
                customer.toString(),
                room.toString(),
                checkInDate.toString(),
                checkOutDate.toString()
            );
    }
}
