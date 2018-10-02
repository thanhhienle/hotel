/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Drink;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Zo
 */
public interface IDrink {
    public ArrayList<Drink> getListThong();
    public boolean insertThong(Drink d);
    public boolean updateThong(Drink d);
    public boolean deleteThong(String dID);
    public ArrayList<Drink> getListTan();
    public boolean insertTan(Drink d);
    public boolean updateTan(Drink d);
    public boolean deleteTan(String dID);
}
