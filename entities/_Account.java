
package entities;

public class _Account {
    private int UserID,RoleID,EmployeeID;
    private String _Password,UserName;

    public _Account() {
    }

    public _Account(int UserID, int RoleID, int EmployeeID, String _Password, String UserName) {
        this.UserID = UserID;
        this.RoleID = RoleID;
        this.EmployeeID = EmployeeID;
        this._Password = _Password;
        this.UserName = UserName;
        
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    

    public String getPassword() {
        return _Password;
    }

    public int getRoleID() {
        return RoleID;
    }

    public int getUserID() {
        return UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setPassword(String _Password) {
        this._Password = _Password;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    
    
}
