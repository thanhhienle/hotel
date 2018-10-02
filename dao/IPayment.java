/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Payment;
import java.util.ArrayList;

/**
 *
 * @author Zo
 */
public interface IPayment {
    public ArrayList<Payment> getListTan();
    public boolean insertTan(Payment p);
    
}
