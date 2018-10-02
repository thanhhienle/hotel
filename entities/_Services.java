
package entities;

import java.util.Vector;


public class _Services {
    private int ServiceID,ServicePrice;
    private String ServiceName,ServiceDesc;

    public _Services() {
    }

    public _Services(int ServiceID, int ServicePrice, String ServiceName, String ServiceDesc) {
        this.ServiceID = ServiceID;
        this.ServiceName = ServiceName;
        this.ServicePrice = ServicePrice;
        
        this.ServiceDesc = ServiceDesc;
    }

    public String getServiceDesc() {
        return ServiceDesc;
    }

    public int getServiceID() {
        return ServiceID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public int getServicePrice() {
        return ServicePrice;
    }

    public void setServiceDesc(String ServiceDesc) {
        this.ServiceDesc = ServiceDesc;
    }

    public void setServiceID(int ServiceID) {
        this.ServiceID = ServiceID;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public void setServicePrice(int ServicePrice) {
        this.ServicePrice = ServicePrice;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(getServiceName());
        v.add(getServicePrice());
        v.add(getServiceDesc());
        v.add(getServiceID());
        return v;
    }
     
}
