package model;

import java.util.Date;

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

    public boolean isNotOverlapped(Date checkInDate, Date checkOutDate) {
        return (checkOutDate.before(this.checkInDate) || checkInDate.after(this.checkOutDate));
    }

    public IRoom getRoom() {
        return this.room;
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

    public Customer getCustomer() {
        return null;
    }



}
