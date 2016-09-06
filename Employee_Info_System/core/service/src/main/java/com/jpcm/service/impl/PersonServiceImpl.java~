package com.jpcm.service.impl;
import com.jpcm.model.*;
import com.jpcm.dto.*;
import com.jpcm.dao.*;
import com.jpcm.service.PersonService;
import com.jpcm.commons.PanelSetter;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;
import org.apache.commons.beanutils.BeanUtils;

public class PersonServiceImpl implements PersonService {
	private PersonDAO personDAO;
	private RoleDAO roleDAO;
	private PanelSetter setter;
	
	public void setPersonDAO (PersonDAO personDAO) {
	    this.personDAO = personDAO;
	}
	
	public void setRoleDAO (RoleDAO roleDAO) {
	    this.roleDAO = roleDAO;
	}
	
	public void setSetter (PanelSetter setter) {
	    this.setter = setter;
	}
	
	@Override
	public List<PersonDTO> getAndSortPerson (String action) {
	    List<Person> persons = null;
	    if (action.equals("Grade")) {
            persons = personDAO.fetchPersons("ID");
            Collections.sort(persons);
        }
        else if (action.equals("Date Hired")) {
            persons = personDAO.fetchPersons("Date");
        }
        else if (action.equals("Lastname")) {
            persons = personDAO.fetchPersons("Lastname");
        }
        else if (action.equals("Sort by ID")) {
            persons = personDAO.fetchPersons("ID");
        }
        return toPersonDTOs(persons);
	} 
	
	@Override
	public List<PersonDTO> searchPerson (String searchType, String searchValue) {
	    List<Person> persons = personDAO.searchPerson(searchType, searchValue);
        return toPersonDTOs(persons);
	} 
	
	@Override
	public void saveNewPerson (Set<RoleDTO> roleNameDTOs) {
	    PersonAddressDTO addressDTO = setter.setNewAddress(new PersonAddressDTO());
        PersonContactDTO contactDTO = setter.setContactForNewPErson(new PersonContactDTO());
        Set<PersonContactDTO> contactDTOs = new HashSet<>();
        contactDTOs.add(contactDTO);
        PersonDTO personDTO = setter.setNewPerson(new PersonDTO(), addressDTO, contactDTOs, roleNameDTOs);
        personDAO.savePerson(toPersonModel(personDTO));
	}
	
	@Override
	public Set<RoleDTO> getRoleNames() {
	    Set<Role> roleNames = roleDAO.getRoles();
        return toRoleDTOs(roleNames);
	}
	
	@Override
	public void saveNewPersonFromFile (Set<RoleDTO> roleNameDTOs, String filePath) {
	    PersonAddressDTO addressDTO = setter.setNewAddressFromFile(new PersonAddressDTO(), filePath);
        PersonContactDTO contactDTO = setter.setContactForNewPErsonFromFile(new PersonContactDTO(), filePath);
        Set<PersonContactDTO> contactDTOs = new HashSet<>();
        contactDTOs.add(contactDTO);
        PersonDTO personDTO = setter.setNewPersonFromFile(new PersonDTO(), addressDTO, contactDTOs, roleNameDTOs, filePath);
        personDAO.savePerson(toPersonModel(personDTO));
	}
	
	/*@Override
	public boolean checkPersonById(Long id) {
	    List<Person> persons = personDAO.searchPersonId(id);
	    int checker = 0;
        for (Person person : persons) {
            if (id == person.getId() ) {
                checker++;
            }
        }
        if (checker > 0) {
            return false;
        }
        return true;
	}*/
	
	@Override
	public List<PersonDTO> fetchPersonById(Long id) {
	    List<Person> persons = personDAO.searchPersonId(id);
        return toPersonDTOs(persons);
	}
	
	@Override
	public void deletePerson(Long id) {
	    personDAO.deletePerson(id);
	}
	
	@Override
	public void saveEditedPerson(List<PersonDTO> personDTOs, Set<RoleDTO> roleNameDTOs) {
	    Set<PersonContactDTO> contactDTOs = new HashSet<>();
        PersonAddressDTO addressDTO = new PersonAddressDTO();
	    for (PersonDTO personDTO : personDTOs) {
            addressDTO = setter.setNewAddress(personDTO.getAddressDTO());
            contactDTOs = setter.setContactForEditPErson(personDTO.getContactDTOs());
            personDTO = setter.setNewPerson(personDTO, addressDTO, contactDTOs, roleNameDTOs);
            personDAO.updatePerson(toPersonModel(personDTO));
        }
	}
	
	@Override
	public void saveEditedContact(List<PersonDTO> personDTOs, Set<RoleDTO> roleNameDTOs) {
	    Set<PersonContactDTO> contactDTOs = new HashSet<>();
        PersonAddressDTO addressDTO = new PersonAddressDTO();
	    for (PersonDTO personDTO : personDTOs) {
            contactDTOs = setter.setContactForEditPErson(personDTO.getContactDTOs());
        	personDTO = setter.setEditedContact(personDTO, contactDTOs);
            personDAO.updatePerson(toPersonModel(personDTO));
        }
	}
	
	@Override
	public void deleteContact(Long id, Long deleteContact) {
        personDAO.deleteContact(id, deleteContact);
	}
	
