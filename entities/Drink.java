
package entities;

import java.util.Vector;


public class Drink {
    private int DrinkID,DrinkPrice;
    private String DrinkName,DrinkDesc;

    public Drink() {
    }

    public Drink(int DrinkID, int DrinkPrice, String DrinkName, String DrinkDesc) {
        this.DrinkID = DrinkID;
        this.DrinkPrice = DrinkPrice;
        this.DrinkName = DrinkName;
        this.DrinkDesc = DrinkDesc;
    }

    public String getDrinkDesc() {
        return DrinkDesc;
    }

    public int getDrinkID() {
        return DrinkID;
    }

    public String getDrinkName() {
        return DrinkName;
    }

    public int getDrinkPrice() {
        return DrinkPrice;
    }

    public void setDrinkDesc(String DrinkDesc) {
        this.DrinkDesc = DrinkDesc;
    }

    public void setDrinkID(int DrinkID) {
        this.DrinkID = DrinkID;
    }

    public void setDrinkName(String DrinkName) {
        this.DrinkName = DrinkName;
    }

    public void setDrinkPrice(int DrinkPrice) {
        this.DrinkPrice = DrinkPrice;
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(getDrinkName());
        v.add(getDrinkPrice());
        v.add(getDrinkDesc());
        v.add(getDrinkID());
        return v;
    }
}
