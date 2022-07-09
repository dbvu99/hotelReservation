package model;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
    }
    
    
    @Override
    public String toString() {
        return String.format(
                "FreeRoom{roomNumber='%s', price='%s', enumeration='%s'}",
                getRoomNumber(),
                getRoomPrice(),
                getRoomType()
            );
    }
}
