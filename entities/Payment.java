package entities;

import java.util.Date;

public class Payment {
    private int PaymentID,PaymentTypeID,PaymentAmount,ReceptionID;
    private Date PaymentDate;

    public Payment() {
    }

    public Payment(int PaymentID, int PaymentTypeID, int PaymentAmount, int ReceptionID, Date PaymentDate) {
        this.PaymentID = PaymentID;
        this.PaymentTypeID = PaymentTypeID;
        this.PaymentAmount = PaymentAmount;
        this.ReceptionID = ReceptionID;
        this.PaymentDate = PaymentDate;
    }

    public int getReceptionID() {
        return ReceptionID;
    }

    public int getPaymentAmount() {
        return PaymentAmount;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public int getPaymentTypeID() {
        return PaymentTypeID;
    }

    public void setReceptionID(int ReceptionID) {
        this.ReceptionID = ReceptionID;
    }

    public void setPaymentAmount(int PaymentAmount) {
        this.PaymentAmount = PaymentAmount;
    }

    public void setPaymentDate(Date PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public void setPaymentTypeID(int PaymentTypeID) {
        this.PaymentTypeID = PaymentTypeID;
    }
}
