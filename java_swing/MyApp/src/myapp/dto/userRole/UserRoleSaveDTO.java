/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.dto.userRole;

/**
 *
 * @author HP
 */
public class UserRoleSaveDTO {
    
    private String role_name;

    public UserRoleSaveDTO() {
    }

    public UserRoleSaveDTO(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "UserRoleSaveDTO{" + "role_name=" + role_name + '}';
    }
    
    
    
}
