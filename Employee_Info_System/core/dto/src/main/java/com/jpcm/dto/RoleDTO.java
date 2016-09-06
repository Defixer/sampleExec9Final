package com.jpcm.dto;
import java.util.Set;

public class RoleDTO {
    private Long roleId;
    private String roleName;
	private Set<PersonDTO> personDTOs; 
	
    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
    
    public Set<PersonDTO> getPersonDTOs() {
        return personDTOs;
    }

    public void setRoleName(String roleName) {
	    this.roleName = roleName;
    }
    
    public void setRoleId(Long roleId) {
	    this.roleId = roleId;
    }
    
    public void setPersonDTOs(Set<PersonDTO> personDTOs) {
	    this.personDTOs = personDTOs;
    }
}
