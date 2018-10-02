/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Room;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ICHIGEKI
 */
public interface IRoom {
    public ArrayList<Room> getList();
    public boolean insert(Room s);
    public boolean update(Room s);
    public boolean delete(Integer s);
    public ArrayList<Vector> listFARoom();
    public ArrayList<Vector> listFSSlRoom();
    public ArrayList<Room> getListThong();
    public ArrayList<Room> getListTan();
}
