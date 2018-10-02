
package entities;

public class _Role {
    private int RoleID;
    private String RoleName,RoleDesc;

    public _Role() {
    }

    public _Role(int RoleID, String RoleName, String RoleDesc) {
        this.RoleID = RoleID;
        this.RoleName = RoleName;
        this.RoleDesc = RoleDesc;
    }

    public String getRoleDesc() {
        return RoleDesc;
    }

    public int getRoleID() {
        return RoleID;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleDesc(String RoleDesc) {
        this.RoleDesc = RoleDesc;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }
    
    
}
