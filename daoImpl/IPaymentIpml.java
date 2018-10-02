/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daoImpl;
import dao.IPayment;
import entities.Payment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zo
 */
public class IPaymentIpml implements IPayment{

    @Override
    public ArrayList<Payment> getListTan() {
        ArrayList<Payment> pList = new ArrayList<>();
        Connection cn = MyLib.getCon();
        if(cn!=null){
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from Payment");
                while(rs.next()){
                    int id = rs.getInt(1);
                    int type = rs.getInt(2);
                    int recepid = rs.getInt(3);
                    int amount = rs.getInt(4);
                    Date date = (Date) new SimpleDateFormat("MMM/dd/yyyy").parse(rs.getString(5));
                    pList.add(new Payment(id, type, amount, recepid, date));
                }
                rs.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ParseException ex) {
                Logger.getLogger(IPaymentIpml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pList;
    }

    @Override
    public boolean insertTan(Payment p) {
        Connection cn = MyLib.getCon();
        String sql = "insert Payment values (?,?,?,default)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, p.getPaymentTypeID());
            ps.setInt(2, p.getReceptionID());
            ps.setInt(3, p.getPaymentAmount());
           // ps.setDate(4, Date.valueOf(p.getPaymentDate().toString()));
            ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
