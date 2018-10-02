
package entities;

public class RoomType {
    private int RoomTypeID,RoomPrice,NumBeds;
    private String RoomTypeName,RoomTypeDesc;

    public RoomType() {
    }

    public RoomType(int RoomTypeID, int RoomPrice, int NumBeds, String RoomTypeName, String RoomTypeDesc) {
        this.RoomTypeID = RoomTypeID;
        this.RoomPrice = RoomPrice;
        this.NumBeds = NumBeds;
        this.RoomTypeName = RoomTypeName;
        this.RoomTypeDesc = RoomTypeDesc;
    }

    public int getNumBeds() {
        return NumBeds;
    }

    public int getRoomPrice() {
        return RoomPrice;
    }

    public String getRoomTypeDesc() {
        return RoomTypeDesc;
    }

    public int getRoomTypeID() {
        return RoomTypeID;
    }

    public String getRoomTypeName() {
        return RoomTypeName;
    }

    public void setNumBeds(int NumBeds) {
        this.NumBeds = NumBeds;
    }

    public void setRoomPrice(int RoomPrice) {
        this.RoomPrice = RoomPrice;
    }

    public void setRoomTypeDesc(String RoomTypeDesc) {
        this.RoomTypeDesc = RoomTypeDesc;
    }

    public void setRoomTypeID(int RoomTypeID) {
        this.RoomTypeID = RoomTypeID;
    }

    public void setRoomTypeName(String RoomTypeName) {
        this.RoomTypeName = RoomTypeName;
    }
    
    
}
