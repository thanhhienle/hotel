package daoImpl;

import dao.I_Account;
import entities._Account;
import gui.changeConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class I_AccountImpl implements I_Account {

    changeConnect c = new changeConnect();;
    @Override
    public boolean insertThong(_Account account) {
        Connection cn = MyLib.getCon();
        String sql = "insert _Account values (?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, account.getEmployeeID());
            ps.setString(2, account.getUserName());
            ps.setString(3, account.getPassword());
            ps.setInt(4, account.getRoleID());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteThong(String username) {
        Connection cn = MyLib.getCon();
        String sql = "delete from _Account where UserName = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Vector> getInformThong() {
        ArrayList<Vector> model = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT  a.EmployeeID, EmployeeName, UserName, RoleName FROM _Account a JOIN Employee b ON a.EmployeeID = b.EmployeeID JOIN _Role r ON a.RoleID = r.RoleID order by UserID desc");
                while (rs.next()) {
                    Vector v = new Vector<>();
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
    public ArrayList<_Account> getListThong() {
        ArrayList<_Account> dList = new ArrayList<>();
        Connection cn = daoImpl.MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from _Account");
                while (rs.next()) {
                    int ID = rs.getInt(1);
                    int emID = rs.getInt(2);
                    String username = rs.getString(3);
                    String pass = rs.getString(4);
                    int roleID = rs.getInt(5);
                    dList.add(new _Account(ID, roleID, emID, pass, username));
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
    public _Account loginTan(String id, String pass) {
        Connection cn = MyLib.getCon();
        if (cn == null&& !c.isVisible()) {
            c.setLocationRelativeTo(null);
            c.setVisible(true);
        }
        _Account a;
        try {
            PreparedStatement ps = cn.prepareStatement("select * from _Account where UserName =? and _Password = ?");
            ps.setString(1, id);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt(1);
                int empID = rs.getInt(2);
                String username = rs.getString(3);
                String password = rs.getString(4);
                int roleID = rs.getInt(5);
                a = new _Account(userID, roleID, empID, password, username);
            } else {
                return null;
            }
            rs.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return a;
    }

    @Override
    public boolean updateThong(_Account a) {
        Connection cn = MyLib.getCon();
        String sql = "update _Account set _Password = ? where UserName = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(2, a.getUserName());
            ps.setString(1, a.getPassword());

            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
