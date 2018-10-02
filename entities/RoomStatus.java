
package entities;

public class RoomStatus {
    private int RoomStatusID;
    private  String RoomStatusName,RoomStatusDesc;

    public RoomStatus() {
    }

    public RoomStatus(int RoomStatusID, String RoomStatusName, String RoomStatusDesc) {
        this.RoomStatusID = RoomStatusID;
        this.RoomStatusName = RoomStatusName;
        this.RoomStatusDesc = RoomStatusDesc;
    }

    public String getRoomStatusDesc() {
        return RoomStatusDesc;
    }

    public int getRoomStatusID() {
        return RoomStatusID;
    }

    public String getRoomStatusName() {
        return RoomStatusName;
    }

    public void setRoomStatusDesc(String RoomStatusDesc) {
        this.RoomStatusDesc = RoomStatusDesc;
    }

    public void setRoomStatusID(int RoomStatusID) {
        this.RoomStatusID = RoomStatusID;
    }

    public void setRoomStatusName(String RoomStatusName) {
        this.RoomStatusName = RoomStatusName;
    }
    
    
}
