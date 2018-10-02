/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;
import dao.I_Role;
import entities.Employee;
import entities._Role;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Thông
 */
public class I_RoleImpl implements I_Role{

    @Override
    public ArrayList<_Role> getListThong() {
        ArrayList<_Role> roleList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM _Role");
                while (rs.next()) {
                    int rid = rs.getInt(1);
                    String rolename = rs.getString(2);
                    String roledesc = rs.getString(3);                   
                    roleList.add(new _Role(rid, rolename, roledesc));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return roleList;
    }
    
}
