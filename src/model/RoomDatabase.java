package model;

import java.util.Collection;
import java.util.HashMap;

public class RoomDatabase extends HashMap<String, IRoom> {
    private static final long serialVersionUID = 1L;
    private static RoomDatabase instance = null;

    private RoomDatabase() {
        super();
    }

    public Collection<IRoom> getAllRooms() {
        return this.values();
    }

    public static RoomDatabase getInstance() {
        return instance == null ? new RoomDatabase() : instance;
    }

    public IRoom getRoom(String roomNumber) {
        try {
            return this.get(roomNumber);
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public void addRoom(IRoom room) throws Exception {
        try {
            if (this.get(room.getRoomNumber()) != null) {
                throw new Exception("Room number must be unqiue.");
            }

            this.put(room.getRoomNumber(), room);

        } catch (Exception e) {
            throw e;
        }
    }
}
