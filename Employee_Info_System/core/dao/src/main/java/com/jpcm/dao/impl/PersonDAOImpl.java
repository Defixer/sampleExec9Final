package com.jpcm.dao.impl;
import com.jpcm.model.*;
import com.jpcm.dao.PersonDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.text.SimpleDateFormat;
import java.util.*;

public class PersonDAOImpl implements PersonDAO{
	private SessionFactory factory;

	public PersonDAOImpl(SessionFactory factory){
		this.factory = factory;
	}

    @Override
    public void savePerson (Person person) {
	    Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
	    try {
		    tx = session.beginTransaction();
		    session.save(person);
		    tx.commit();
	    }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace();
        }finally {
            session.close();
        }
    }
    
    @Override
    public void updatePerson (Person person) {
        Session session = factory.openSession();
        Transaction tx = null;
	    try {
		    tx = session.beginTransaction();
		    session.merge(person);
		    tx.commit();
	    }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace();
        }finally {
            session.close();
        }
    }
    
    @Override
    public void deletePerson (Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Person person = (Person) session.get(Person.class, id);
            session.delete(person);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    
    @Override
    public void deleteContact (Long id, Long deleteContact) {
        Session session = factory.openSession();
        Transaction tx = null;
	    try{
            tx = session.beginTransaction();
            Person person = (Person) session.get(Person.class, id);
            PersonContact contact = (PersonContact) person.getContacts().iterator().next();
            person.getContacts().remove(contact);
            session.delete(contact);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    
    @Override
    public List<Person> fetchPersons(String action) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Person> persons = null;
        try {
            tx = session.beginTransaction();
            if (action.equals("Lastname")){
                persons = session.createQuery("FROM Person person ORDER BY person.lastName ASC").setCacheable(true).list();
            }
            else if (action.equals("Date")){
                persons = session.createQuery("FROM Person person ORDER BY person.dateHired ASC").setCacheable(true).list();
            }
            else if (action.equals("ID")){
                persons = session.createCriteria(Person.class).setCacheable(true).list();
                
                //CHECK
                System.out.println("CHECK: Entity Fetch Count: " + session.getSessionFactory().getStatistics().getEntityFetchCount());           
                System.out.println("CHECK: Second Level Hit Count: " + session.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
            }
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        
        return persons;
    }
    
    @Override
    public List<Person> searchPersonId (Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Person> persons = session.createQuery("FROM Person person WHERE person.id ='" + id + "'").setCacheable(true).list();
        
        System.out.println("CHECK BY ID: Entity Fetch Count: " + session.getSessionFactory().getStatistics().getEntityFetchCount());           
        System.out.println("CHECK BY ID: Second Level Hit Count: " + session.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
        return persons;
    }
    
    @Override
    public List<Person> searchPerson (String searchType, String searchValue) {
        Session session = factory.openSession();
        Transaction tx = null;
        Criteria cr = session.createCriteria(Person.class);
        if (searchType.equals("Lastname")) {
            cr.add(Restrictions.ilike("lastName", searchValue));
        }
        else if (searchType.equals("DateHired")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
            Date date = null;
            try {
                date = df.parse(searchValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cr.add(Restrictions.eq("dateHired", date));
        }
        else if (searchType.equals("Role")) {
            cr = session.createCriteria(Person.class)
                .createAlias("roles", "role")
			    .add(Restrictions.eq("role.roleName", searchValue));
        }
        else if(searchType.equals("Grade")){
        		cr.add(Restrictions.ilike("grade", searchValue));
        }
        List<Person> persons = cr.list();
        return persons;
    }
}
