
package entities;

import java.util.Date;
import java.util.Vector;
import sun.security.x509.AttributeNameEnumeration;

public class Customer {
    private int CustomerID;
    private String CusName,GovernmentID,CusAddress,Phone,Email,CCNumber;
    private Date LastVisited,CCExpiry;

    public Customer() {
    }

    public Customer(int CustomerID, String CusName, String GovernmentID, String CusAddress, String Phone, String Email, String CCNumber, Date LastVisited, Date CCExpiry) {
        this.CustomerID = CustomerID;
        this.CusName = CusName;
        this.GovernmentID = GovernmentID;
        this.CusAddress = CusAddress;
        this.Phone = Phone;
        this.Email = Email;
        this.CCNumber = CCNumber;
        this.LastVisited = LastVisited;
        this.CCExpiry = CCExpiry;
    }

    public Date getCCExpiry() {
        return CCExpiry;
    }

    public String getCCNumber() {
        return CCNumber;
    }

    public String getGovernmentID() {
        return GovernmentID;
    }

    public void setGovernmentID(String GovernmentID) {
        this.GovernmentID = GovernmentID;
    }

    public String getCusAddress() {
        return CusAddress;
    }

    public String getCusName() {
        return CusName;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public String getEmail() {
        return Email;
    }

    public Date getLastVisited() {
        return LastVisited;
    }

    public String getPhone() {
        return Phone;
    }

    public void setCCExpiry(Date CCExpiry) {
        this.CCExpiry = CCExpiry;
    }

    public void setCCNumber(String CCNumber) {
        this.CCNumber = CCNumber;
    }

    public void setCusAddress(String CusAddress) {
        this.CusAddress = CusAddress;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setLastVisited(Date LastVisited) {
        this.LastVisited = LastVisited;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(CusName);
        v.add(GovernmentID);
        v.add(Phone);
        v.add(CustomerID);
        return v;
    }
    
}

