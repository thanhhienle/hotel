/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.ICustomer;
import entities.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ICHIGEKI
 */
public class ICustomerImpl implements ICustomer {

    @Override
    public ArrayList<Customer> getList() {
        ArrayList<Customer> cusList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Customer");
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String gID = rs.getString(3);
                    String add = rs.getString(4);
                    String phone = rs.getString(5);
                    String email = rs.getString(6);
                    String ccnum = rs.getString(8);
                    Date lastvt = rs.getDate(7);
                    Date ccExpect = rs.getDate(9);
                    cusList.add(new Customer(id, name, gID, add, phone, email, ccnum, lastvt, ccExpect));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cusList;
    }
    @Override
    public boolean insertThong(Customer c) {
        Connection cn = MyLib.getCon();        
        String sql = "insert Customer(CusName,GovernmentID,CusAddress,Phone,Email,CCNumber,CCExpiry) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, c.getCusName());
            ps.setString(2, c.getGovernmentID());
            ps.setString(3, c.getCusAddress());
            ps.setString(4, c.getPhone());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getCCNumber());
            ps.setString(7, new SimpleDateFormat("yyyy/MM/dd").format(c.getCCExpiry()));
            ps.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean insertTan(Customer c) {
        Connection cn = MyLib.getCon();
        String sql = "insert Customer(CusName,GovernmentID,CusAddress,Phone,Email,CCNumber,CCExpiry) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, c.getCusName());
            ps.setString(2, c.getGovernmentID());
            ps.setString(3, c.getCusAddress());
            ps.setString(4, c.getPhone());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getCCNumber());
            ps.setString(7, new SimpleDateFormat("yyyy/MM/dd").format(c.getCCExpiry()));
            ps.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Customer> getListTan() {
        ArrayList<Customer> cList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Customer");
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    cList.add(new Customer(id, name, name, name, name, name, name, null, null));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cList;
    }

    @Override
    public boolean deleteTan(String id) {
        Connection cn = MyLib.getCon();
        String sql = "delete from Customer where CustomerID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            cn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
