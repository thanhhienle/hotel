/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Customer;
import java.util.ArrayList;

/**
 *
 * @author ICHIGEKI
 */
public interface ICustomer {
    public ArrayList<Customer> getList();
    public boolean insertThong(Customer c);
    public ArrayList<Customer> getListTan();
    public boolean insertTan(Customer c);
    public boolean deleteTan(String id);
}
