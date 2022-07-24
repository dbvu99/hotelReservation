package model;

import java.util.ArrayList;

public class ReservationOrderedList extends ArrayList<Reservation> {

    public ReservationOrderedList() {
        super();
    }

    public boolean addReservation(Reservation reservation) {
        try {
            if (this.size() == 0) {
                this.add(reservation);
                return true;
            }
            
            int i = 0;

            while (reservation.getCheckInDate().after(this.get(i).getCheckOutDate()) && i < this.size() - 1) {
                i++;
            }

            System.out.println(i);


            this.add(i,reservation);


        } catch (Exception e) {
            throw e;
        }

        return false;
    }

}
