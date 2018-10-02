
package entities;

import java.util.Date;


public class Reservation {
    private int ReservationID,CustomerID,RoomTypeID;
    private String ExpectedRoom,IsDeposit,ReservationStatus;
    private Date ExpectedCheckinDate,ExpectedCheckoutDate;

    public Reservation() {
        IsDeposit = "false";
    }

    public Reservation(int ReservationID, int CustomerID, int RoomTypeID, String ExpectedRoom, String IsDeposit, String ReservationStatus, Date ExpectedCheckinDate, Date ExpectedCheckoutDate) {
        this.ReservationID = ReservationID;
        this.CustomerID = CustomerID;
        this.RoomTypeID = RoomTypeID;
        this.ExpectedRoom = ExpectedRoom;
        this.IsDeposit = IsDeposit;
        this.ReservationStatus = ReservationStatus;
        this.ExpectedCheckinDate = ExpectedCheckinDate;
        this.ExpectedCheckoutDate = ExpectedCheckoutDate;
    }

    

    

    
    public String getReservationStatus(){
        return ReservationStatus;
    }


    public int getCustomerID() {
        return CustomerID;
    }

    public Date getExpectedCheckinDate() {
        return ExpectedCheckinDate;
    }

    public String getExpectedRoom() {
        return ExpectedRoom;
    }
    
    public String getIsDeposit(){
        return IsDeposit;
    }
    public int getReservationID() {
        return ReservationID;
    }

    public int getRoomTypeID() {
        return RoomTypeID;
    }

    public String setReservationStatus(String a){
        return this.ReservationStatus = a;
    }
    
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setIsDeposit(String IsDeposit){
        this.IsDeposit = IsDeposit;
    }
    public void setExpectedCheckinDate(Date ExpectedCheckinDate) {
        this.ExpectedCheckinDate = ExpectedCheckinDate;
    }

    public void setExpectedRoom(String ExpectedRoom) {
        this.ExpectedRoom = ExpectedRoom;
    }

    public void setReservationID(int ReservationID) {
        this.ReservationID = ReservationID;
    }

    public void setRoomTypeID(int RoomTypeID) {
        this.RoomTypeID = RoomTypeID;
    }

    public void setExpectedCheckoutDate(Date ExpectedCheckoutDate) {
        this.ExpectedCheckoutDate = ExpectedCheckoutDate;
    }

    public Date getExpectedCheckoutDate() {
        return ExpectedCheckoutDate;
    }
    
    
}
