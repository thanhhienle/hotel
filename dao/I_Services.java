/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities._Services;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Zo
 */
public interface I_Services {

    public ArrayList<_Services> getListThong();

    public boolean insertThong(_Services s);

    public boolean updateThong(_Services s);

    public boolean deleteThong(String sID);

    public ArrayList<_Services> getListTan();

    public boolean insertTan(_Services s);

    public boolean updateTan(_Services s);

    public boolean deleteTan(String sID);
}
