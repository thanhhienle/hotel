/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.IRoomType;
import entities.Room;
import entities.RoomType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ICHIGEKI
 */
public class IRoomTypeImpl implements IRoomType {

    @Override
    public ArrayList<RoomType> getList() {
        ArrayList<RoomType> fList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from RoomType");
                while (rs.next()) {
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    String desc = rs.getString(3);
                    int price = rs.getInt(4);
                    int numbed = rs.getInt(5);
                    fList.add(new RoomType(ID, price, numbed, name, desc));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fList;
    }
    @Override
    public ArrayList<RoomType> getListTan() {
        ArrayList<RoomType> rtList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if(cn!=null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from RoomType");
                while(rs.next()){
                    int id = rs.getInt(1);
                    int price = rs.getInt(4);
                    String type = rs.getString(2);
                    rtList.add(new RoomType(id, price, price, type, null));
                }
                cn.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rtList;
    }
}
