/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daoImpl;
import dao.IFood;
import entities.Food;
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
public class IFoodImpl implements IFood{

    @Override
    public ArrayList<Food> getListThong() {
        ArrayList<Food> fList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if(cn!= null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Food");
                while(rs.next()){
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String des = rs.getString(4);
                    fList.add(new Food(ID, price, name, des));
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
    public boolean insertThong(Food f) {
        Connection cn = MyLib.getCon();
        String sql = "insert Food values (?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,f.getFoodName() );
            ps.setString(2, String.valueOf(f.getFoodPrice()));
            ps.setString(3,f.getFoodDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateThong(Food f) {
        Connection cn = MyLib.getCon();
        String sql = "update Food set FoodName = ?, FoodPrice = ?, FoodDesc = ? where FoodID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(4, String.valueOf(f.getFoodID()));
            ps.setString(1, f.getFoodName());
            ps.setString(2, String.valueOf(f.getFoodPrice()));
            ps.setString(3, f.getFoodDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteThong(String fID) {
        Connection cn = MyLib.getCon();
        String sql = "delete from Food where FoodID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, fID);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
@Override
    public ArrayList<Food> getListTan() {
        ArrayList<Food> fList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if(cn!= null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Food order by FoodPrice");
                while(rs.next()){
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String des = rs.getString(4);
                    fList.add(new Food(ID, price, name, des));
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
    public boolean insertTan(Food f) {
        Connection cn = MyLib.getCon();
        String sql = "insert Food values (?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,f.getFoodName() );
            ps.setString(2, String.valueOf(f.getFoodPrice()));
            ps.setString(3,f.getFoodDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTan(Food f) {
        Connection cn = MyLib.getCon();
        String sql = "update Food set FoodName = ?, FoodPrice = ?, FoodDesc = ? where FoodID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(4, String.valueOf(f.getFoodID()));
            ps.setString(1, f.getFoodName());
            ps.setString(2, String.valueOf(f.getFoodPrice()));
            ps.setString(3, f.getFoodDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteTan(String fID) {
        Connection cn = MyLib.getCon();
        String sql = "delete from Food where FoodID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, fID);
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