	@Override
	public void addPersonRole(Long id) {
	    Set<RoleDTO> roleDTOs = toRoleDTOs(roleDAO.getRoles());
	    List<PersonDTO> personDTOs = fetchPersonById(id);
        for (PersonDTO personDTO : personDTOs) {
            personDTO = setter.setNewPersonRole(personDTO, roleDTOs);
            personDAO.updatePerson(toPersonModel(personDTO));
        }
	}
	
	@Override
	public void deletePersonRole(Long id) {
	    Set<RoleDTO> roleDTOs = toRoleDTOs(roleDAO.getRoles());
	    List<PersonDTO> personDTOs = fetchPersonById(id);
        for (PersonDTO personDTO : personDTOs) {
            personDTO = setter.setNewPersonRole(personDTO, roleDTOs);
            personDAO.updatePerson(toPersonModel(personDTO));
        }
	}
	
	@Override
	public Set<Role> fetchRoles() {
	    Set<Role> roleNames = roleDAO.getRoles();
	    return roleNames;
	}
	
	@Override
	public String checkRole(String newRole) {
	    List<Role> roles = roleDAO.searchRoleName();
	    int checker = 0;
	    if (newRole.equals("") || newRole.matches(".*\\d.*")) {
	        return "Please input valid Role!";
	    }
	    
        for (Role role : roles) {
            if ( newRole.equals(role.getRoleName()) ) {
                checker++;
            }
        }
        if (checker > 0) {
            return "Role already exists!";
        }
        return "Clear";
	}
	
	@Override
	public void addRole(String newRole) {
	    roleDAO.saveRole(newRole);
	}   
	
	@Override
	public String deleteRole(Long id) {
	    String resultMessage = roleDAO.deleteRole(id);
	    return resultMessage;
	}
	
	public RoleDTO fetchRole (Long id) {
	    List<Role> roles = roleDAO.fetchRole(id);
	    Role role = null;
	    for (Role tempRole : roles) {
	        role = tempRole;
	    }
        return toRoleDTO(role);
	}
	
	
	//CONVERSIONS
	
	
	public PersonDTO toPersonDTO (Person person) {
	    PersonDTO personDTO = new PersonDTO();
		PersonAddressDTO addressDTO = new PersonAddressDTO();
		Set<PersonContactDTO> contactDTOs = new HashSet<>();
		Set<RoleDTO> roleDTOs = new HashSet<>();
		
		try{
			BeanUtils.copyProperties(personDTO,person);
			BeanUtils.copyProperties(addressDTO,person.getAddress());
			for (PersonContact contact : person.getContacts()){
				PersonContactDTO contactDTO = new PersonContactDTO();
				BeanUtils.copyProperties(contactDTO, contact);
				contactDTOs.add(contactDTO);
			}
			
			for(Role role : person.getRoles()){
				RoleDTO roleDTO = new RoleDTO();
				BeanUtils.copyProperties(roleDTO, role);
				roleDTOs.add(roleDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		personDTO.setAddressDTO(addressDTO);
		personDTO.setContactDTOs(contactDTOs);
		personDTO.setRoleDTOs(roleDTOs);
		return personDTO;
	}
	
	public List<PersonDTO> toPersonDTOs (List<Person> persons) {
	    List<PersonDTO> personDTOs = new ArrayList<>();
		for (Person person : persons){
			personDTOs.add(toPersonDTO(person));	
		}
		return personDTOs;
	}
	
	public RoleDTO toRoleDTO (Role roleName) {
    RoleDTO roleDTO = new RoleDTO();
		roleDTO.setRoleId(roleName.getRoleId());
		roleDTO.setRoleName(roleName.getRoleName());
		
		Set<PersonDTO> personDTOs = new HashSet();
		
		Set<Person> persons = roleName.getPersons();
		for(Iterator personsIterator = persons.iterator(); personsIterator.hasNext();){
			Person person = (Person)personsIterator.next();
			PersonDTO personDTO = new PersonDTO();
		
			personDTO = toPersonDTO(person);
			personDTOs.add(personDTO);			
		}
		
		roleDTO.setPersonDTOs(personDTOs);
		
		
		
		return roleDTO;
	}
	
	public Set<RoleDTO> toRoleDTOs (Set<Role> roleNames) {
	    Set<RoleDTO> roleDTOs = new HashSet<>();
		for (Role role : roleNames){
			roleDTOs.add(toRoleDTO(role));
		}
		return roleDTOs;
	}
	
	public Person toPersonModel (PersonDTO personDTO) {
	    Person person = new Person();
		PersonAddress address = new PersonAddress();
		Set<PersonContact> contacts = new HashSet<>();
		Set<Role> roles = new HashSet<>();
		try{
			BeanUtils.copyProperties(person, personDTO);
			BeanUtils.copyProperties(address, personDTO.getAddressDTO());
			for (PersonContactDTO contactDTO : personDTO.getContactDTOs()) {
				PersonContact contact = new PersonContact();
				BeanUtils.copyProperties(contact, contactDTO);
				contacts.add(contact);
			}
			for(RoleDTO roleDTO : personDTO.getRoleDTOs()) {
				Role role = new Role();
				BeanUtils.copyProperties(role, roleDTO);
				roles.add(role);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		person.setAddress(address);
		person.setContacts(contacts);
		person.setRoles(roles);
		return person;	
	}
	
	public List<Person> toPersonModels (List<PersonDTO> personDTOs) {
	    List<Person> persons = new ArrayList<>();
		for (PersonDTO personDTO : personDTOs){
			persons.add(toPersonModel(personDTO));	
		}
		return persons;
	}
}
