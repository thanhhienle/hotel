
package entities;

import java.util.Date;
import java.util.Vector;


public class Reception {
    private int ReceptionID,CusGroupID,ReservationID,RoomID;
    private Date CheckinDate,ExpectedCheckoutDate,CheckoutDate;
    private String _Services,Foods,Drinks,ReceptionStatus,Customer;

    public Reception() {
        ReservationID = 1;
    }

    public Reception(int ReceptionID, int CusGroupID, int ReservationID, int RoomID, Date CheckinDate, Date ExpectedCheckoutDate, Date CheckoutDate, String _Services, String Foods, String Drinks, String ReceptionStatus, String Customer) {
        this.ReceptionID = ReceptionID;
        this.CusGroupID = CusGroupID;
        this.ReservationID = ReservationID;
        this.RoomID = RoomID;
        this.CheckinDate = CheckinDate;
        this.ExpectedCheckoutDate = ExpectedCheckoutDate;
        this.CheckoutDate = CheckoutDate;
        this._Services = _Services;
        this.Foods = Foods;
        this.Drinks = Drinks;
        this.ReceptionStatus = ReceptionStatus;
        this.Customer = Customer;
    }

    

    

    public Date getCheckinDate() {
        return CheckinDate;
    }

    public Date getCheckoutDate() {
        return CheckoutDate;
    }

    public int getCusGroupID() {
        return CusGroupID;
    }

    public String getDrinks() {
        return Drinks;
    }

    public Date getExpectedCheckoutDate() {
        return ExpectedCheckoutDate;
    }
    public String getCustomer(){
        return Customer;
    }
    public String getFoods() {
        return Foods;
    }


    public int getReservationID() {
        return ReservationID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public int getReceptionID() {
        return ReceptionID;
    }

    public String getReceptionStatus() {
        return ReceptionStatus;
    }

    public String getServices() {
        return _Services;
    }

    public void setCheckinDate(Date CheckinDate) {
        this.CheckinDate = CheckinDate;
    }

    public void setCheckoutDate(Date CheckoutDate) {
        this.CheckoutDate = CheckoutDate;
    }

    public void setCusGroupID(int CusGroupID) {
        this.CusGroupID = CusGroupID;
    }
    public void setCustomer(String Customer){
        this.Customer = Customer;
    }
    public void setDrinks(String Drinks) {
        this.Drinks = Drinks;
    }

    public void setExpectedCheckoutDate(Date ExpectedCheckoutDate) {
        this.ExpectedCheckoutDate = ExpectedCheckoutDate;
    }

    public void setFoods(String Foods) {
        this.Foods = Foods;
    }


    public void setReservationID(int ReservationID) {
        this.ReservationID = ReservationID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public void setReceptionID(int ReceptionID) {
        this.ReceptionID = ReceptionID;
    }

    public void setReceptionStatus(String ReceptionStatus) {
        this.ReceptionStatus = ReceptionStatus;
    }

    public void setServices(String _Services) {
        this._Services = _Services;
    }
    
    public Vector toVector(){
        Vector v =  new Vector();
        v.add(getRoomID());
        v.add(getServices());
        v.add(getFoods());
        v.add(getDrinks());
        return v;
    }
}
