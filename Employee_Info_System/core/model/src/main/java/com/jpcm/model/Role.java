package com.jpcm.model;
import javax.persistence.*;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "ROLE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="ROLE", include="all")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq_gen")
    @SequenceGenerator(name = "role_seq_gen", sequenceName = "role_id_seq")
    @Column(name = "roleId")
    private Long roleId;
    
    @Column(name = "roleName")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
		private Set<Person> persons; 
	
    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
    
    public Set<Person> getPersons() {
        return persons;
    }

    public void setRoleName(String roleName) {
	    this.roleName = roleName;
    }
    
    public void setRoleId(Long roleId) {
	    this.roleId = roleId;
    }
    
    public void setPersons(Set<Person> persons) {
	    this.persons = persons;
    }
}
