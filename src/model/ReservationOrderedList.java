package model;

import java.util.ArrayList;
import java.util.Date;

public class ReservationOrderedList extends ArrayList<Reservation> {

    public ReservationOrderedList() {
        super();
    }

    public Reservation addReservation(Reservation reservation) {
        try {
            int i = 0;

            while (i <= this.size() - 1 && reservation.isAfter(this.get(i))) {
                i++;
            }

            this.add(i, reservation);
            return reservation;

        } catch (Exception e) {
            throw e;
        }

    }

    public Reservation addNewReservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        try {
            int i = 0;

            while (i <= this.size() - 1 && this.get(i).isBeforeDate(checkInDate)) {
                i++;
            }
            
            if (this.get(i).isAfterDate(checkOutDate)) {
                Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
                this.add(i, reservation);
                return reservation;
            }

            // this.add(i, reservation);
            // return reservation;

            return null;

        } catch (Exception e) {
            throw e;
        }

    }

    public boolean isNotOverlapped(Date checkInDate, Date checkOutDate) {
        try {
            int i = 0;
            while (i <= this.size() - 1 && this.get(i).isBeforeDate(checkInDate)) {
                i++;
            }
            // System.out.println("last i " + i);

            // if (i == 0) {
            //     return this.get(i).isAfterDate(checkOutDate);
            // }
            
            if (i >= 0 && i < this.size()) {
                return this.get(i).isAfterDate(checkOutDate);
            }

            if (i == this.size()) {
                return true;
            }

            return false;
        } catch (Exception e) {
            throw e;
        }
    }

}
