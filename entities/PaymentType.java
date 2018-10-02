
package entities;
public class PaymentType {
    private String PaymentType,PaymentTypeDesc;
    private int PaymentTypeID;

    public PaymentType() {
    }

    public PaymentType(String PaymentType, String PaymentTypeDesc, int PaymentTypeID) {
        this.PaymentType = PaymentType;
        this.PaymentTypeDesc = PaymentTypeDesc;
        this.PaymentTypeID = PaymentTypeID;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public String getPaymentTypeDesc() {
        return PaymentTypeDesc;
    }

    public int getPaymentTypeID() {
        return PaymentTypeID;
    }

    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }

    public void setPaymentTypeDesc(String PaymentTypeDesc) {
        this.PaymentTypeDesc = PaymentTypeDesc;
    }

    public void setPaymentTypeID(int PaymentTypeID) {
        this.PaymentTypeID = PaymentTypeID;
    }
    
}
