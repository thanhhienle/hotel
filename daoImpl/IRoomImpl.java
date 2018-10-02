/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.IRoom;
import entities.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ICHIGEKI
 */
public class IRoomImpl implements IRoom {

    @Override
    public ArrayList<Room> getList() {
        ArrayList<Room> fList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Room");
                while (rs.next()) {
                    int ID = rs.getInt(1);
                    int rNum = rs.getInt(2);
                    int type = rs.getInt(3);
                    int status = rs.getInt(3);
                    String des = rs.getString(5);
                    fList.add(new Room(ID, rNum, type, status, des));
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
    public boolean insert(Room s) {
        Connection cn = MyLib.getCon();
        String sql = "insert Room values (?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, s.getRoomNumber());
            ps.setInt(2, s.getRoomTypeID());
            ps.setInt(3, s.getRoomStatusID());
            ps.setString(4, s.getRoomDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Room s) {
        Connection cn = MyLib.getCon();
        String sql = "update Room set RoomNumber = ?, RoomTypeID= ?, RoomStatusID = ?,RoomDesc = ? where RoomID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, s.getRoomNumber());
            ps.setInt(2, s.getRoomTypeID());
            ps.setInt(3, s.getRoomStatusID());
            ps.setString(4, s.getRoomDesc());
            ps.setInt(5, s.getRoomID());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Integer s) {
        Connection cn = MyLib.getCon();
        String sql = "delete from Payment where ReceptionID = (select ReceptionID from Reception where RoomID = ?)";
        String sql1 = "delete from Reception where RoomID = ?";
        String sql2 = "delete from Room where RoomID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, s);
            ps.executeUpdate();
            ps = cn.prepareStatement(sql1);
            ps.setInt(1, s);
            ps.executeUpdate();
            ps = cn.prepareStatement(sql2);
            ps.setInt(1, s);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Vector> listFARoom() {
        ArrayList<Vector> model= new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select RoomNumber, RoomTypeName, RoomStatusName, RoomDesc, RoomID "
                        + "from Room R join RoomType T on R.RoomTypeID = T.RoomTypeID "
                        + "join RoomStatus S on R.RoomStatusID = S.RoomStatusID");
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getInt(5));
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));
                    v.add(rs.getString(4));
                    model.add(v);
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return model;
    }

    @Override
    public ArrayList<Vector> listFSSlRoom() {
        ArrayList<Vector> model= new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select RoomNumber, RoomTypeName, RoomID from Room R join RoomType T on R.RoomTypeID = T.RoomTypeID ");
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getInt(3));
                    model.add(v);
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return model;
    }
    @Override
    public ArrayList<Room> getListThong() {
        ArrayList<Room> dList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if(cn!= null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Room");
                while(rs.next()){
                    int roomid = rs.getInt(1);
                    int roomno = rs.getInt(2);
                    
                    dList.add(new Room(roomid, roomno, roomid, roomid,null));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dList;
    }
    @Override
    public ArrayList<Room> getListTan() {
        ArrayList<Room> rList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if(cn!=null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Room");
                while(rs.next()){
                    int id = rs.getInt(1);
                    int type = rs.getInt(3);
                    int roomNo = rs.getInt(2);
                    rList.add(new Room(id, roomNo, type, type, null));
                }
                cn.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
        return rList;
    }
}
