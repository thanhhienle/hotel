/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Reservation;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ICHIGEKI
 */
public interface IReservation {
    public ArrayList<Reservation> getList();
    public ArrayList<Vector> getListTan();
    public boolean insertTan(Reservation r);
    public boolean updateTan(Reservation r);
    public boolean deleteTan(int id);
    public boolean update(int a);
    
}
