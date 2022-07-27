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

    public boolean isAfter(Reservation anotherReservation) {
        return this.checkInDate.after(anotherReservation.checkOutDate);
    }
    

    public boolean isBefore(Reservation anotherReservation) {
        return this.checkOutDate.before(anotherReservation.checkInDate);
    }

    public boolean isAfterDate(Date date) {
        return this.checkInDate.after(date);
    }


    public boolean isBeforeDate(Date date) {
        return this.checkOutDate.before(date);
    }


    public boolean isOverlapped(Date checkInDate, Date checkOutDate) {
        if (checkOutDate.before(this.checkOutDate) && checkOutDate.after(this.checkInDate)) {
            return true;
        }

        if (checkInDate.after(this.checkInDate) && checkInDate.before(this.checkOutDate)) {
            return true;
        }

        return false;
    }

    public IRoom getRoom() {
        return this.room;
    }

    @Override
    public String toString() {
        return String.format(
                "reservation={\n\scustomer=%s,\n\sroom=%s,\n\scheckInDate=%s,\n\scheckOutDate=%s\n}",
                customer.toString(),
                room.toString(),
                checkInDate.toString(),
                checkOutDate.toString()
            );
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }


    public Date getCheckOutDate() {
        return this.checkOutDate;
    }



}
