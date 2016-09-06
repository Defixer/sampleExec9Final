package com.jpcm.commons;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;

public interface PersonValidation {
	public String checkAddPerson (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public String checkContact (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public String checkAddRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public String checkSearchValue (String searchType, String searchValue);
	public boolean checkIfEmpty ();
	public boolean checkIfNumber ();
	//public boolean checkNameAndAddress ();
	public boolean checkIfValidDate ();
	public boolean checkEMail ();
  public boolean checkDate( String field, String messageSubject );
	//public boolean checkString ( String field, String messageSubject );
	public boolean checkNumber (String field, String messageSubject);
	public boolean checkNull (String field, String messageSubject);
	public boolean checkEditContact ();
	public boolean checkMobileAndLandline();
}
