/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daoImpl;
import dao.IDrink;
import entities.Drink;
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
public class IDrinkImpl implements IDrink{

    @Override
    public ArrayList<Drink> getListThong() {
        ArrayList<Drink> dList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if(cn!= null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Drink");
                while(rs.next()){
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String des = rs.getString(4);
                    dList.add(new Drink(ID, price, name, des));
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
    public boolean insertThong(Drink f) {
        Connection cn = MyLib.getCon();
        String sql = "insert Drink values (?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,f.getDrinkName() );
            ps.setString(2, String.valueOf(f.getDrinkPrice()));
            ps.setString(3,f.getDrinkDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateThong(Drink f) {
        Connection cn = MyLib.getCon();
        String sql = "update Drink set DrinkName = ?, DrinkPrice = ?, DrinkDesc = ? where DrinkID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(4, String.valueOf(f.getDrinkID()));
            ps.setString(1, f.getDrinkName());
            ps.setString(2, String.valueOf(f.getDrinkPrice()));
            ps.setString(3, f.getDrinkDesc());
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
        String sql = "delete from Drink where DrinkID = ?";
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
    public ArrayList<Drink> getListTan() {
        ArrayList<Drink> dList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if(cn!= null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Drink order by DrinkPrice");
                while(rs.next()){
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String des = rs.getString(4);
                    dList.add(new Drink(ID, price, name, des));
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
    public boolean insertTan(Drink f) {
        Connection cn = MyLib.getCon();
        String sql = "insert Drink values (?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,f.getDrinkName() );
            ps.setString(2, String.valueOf(f.getDrinkPrice()));
            ps.setString(3,f.getDrinkDesc());
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTan(Drink f) {
        Connection cn = MyLib.getCon();
        String sql = "update Drink set DrinkName = ?, DrinkPrice = ?, DrinkDesc = ? where DrinkID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(4, String.valueOf(f.getDrinkID()));
            ps.setString(1, f.getDrinkName());
            ps.setString(2, String.valueOf(f.getDrinkPrice()));
            ps.setString(3, f.getDrinkDesc());
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
        String sql = "delete from Drink where DrinkID = ?";
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
