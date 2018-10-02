
package entities;

import java.util.Vector;


public class Food {
    private int FoodID,FoodPrice;
    private String FoodName,FoodDesc;

    public Food() {
    }

    public Food(int FoodID, int FoodPrice, String FoodName, String FoodDesc) {
        this.FoodID = FoodID;
        this.FoodPrice = FoodPrice;
        this.FoodName = FoodName;
        this.FoodDesc = FoodDesc;
    }

    public String getFoodDesc() {
        return FoodDesc;
    }

    public int getFoodID() {
        return FoodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public int getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodDesc(String FoodDesc) {
        this.FoodDesc = FoodDesc;
    }

    public void setFoodID(int FoodID) {
        this.FoodID = FoodID;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public void setFoodPrice(int FoodPrice) {
        this.FoodPrice = FoodPrice;
    }
     public Vector toVector(){
        Vector v = new Vector();
        v.add(getFoodName());
        v.add(getFoodPrice());
        v.add(getFoodDesc());
        v.add(getFoodID());
        return v;
    }
}
