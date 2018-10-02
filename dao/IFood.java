/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Food;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Zo
 */
public interface IFood {
    public ArrayList<Food> getListThong();
    public boolean insertThong(Food f);
    public boolean updateThong(Food f);
    public boolean deleteThong(String fID);
    public ArrayList<Food> getListTan();
    public boolean insertTan(Food f);
    public boolean updateTan(Food f);
    public boolean deleteTan(String fID);
}
