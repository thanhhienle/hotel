/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.IReception;
import entities.Reception;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ICHIGEKI
 */
public class IReceptionImpl implements IReception {

    @Override
    public ArrayList<Reception> getList() {
        ArrayList<Reception> fList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Reception where ReceptionStatus = 'true'");
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int deputy = rs.getInt(2);
                    String cus = rs.getString(3);
                    int reserID = rs.getInt(4);
                    int roomID = rs.getInt(5);
                    Date checkin = rs.getDate(6);
                    Date eCheckout = rs.getDate(7);
                    Date checkout = rs.getDate(8);
                    String service = rs.getString(9);
                    String food = rs.getString(10);
                    String drink = rs.getString(11);
                    String rcStt = rs.getString(12);
                    fList.add(new Reception(id, deputy, reserID, roomID, checkin, eCheckout, checkout, service, food, drink, rcStt, cus));
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
    public boolean delete(int s) {
        Connection cn = MyLib.getCon();
        String sql = "delete from Payment where ReceptionID = (select ReceptionID from Reception where RoomID = ?)";
        String sql1 = "delete from Reception where ReceptionID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, s);
            ps.executeUpdate();
            ps = cn.prepareStatement(sql1);
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
    public ArrayList<Reception> getListThong() {
        ArrayList<Reception> rList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Reception where ReceptionStatus = 'true'");
                while (rs.next()) {
                    int reid = rs.getInt(1);
                    int roomid = rs.getInt(5);
                    String services = rs.getString(9);
                    String foods = rs.getString(10);
                    String drinks = rs.getString(11);
                    rList.add(new Reception(reid, reid, reid, roomid, null, null, null, services, foods, drinks, null, null));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rList;
    }

    @Override
    public boolean updateThong(Reception re) {
        Connection cn = MyLib.getCon();
        String sql = "update Reception set _Services = ?, Foods = ?, Drinks = ? where RoomID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(4, String.valueOf(re.getRoomID()));
            ps.setString(1, re.getServices());
            ps.setString(2, re.getFoods());
            ps.setString(3, re.getDrinks());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Reception> getListTan() {
        ArrayList<Reception> rList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Reception where ReceptionStatus = 'true'");
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int room = rs.getInt(5);
                    int deputy = rs.getInt(2);
                    String cus = rs.getString(3);
                    String service = rs.getString(9);
                    String food = rs.getString(10);
                    String drink = rs.getString(11);
                    Date checkin = rs.getDate(6);
                    Date checkout = rs.getDate(8);
                    rList.add(new Reception(id, deputy, deputy, room, checkin, checkout, checkout, service, food, drink, cus, cus));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rList;
    }

    @Override
    public boolean updateTan(Reception r) {
        Connection cn = MyLib.getCon();
        String sql = "update Reception set ReceptionStatus ='false', CheckinDate = ? where CusGroupID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(2, String.valueOf(r.getCusGroupID()));
            ps.setDate(1, new java.sql.Date(new Date().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean insert(Reception r) {
        Connection cn = MyLib.getCon();
        String sql = "insert into Reception (CusGroupID,Customer,ReservationID,RoomID,CheckinDate,ExpectedCheckoutDate,ReceptionStatus) values(?,?,?,?,default,?,'true')";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, r.getCusGroupID());
            ps.setString(2, r.getCustomer());
            ps.setInt(3, r.getReservationID());
            ps.setInt(4, r.getRoomID());
            ps.setDate(5, new java.sql.Date(r.getExpectedCheckoutDate().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Reception r) {
        Connection cn = MyLib.getCon();
        String sql = "update Reception set Customer= ? ,RoomID = ?,ExpectedCheckoutDate = ? where ReceptionID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, r.getCustomer());
            ps.setInt(2, r.getRoomID());
            ps.setDate(3, new java.sql.Date(r.getExpectedCheckoutDate().getTime()));
            ps.setInt(4, r.getReceptionID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteByReser(int s) {
        Connection cn = MyLib.getCon();
        String sql1 = "delete from Reception where ReservationID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql1);
            ps.setInt(1, s);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
