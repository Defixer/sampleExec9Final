package com.jpcm.commons.impl;
import com.jpcm.commons.PersonValidation;
import com.jpcm.commons.FieldSetter;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;

public class PersonValidationImpl extends FieldSetter implements PersonValidation{
    String errorMessage;
    
    @Override
	public String checkAddPerson (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    setFields(request, response);
	    errorMessage = "";
	    if ( /*checkNameAndAddress() ||*/ checkIfNumber() || checkEMail() || checkIfValidDate() || checkIfEmpty() ) {
	        return errorMessage;
	    }
	    return "Clear";
	}
	
	@Override
	public String checkContact (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    setFieldsForContacts(request, response);
	    return "Clear";
	}
	
	@Override
	public String checkAddRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    setFieldsForRole(request, response);
	    return "Clear";
	}
	
	@Override
	public String checkSearchValue (String searchType, String searchValue) {
	    if(searchValue.equals("")) {
	        return "Empty search field";
	    }
	    if (searchType.equals("Lastname")) {
            if (!searchValue.matches("[a-z]*") && !searchValue.matches("[A-Z][a-z]*")) {
	            return "Invalid Lastname";
	        }
        }
        else if (searchType.equals("DateHired")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                sdf.parse(searchValue);
            }
            catch(Exception ex) {
                return "Invalid Date. Please follow YYYY-MM-DD format.";
            }
        }
        return "Clear";
	}
	
	@Override
	public boolean checkIfEmpty () {
	    if ( checkNull(firstName, "First Name") || checkNull(middleName, "Middle Name") || checkNull(lastName, "Last Name") || checkNull(addBarangay, "Street")
	            ||  checkNull(addBarangay, "Barangay") || checkNull(addCityMunicipality, "CityMunicipality") 
	            ||  checkNull(addZipCode, "Zip Code") || checkNull(birthday, "Birthday") 
	            || checkNull(dateHired, "Date Hired") || checkNull(addZipCode, "Zip Code") ) {
	        return true;
	    }
	    return false;
	}
	
	@Override
	public boolean checkIfNumber () {
	    if ( checkNumber(mobileNumber, "Mobile Number") || 
	            checkNumber(landLineNumber, "Landline Number") || checkNumber(addZipCode, "Zip Code") ) {
	        return true;
	    }
	    return false;
	}
	
	/*@Override
	public boolean checkNameAndAddress () {
	    if ( checkString(firstName, "First Name") || checkString(middleName, "Middle Name") || checkString(lastName, "Last Name") ||
	           checkString(addStreet, "Street") || checkString(addBarangay, "Barangay") || checkString(addCityMunicipality, "CityMunicipality")) {
	        return true;
	    }
	    return false;
	}*/
	
	@Override
	public boolean checkIfValidDate () {
	    if ( checkDate(birthday, "Birthday") || checkDate(dateHired, "Hired Date") ) {
	        return true;
	    }
	    return false;
	}
    
    @Override
	public boolean checkEMail () {
	    if ( !emailAddress.equals("") ) {
            if (!emailAddress.matches("[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,3}") && 
                    !emailAddress.matches("[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,3}")) {
                errorMessage = "Please input valid E-Mail!";
                return true;
            }
        }
	    return false;
	}
	
	@Override
    public boolean checkDate( String field, String messageSubject ) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ( !field.equals("") ) {
            try {
                sdf.parse(field);
                return false;
            }
            catch(Exception ex) {
                errorMessage = "Please input valid " + messageSubject + "!";
                return true;
            }
        }
        return false;
    }
	
	/*@Override
	public boolean checkString ( String field, String messageSubject ) {
	    if ( !field.equals("") ) {
	        if (!field.matches("[0-9][A-Z][a-z]*") && !field.matches("[0-9][A-Z][a-z]*+[ -][A-Z][a-z]*")) {
	            errorMessage = "Please input valid " + messageSubject + "!";
	            return true;
	        }
	    }
	    
	    return false;
	}*/
	
	@Override
	public boolean checkNumber (String field, String messageSubject) {
	    if ( !field.equals("") ) {
            try {
	            double num = Double.parseDouble(field);
	        }
	        catch (Exception e) {
	             errorMessage = "Please input valid " + messageSubject + "!";
	             return true;
	        }
	    }
	    return false;
	}
	
	@Override
	public boolean checkNull (String field, String messageSubject) {
	    if ( (field == null) || field.equals("") ) {
            errorMessage = "Please input " + messageSubject + " first!";
            return true;
	    }
	    return false;
	}
	
	@Override
	public boolean checkEditContact () {
	    if ( checkMobileAndLandline() || checkEMail() ) {
	        return true;
	    }
	    return false;
	}
	
	@Override
	public boolean checkMobileAndLandline() {
	    if ( !mobileNumber.equals("") ) {
            if (!StringUtils.isNumeric(mobileNumber)) {
                errorMessage = "Please input valid Mobile Number!";
                return true;
            }
        }
        if ( !landLineNumber.equals("") ) {
            if (!StringUtils.isNumeric(landLineNumber)) {
                errorMessage = "Please input valid Landline Number!";
                return true;
            }
        }
	    return false;
	}
}
