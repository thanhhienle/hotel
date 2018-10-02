
package entities;

public class Room {
    private int RoomID,RoomNumber,RoomTypeID,RoomStatusID;
    private String RoomDesc;

    public Room() {
    }

    public Room(int RoomID, int RoomNumber, int RoomTypeID, int RoomStatusID, String RoomDesc) {
        this.RoomID = RoomID;
        this.RoomNumber = RoomNumber;
        this.RoomTypeID = RoomTypeID;
        this.RoomStatusID = RoomStatusID;
        this.RoomDesc = RoomDesc;
    }

    public String getRoomDesc() {
        return RoomDesc;
    }

    public int getRoomID() {
        return RoomID;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public int getRoomStatusID() {
        return RoomStatusID;
    }

    public int getRoomTypeID() {
        return RoomTypeID;
    }

    public void setRoomDesc(String RoomDesc) {
        this.RoomDesc = RoomDesc;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public void setRoomNumber(int RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public void setRoomStatusID(int RoomStatusID) {
        this.RoomStatusID = RoomStatusID;
    }

    public void setRoomTypeID(int RoomTypeID) {
        this.RoomTypeID = RoomTypeID;
    }
    
    
}
