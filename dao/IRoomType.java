/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.RoomType;
import java.util.ArrayList;

/**
 *
 * @author ICHIGEKI
 */
public interface IRoomType {

    public ArrayList<RoomType> getList();

    public ArrayList<RoomType> getListTan();
}
