package model;

public class Room implements  IRoom {
    private String roomNumber;
    private Double price;
    private RoomType roomType;

    public Room(String roomNumber, Double price, RoomType enumeration) {
        try {
            this.roomNumber = roomNumber;
            this.price = price;
            this.roomType = enumeration;
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return price == 0.0;
    }

    @Override
    public String toString() {
        return String.format(
                "{ roomNumber=%s, price=%s, roomType=%s }",
                roomNumber,
                price,
                roomType);
    }
    

    @Override
    public int hashCode() {
        return Integer.parseInt(roomNumber);
    }

}
