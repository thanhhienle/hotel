/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.I_Services;
import entities._Services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Zo
 */
public class I_ServicesImpl implements I_Services {

    @Override
    public ArrayList<_Services> getListThong() {
        ArrayList<_Services> svList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from _Services");
                while (rs.next()) {
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String des = rs.getString(4);
                    svList.add(new _Services(ID, price, name, des));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return svList;
    }

    @Override
    public boolean insertThong(_Services s) {
        Connection cn = MyLib.getCon();
        String sql = "insert _Services values (?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, s.getServiceName());
            ps.setString(2, String.valueOf(s.getServicePrice()));
            ps.setString(3, s.getServiceDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateThong(_Services s) {
        Connection cn = MyLib.getCon();
        String sql = "update _Services set ServiceName = ?, ServicePrice = ?, ServiceDesc = ? where ServiceID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(4, String.valueOf(s.getServiceID()));
            ps.setString(1, s.getServiceName());
            ps.setString(2, String.valueOf(s.getServicePrice()));
            ps.setString(3, s.getServiceDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteThong(String sID) {
        Connection cn = MyLib.getCon();
        String sql = "delete from _Services where ServiceID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, sID);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<_Services> getListTan() {
        ArrayList<_Services> svList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from _Services order by ServicePrice");
                while (rs.next()) {
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String des = rs.getString(4);
                    svList.add(new _Services(ID, price, name, des));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return svList;
    }

    @Override
    public boolean insertTan(_Services s) {
        Connection cn = MyLib.getCon();
        String sql = "insert _Services values (?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, s.getServiceName());
            ps.setString(2, String.valueOf(s.getServicePrice()));
            ps.setString(3, s.getServiceDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTan(_Services s) {
        Connection cn = MyLib.getCon();
        String sql = "update _Services set ServiceName = ?, ServicePrice = ?, ServiceDesc = ? where ServiceID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(4, String.valueOf(s.getServiceID()));
            ps.setString(1, s.getServiceName());
            ps.setString(2, String.valueOf(s.getServicePrice()));
            ps.setString(3, s.getServiceDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteTan(String sID) {
        Connection cn = MyLib.getCon();
        String sql = "delete from _Services where ServiceID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, sID);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
