package com.jpcm.commons;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;

public class FieldSetter{
    public static String id;
	public static String firstName;
	public static String middleName;
	public static String lastName;
	public static String suffixName;
	public static String titleName;
	public static String addStreet;
	public static String addBarangay;
	public static String addCityMunicipality;
	public static String addZipCode;
	public static String mobileNumber;
	public static String landLineNumber;
	public static String emailAddress;
	public static String birthday;
	public static String grade;
	public static String dateHired;
	public static String currentlyEmployed;
    public static String roleName;
    public static String[] roles;
    public static String[] mobileSet;
    public static String[] landLineSet;
    public static String[] emailSet;
    public static String newMobileNumber;
    public static String newLandLineNumber;
    public static String newEmailAddress;
    public static String newRole;
    
    public static void setFields (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
	    //id = request.getParameter("");
	    firstName = request.getParameter("firstName");
	    middleName = request.getParameter("middleName");
	    lastName = request.getParameter("lastName");
	    suffixName = request.getParameter("suffixName");
	    titleName = request.getParameter("titleName");
	    addStreet = request.getParameter("addStreet");
	    addBarangay = request.getParameter("addBarangay");
	    addCityMunicipality = request.getParameter("addCityMunicipality");
	    addZipCode = request.getParameter("addZipCode");
	    mobileNumber = request.getParameter("mobileNumber");
	    landLineNumber = request.getParameter("landLineNumber");
	    emailAddress = request.getParameter("emailAddress");
	    birthday = request.getParameter("birthday");
	    grade = request.getParameter("grade");
	    dateHired = request.getParameter("dateHired");
	    currentlyEmployed = request.getParameter("currentlyEmployed");
        roles = request.getParameterValues("role");
        mobileSet = request.getParameterValues("mobileNumber");
        landLineSet = request.getParameterValues("landLineNumber");
        emailSet = request.getParameterValues("emailAddress");
        newMobileNumber = request.getParameter("newMobileNumber");
        newLandLineNumber = request.getParameter("newLandLineNumber");
        newEmailAddress = request.getParameter("newEmailAddress");
    }
    
    public static void setFieldsForContacts (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        mobileSet = request.getParameterValues("mobileNumber");
        landLineSet = request.getParameterValues("landLineNumber");
        emailSet = request.getParameterValues("emailAddress");
        newMobileNumber = request.getParameter("newMobileNumber");
        newLandLineNumber = request.getParameter("newLandLineNumber");
        newEmailAddress = request.getParameter("newEmailAddress");
    }
    
    public static void setFieldsForRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        newRole = request.getParameter("newRole");
    }
}
