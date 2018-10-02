/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;
import java.util.Vector;
/**
 *
 * @author User
 */
public class Employee {
    private int EmployeeID;
    private String EmployeeName, Position, Contact;
    private Date DOB, JoinDate;
    
    public Employee() {
    }

    public Employee(int EmployeeID, String EmployeeName, String Position, String Contact, Date DOB, Date JoinDate) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
        this.Position = Position;
        this.Contact = Contact;
        this.DOB = DOB;
        this.JoinDate = JoinDate;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Date getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(Date JoinDate) {
        this.JoinDate = JoinDate;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(getEmployeeID());
        v.add(getEmployeeName());
        v.add(getDOB());
        v.add(getPosition());
        v.add(getContact());

        return v;

    }
}



