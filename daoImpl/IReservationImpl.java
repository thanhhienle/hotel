/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.IReservation;
import entities.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author ICHIGEKI
 */
public class IReservationImpl implements IReservation{

    @Override
    public ArrayList<Reservation> getList() {
         ArrayList<Reservation> fList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Reservation where ReservationStatus = 'true'");
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int cusid= rs.getInt(2);
                    Date eCheckin = rs.getDate(3);
                    Date eChekout = rs.getDate(4);
                    String sRoom = rs.getString(5);
                    String isdeposit= rs.getString(6);
                    int roomtype = rs.getInt(7);
                    String reserStt = rs.getString(8);
                    fList.add(new Reservation(id, cusid, roomtype, sRoom, isdeposit, reserStt, eCheckin, eChekout));
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
    public ArrayList<Vector> getListTan() {
        ArrayList<Vector> list = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if(cn!=null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select c.CusName,a.ExpectedCheckinDate,a.ExpectedCheckoutDate,b.RoomTypeName,"
                        + "a.IsDeposit,a.ReservationID, c.GovernmentID from Reservation a "
                        + "join RoomType b on a.RoomTypeID = b.RoomTypeID "
                        + "join Customer c on a.CustomerID = c.CustomerID where a.ReservationStatus = 'true'");
                while(rs.next()){
                    Vector v = new Vector();
                    v.add(rs.getString(1));
                    v.add(rs.getDate(2));
                    v.add(rs.getDate(3));
                    v.add(rs.getString(4));
                    v.add(Boolean.parseBoolean(rs.getString(5)));
                    v.add(rs.getInt(6));
                    v.add(rs.getString(7));
                    list.add(v);
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public boolean insertTan(Reservation r) {
        Connection cn = MyLib.getCon();
        String sql = "insert Reservation values (?,?,?,?,?,?,'true')";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, r.getCustomerID());
            ps.setDate(2, new java.sql.Date(r.getExpectedCheckinDate().getTime()));
            ps.setDate(3, new java.sql.Date(r.getExpectedCheckoutDate().getTime()));
            ps.setString(4, r.getExpectedRoom());
            ps.setString(5, r.getIsDeposit());
            ps.setInt(6, r.getRoomTypeID());
            ps.executeUpdate();
            
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTan(Reservation r) {
        Connection cn = MyLib.getCon();
        String sql = "update Reservation set ExpectedCheckinDate = ?,ExpectedCheckoutDate = ?, ExpectedRoom = ?, IsDeposit = ? where ReservationID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(5, r.getReservationID());
            ps.setDate(1, new java.sql.Date(r.getExpectedCheckinDate().getTime()));
            ps.setDate(2, new java.sql.Date(r.getExpectedCheckoutDate().getTime()));
            ps.setString(3, r.getExpectedRoom());
            ps.setString(4, r.getIsDeposit());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteTan(int id) {
        Connection cn = MyLib.getCon();
        String sql = "delete from Reservation where ReservationID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(int a) {
        Connection cn = MyLib.getCon();
        String sql = "update Reservation set ReservationStatus = 'false' where ReservationID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, a);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
