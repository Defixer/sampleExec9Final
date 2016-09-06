package com.jpcm.dao.impl;
import com.jpcm.model.*;
import com.jpcm.dao.RoleDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import javax.swing.*;
import java.util.*;

public class RoleDAOImpl implements RoleDAO{
  private SessionFactory factory;
  private Role role;

	public RoleDAOImpl(SessionFactory factory){
		this.factory = factory;
	}
    
    @Override
    public Set getRoles () {
        Set<Role> roleNames = new HashSet<>();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List roles = session.createQuery("From Role").setCacheable(true).list();
            for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
                Role role = (Role) iterator.next();
                roleNames.add(role);
            }
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return roleNames;
    }
    
    @Override
    public void saveRole (String newRole) {
        Session session = factory.openSession();
        Transaction tx = null;
        Role role = null;
	    try {
		    tx = session.beginTransaction();
		    role = new Role();
	        role.setRoleName(newRole);
		    session.save(role);
		    tx.commit();
	    }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace();
        }finally {
            session.close();
        }
    }
    
    @Override
    public String deleteRole (Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        String resultMessage = "";
	    try{
            tx = session.beginTransaction();
            role = (Role) session.get(Role.class, id);
            session.delete(role);
            tx.commit();
            resultMessage = "Clear";
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            resultMessage = "Cannot delete " + role.getRoleName() + " role. Selected role is currently assigned to Person/s";
        }finally {
            session.close();
        }
        return resultMessage;
    }
    
    @Override
    public List<Role> searchRoleName () {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Role> roles = null;
        try {
		    tx = session.beginTransaction();
		    roles = session.createQuery("FROM Role").list();
		    tx.commit();
	    }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace();
        }finally {
            session.close();
        }
        return roles;
    }
    
    @Override
    public List<Role> fetchRole (Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Role> roles = session.createQuery("FROM Role role WHERE role.roleId ='" + id + "'").list();
        return roles;
    }
}

