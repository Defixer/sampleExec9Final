package com.jpcm.commons.impl;
import com.jpcm.commons.PanelSetter;
import com.jpcm.commons.FieldSetter;
import com.jpcm.model.*;
import com.jpcm.dto.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class PanelSetterImpl extends FieldSetter implements PanelSetter{
	
	@Override
    public PersonAddressDTO setNewAddress (PersonAddressDTO addressDTO) {
        addressDTO.setAddStreet(addStreet);
        addressDTO.setAddBarangay(addBarangay);
        addressDTO.setAddCityMunicipality(addCityMunicipality);
        addressDTO.setAddZipCode(Integer.parseInt(addZipCode));
        return addressDTO;
    }
	
	@Override
    public PersonContactDTO setContactForNewPErson (PersonContactDTO contactDTOs) {
        if ( !mobileNumber.equals("") ) {
            contactDTOs.setMobileNumber( Long.parseLong(mobileNumber));
        }
        if ( !landLineNumber.equals("") ) {
            contactDTOs.setLandLineNumber( Long.parseLong(landLineNumber));
        }
        contactDTOs.setEmailAddress(emailAddress);
        return contactDTOs;
    }
    
    @Override
	public PersonDTO setNewPerson (PersonDTO personDTO, PersonAddressDTO addressDTO, 
        Set<PersonContactDTO> contactDTOs, Set<RoleDTO> roleNameDTOs){
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
        Date date = null;
        personDTO.setFirstName(firstName);
        personDTO.setMiddleName(middleName);
        personDTO.setLastName(lastName);
        personDTO.setSuffixName(suffixName);
        personDTO.setTitleName(titleName);
        personDTO.setAddressDTO(addressDTO);
        personDTO.setContactDTOs(contactDTOs);
        try {
            date = df.parse(birthday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        personDTO.setBirthday(date);
        personDTO.setGrade(grade);
        try {
            date = df.parse(dateHired);
        } catch (Exception e) {
            e.printStackTrace();
        }
        personDTO.setDateHired(date);
        if (currentlyEmployed.equals("Yes")) {
            personDTO.setCurrentlyEmployed(true);
        }
        else {
            personDTO.setCurrentlyEmployed(false);
        }
        Set<RoleDTO> newRoleDTOs = new HashSet<>();
        for (String role : roles) {
            for (RoleDTO roleNameDTO : roleNameDTOs) {
                if ( role.equals(roleNameDTO.getRoleName()) ){
                    newRoleDTOs.add(roleNameDTO);
                }
            }
        }
        personDTO.setRoleDTOs(newRoleDTOs);
        return personDTO;
    }
    
    @Override
    public PersonAddressDTO setNewAddressFromFile (PersonAddressDTO addressDTO, String filePath) {
        List<String> contents = splitFileContent(filePath);
        for (String content : contents) {
            String parts[] = content.split(": ");
            if (parts[0].equals("Street")) {
                addressDTO.setAddStreet(parts[1]);
            }
            if (parts[0].equals("Barangay")) {
                addressDTO.setAddBarangay(parts[1]);
            }
            if (parts[0].equals("CityMunicipality")) {
                addressDTO.setAddCityMunicipality(parts[1]);
            }
            if (parts[0].equals("ZipCode")) {
                addressDTO.setAddZipCode(Integer.parseInt(parts[1]));
            }
        }
        return addressDTO;
    }
	
	@Override
    public PersonContactDTO setContactForNewPErsonFromFile (PersonContactDTO contactDTOs, String filePath) {
        List<String> contents = splitFileContent(filePath);
        for (String content : contents) {
            String parts[] = content.split(": ");
            if (parts[0].equals("Mobile")) {
                if ( !parts[1].equals(" ") ) {
                    contactDTOs.setMobileNumber( Long.parseLong(parts[1]));
                }
            }
            if (parts[0].equals("Landline")) {
                if ( !parts[1].equals(" ") ) {
                    contactDTOs.setLandLineNumber( Long.parseLong(parts[1]));
                }
            }
            if (parts[0].equals("Email")) {
                if ( !parts[1].equals(" ") ) {
                    contactDTOs.setEmailAddress(parts[1]);
                }
            }
        }
        return contactDTOs;
    }
    
    @Override
    public PersonDTO setNewPersonFromFile (PersonDTO personDTO, PersonAddressDTO addressDTO, 
        Set<PersonContactDTO> contactDTOs, Set<RoleDTO> roleNameDTOs, String filePath) {
        List<String> contents = splitFileContent(filePath);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Set<RoleDTO> newRoleDTOs = new HashSet<>();
        Date date = null;
        
        personDTO.setAddressDTO(addressDTO);
        personDTO.setContactDTOs(contactDTOs);
        for (String content : contents) {
            String parts[] = content.split(": ");
            if (parts[0].equals("FirsName")) {
                personDTO.setFirstName(parts[1]);
            }
            if (parts[0].equals("MiddleName")) {
                personDTO.setMiddleName(parts[1]);
            }
            if (parts[0].equals("LastName")) {
                personDTO.setLastName(parts[1]);
            }
            if (parts[0].equals("TitleName")) {
                personDTO.setTitleName(parts[1]);
            }
            if (parts[0].equals("SuffixName")) {
                personDTO.setSuffixName(parts[1]);
            }
            if (parts[0].equals("Birthday")) {
                try {
                    date = df.parse(parts[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                personDTO.setBirthday(date);
            }
            if (parts[0].equals("Grade")) {
                personDTO.setGrade(parts[1]);
            }
            if (parts[0].equals("DateHired")) {
                try {
                    date = df.parse(parts[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                personDTO.setDateHired(date);
            }
            if (parts[0].equals("Employed")) {
                if (parts[1].equals("Yes")) {
                    personDTO.setCurrentlyEmployed(true);
                }
                else {
                    personDTO.setCurrentlyEmployed(false);
                }
            }
            if (parts[0].equals("Roles")) {
                for (RoleDTO roleNameDTO : roleNameDTOs) {
                    if (parts[1].equals(roleNameDTO.getRoleName()) ){
                        newRoleDTOs.add(roleNameDTO);
                    }
                }
            }
        }
        personDTO.setRoleDTOs(newRoleDTOs);
        return personDTO;
    }
    
    @Override
	public PersonDTO setEditedContact (PersonDTO personDTO, Set<PersonContactDTO> contactDTOs) {
        personDTO.setContactDTOs(contactDTOs);
        return personDTO;
    }
	
	@Override
	public Set<PersonContactDTO> setContactForEditPErson (Set<PersonContactDTO> contactDTOs) {
        int comparator1 = 1;
        for (PersonContactDTO contactDTO : contactDTOs) {
            int comparator2 = 1;
            for (String mobile : mobileSet) {
                if (comparator2 == comparator1) {
                    if (!mobile.equals("")) {
                        contactDTO.setMobileNumber( Long.parseLong(mobile) );
                    }
                }
                comparator2++;
            }
            comparator2 = 1;
            for (String landline : landLineSet) {
                if (comparator2 == comparator1) {
                    if (!landline.equals("")) {
                        contactDTO.setLandLineNumber( Long.parseLong(landline));
                    }
                }
                comparator2++;
            }
            comparator2 = 1;
            for (String email : emailSet) {
                if (comparator2 == comparator1) {
                    contactDTO.setEmailAddress(email);
                }
                comparator2++;
            }
            comparator1++;
        }
        if (!(newMobileNumber == null)) {
            if (!newMobileNumber.equals("") || !newLandLineNumber.equals("") || !newEmailAddress.equals("")) {
                PersonContactDTO newContactDTO = new PersonContactDTO();
                System.out.println("Long.parseLong(newMobileNumber): " + Long.parseLong(newMobileNumber));
                newContactDTO.setMobileNumber(Long.parseLong(newMobileNumber));
                newContactDTO.setLandLineNumber(Long.parseLong(newLandLineNumber));
                newContactDTO.setEmailAddress(newEmailAddress);
                contactDTOs.add(newContactDTO);
            }
        }
        return contactDTOs;
    }

    @Override
    public PersonDTO setNewPersonRole (PersonDTO personDTO, Set<RoleDTO> roleDTOs) {
        Set<RoleDTO> personRoleDTOs = personDTO.getRoleDTOs();
        for (RoleDTO roleDTO : roleDTOs) {
            if ( roleDTO.getRoleName().equals(newRole) ) {
                int counter = 0;
                for (RoleDTO personRoleDTO : personRoleDTOs) {
                    if (personRoleDTO.getRoleName().equals(newRole)) {
                        counter = 1;
                    }
                }
                if (counter == 0) {
                    personRoleDTOs.add(roleDTO);
                }
                if (personRoleDTOs.size() < 1) {
                    personRoleDTOs.add(roleDTO);
                }
            }
        }
        personDTO.setRoleDTOs(personRoleDTOs);
        return personDTO;
    }
    
    @Override
    public PersonDTO setDeletePersonRole (PersonDTO personDTO) {
        Set<RoleDTO> personRoleDTOs = personDTO.getRoleDTOs();
        Set<RoleDTO> roleDTOs = new HashSet<>();
        for (RoleDTO roleDTO : personRoleDTOs) {
            if ( !(roleDTO.getRoleName().equals(newRole)) ) {
                roleDTOs.add(roleDTO);
            }
        }
        personDTO.setRoleDTOs(roleDTOs);
        return personDTO;
    }
    
    @Override
    public List<String> splitFileContent (String filePath) {
        BufferedReader in = null;
        List<String> contents = new ArrayList<String>();
        try {
            in = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = in.readLine()) != null) {
                contents.add(line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException e) {
            }
        }
        return contents;
    }
}

