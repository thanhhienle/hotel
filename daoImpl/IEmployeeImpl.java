package daoImpl;

import dao.IEmployee;
import entities.Employee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class IEmployeeImpl implements IEmployee {

    @Override
    public boolean insert(Employee employee) {
        Connection cn = MyLib.getCon();
        String sql = "insert Employee values (?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getPosition());
            ps.setDate(3, new Date(employee.getDOB().getTime()));
            ps.setString(4, employee.getContact());
            ps.setDate(5, new Date(employee.getJoinDate().getTime()));
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        Connection cn = MyLib.getCon();
        String sql = "update Employee set EmployeeName = ?, Position = ?, DOB = ?, Contact = ? where EmployeeID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getPosition());
            ps.setDate(3, new Date(employee.getDOB().getTime()));
            ps.setString(4, employee.getContact());
            ps.setInt(5, employee.getEmployeeID());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String employeeID) {
        Connection cn = MyLib.getCon();
        String sql = "delete _Account where UserID = (select UserID from _Account where EmployeeID = ?)";
        String sql1 = "delete from Employee where EmployeeID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, employeeID);
            ps.executeUpdate();
            ps = cn.prepareStatement(sql1);
            ps.setString(1, employeeID);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Employee> getList() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Employee order by EmployeeID desc");
                while (rs.next()) {
                    int EID = rs.getInt(1);
                    String EName = rs.getString(2);
                    String EPosition = rs.getString(3);
                    String EContact = rs.getString(5);
                    Date EDOB = rs.getDate(4);
                    Date EJDate = rs.getDate(6);
                    employeeList.add(new Employee(EID, EName, EPosition, EContact, EDOB, EJDate));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }

}
