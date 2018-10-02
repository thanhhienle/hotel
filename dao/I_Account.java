
package dao;

import entities._Account;
import entities.Employee;
import java.util.ArrayList;
import java.util.Vector;


public interface I_Account {
    public boolean insertThong (_Account account);
    public boolean deleteThong (String accID);
    public ArrayList getInformThong();
    public ArrayList<_Account> getListThong();
    public _Account loginTan(String id, String pass);
    public boolean updateThong(_Account a);
}
