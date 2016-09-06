package com.jpcm.dao;
import com.jpcm.model.Role;
import java.util.Set;
import java.util.List;

public interface RoleDAO{
    public Set getRoles ();
    public void saveRole (String newRole);
    public String deleteRole (Long id);
    public List<Role> searchRoleName ();
    public List<Role> fetchRole (Long id);
}

