/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Reception;
import java.util.ArrayList;

/**
 *
 * @author ICHIGEKI
 */
public interface IReception {

    public ArrayList<Reception> getList();

    public boolean delete(int s);

    public ArrayList<Reception> getListThong();

    public boolean updateThong(Reception re);

    public ArrayList<Reception> getListTan();

    public boolean updateTan(Reception r);
    
    public boolean insert(Reception r);
    
    public boolean update(Reception r);
    
    public Boolean deleteByReser(int s);
}
