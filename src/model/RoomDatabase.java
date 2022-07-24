package model;

import java.util.HashMap;

public class RoomDatabase extends HashMap<String, IRoom> {
    private static final long serialVersionUID = 1L;
    private static RoomDatabase instance = new RoomDatabase();
    
    private RoomDatabase() {
        super();
    }
    
    public static RoomDatabase getInstance() {
        return instance;
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
            if (RoomDatabase.getInstance().get(room.getRoomNumber()) != null) {
                throw new Exception("Room number must be unqiue.");
            }
            
            RoomDatabase.getInstance().put(room.getRoomNumber(), room);
            
        } catch (Exception e) {
            throw e;
        }
    }
}
