package com.jpcm.web;
import com.jpcm.dto.*;
import com.jpcm.service.PersonService;
import com.jpcm.commons.PersonValidation;
import com.jpcm.commons.PersonFileValidation;
import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.log4j.Logger;

public class PersonController extends MultiActionController{
    static Logger log = Logger.getLogger(PersonController.class);
    
    
    private PersonValidation validation;
    private PersonFileValidation fileValidation;
	private PersonService service;
	
	public void setService (PersonService service) {
		this.service = service;
	}
	
	public void setValidation (PersonValidation validation) {
		this.validation = validation;
	}
	
	public void setFileValidation (PersonFileValidation fileValidation) {
		this.fileValidation = fileValidation;
	}
	
	public ModelAndView home (HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	public ModelAndView view (HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<PersonDTO> personDTOs = service.getAndSortPerson("Sort by ID");
		ModelAndView model = new ModelAndView("persons");
		model.addObject("persons", personDTOs);
		return model;
	}
	
	public ModelAndView sort (HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sortType = request.getParameter("sort");
        List<PersonDTO> personDTOs = service.getAndSortPerson(sortType);
        ModelAndView model = new ModelAndView("persons");
		model.addObject("persons", personDTOs);
		return model;
    }
    
    public ModelAndView search (HttpServletRequest request, HttpServletResponse response) throws Exception {
        String searchType = request.getParameter("search");
        String searchValue = request.getParameter("searchValue");
        List<PersonDTO> personDTOs = service.getAndSortPerson("Sort by ID");
        String resultMessage = validation.checkSearchValue(searchType, searchValue);
        if (resultMessage.equals("Clear")) {
            personDTOs = service.searchPerson(searchType, searchValue);
            if (personDTOs == null) {
                resultMessage = "No record found.";
            }
            else{
                resultMessage = "Record/s Found. Showing " + personDTOs.size() + " search result/s.";
            }
        }
        ModelAndView model = new ModelAndView("persons");
        model.addObject("resultMessage", resultMessage);
	    model.addObject("persons", personDTOs);
	    return model;
    }

    public void cancel (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("person.htm?action=view");
    }
    
    public void back (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("person.htm?action=view");
    }

    public ModelAndView editPerson (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("personId"));
        List<PersonDTO> personDTOs = service.fetchPersonById(id);
        Set<RoleDTO> roleNameDTOs = service.getRoleNames();
        PersonDTO personDTO = null;
        for (PersonDTO tempPerson : personDTOs) {
            personDTO = tempPerson;
        }
		ModelAndView model = new ModelAndView("personEditor");
		model.addObject("person", personDTO);
		model.addObject("roleNames", roleNameDTOs);
		return model;
    }

    public void deletePerson (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        recordLog("Deleted 1 Person Record.\n");
        Long id = Long.parseLong(request.getParameter("personId"));
        service.deletePerson(id);
        response.sendRedirect("person.htm?action=view&OK=02");
    }

    public ModelAndView editContact (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("personId"));
        List<PersonDTO> personDTOs = service.fetchPersonById(id);
        PersonDTO personDTO = null;
        for (PersonDTO tempPerson : personDTOs) {
            personDTO = tempPerson;
        }
        ModelAndView model = new ModelAndView("contactEditor");
		model.addObject("person", personDTO);
		return model;
    }

    public ModelAndView addPersonRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("personId"));
        List<PersonDTO> personDTOs = service.fetchPersonById(id);
        Set<RoleDTO> roleNameDTOs = service.getRoleNames();
        PersonDTO personDTO = null;
        for (PersonDTO tempPerson : personDTOs) {
            personDTO = tempPerson;
        }
        ModelAndView model = new ModelAndView("addPersonRole");
		model.addObject("person", personDTO);
		model.addObject("roleNames", roleNameDTOs);
		return model;
    }

    public ModelAndView deletePersonRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("personId"));
        List<PersonDTO> personDTOs = service.fetchPersonById(id);
        Set<RoleDTO> roleNameDTOs = service.getRoleNames();
        PersonDTO personDTO = null;
        for (PersonDTO tempPerson : personDTOs) {
            personDTO = tempPerson;
        }
        ModelAndView model = new ModelAndView("deletePersonRole");
		model.addObject("person", personDTO);
		model.addObject("roleNames", roleNameDTOs);
		return model;
    }

    public void savePerson (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resultMessage = validation.checkAddPerson(request, response);
        Long id = Long.parseLong(request.getParameter("personId"));
        List<PersonDTO> personDTOs = service.fetchPersonById(id);
        Set<RoleDTO> roleNameDTOs = service.getRoleNames();
        if (resultMessage.equals("Clear")){
            recordLog("Editted 1 Person Record.\n");
            service.saveEditedPerson(personDTOs, roleNameDTOs);
            response.sendRedirect("person.htm?action=view&OK=01");
        }
        else {
            PersonDTO personDTO = null;
            for (PersonDTO tempPerson : personDTOs) {
                personDTO = tempPerson;
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/personEditor.jsp");
            request.setAttribute("person", personDTO);
            request.setAttribute("resultMessage", resultMessage);
            request.setAttribute("roleNames", roleNameDTOs);
            rd.forward(request, response);
        }
    }

    public void saveContacts (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resultMessage = validation.checkContact(request, response);
        if (resultMessage.equals("Clear")){
            recordLog("Editted Contact.\n");
            Long id = Long.parseLong(request.getParameter("personId"));
            List<PersonDTO> personDTOs = service.fetchPersonById(id);
            Set<RoleDTO> roleNameDTOs = service.getRoleNames();
            service.saveEditedContact(personDTOs, roleNameDTOs);
            response.sendRedirect("person.htm?action=view&OK=03");
        }
    }

    public void deleteContact (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        recordLog("Deleted 1 Contact.\n");
        Long personId = Long.parseLong(request.getParameter("personId"));
        Long contactId = Long.parseLong(request.getParameter("contactId"));
        service.deleteContact(personId, contactId);
        response.sendRedirect("person.htm?action=view&OK=07");
    }
    
    public ModelAndView addNewPerson (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<RoleDTO> roleNameDTOs = service.getRoleNames();
        ModelAndView model = new ModelAndView("add");
		model.addObject("roleNames", roleNameDTOs);
		return model;
    }
    
    public ModelAndView saveNewPerson (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resultMessage = validation.checkAddPerson(request, response);
        Set<RoleDTO> roleNameDTOs = service.getRoleNames();
        if (resultMessage.equals("Clear")){
            recordLog("Added new Person.\n");
            service.saveNewPerson(roleNameDTOs);
            List<PersonDTO> personDTOs = service.getAndSortPerson("Sort by ID");
            ModelAndView model = new ModelAndView("persons");
		    model.addObject("persons", personDTOs);
		    return model;
        }
        
        else {
            ModelAndView model = new ModelAndView("add");
		    model.addObject("resultMessage", resultMessage);
		    model.addObject("roleNames", roleNameDTOs);
		    return model;
        }
    }
    
    public void savePersonRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        recordLog("Added New Person Role.\n");
        String resultMessage = validation.checkAddRole(request, response);
        Long id = Long.parseLong(request.getParameter("personId"));
        service.addPersonRole(id);
        response.sendRedirect("person.htm?action=view&OK=05");
    }
    
    public void deleteSelectedPersonRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        recordLog("Deleted 1 Person Role.\n");
        String resultMessage = validation.checkAddRole(request, response);
        Long id = Long.parseLong(request.getParameter("personId"));
        service.deletePersonRole(id);
        response.sendRedirect("person.htm?action=view&OK=06");
    }
    
    public ModelAndView viewRoles (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<RoleDTO> roleNameDTOs = service.getRoleNames();
        ModelAndView model = new ModelAndView("viewRoles");
        model.addObject("roleNames", roleNameDTOs);
        return model;
    }
    
    public void deleteRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("roleId"));
        String resultMessage = service.deleteRole(id);
        if (resultMessage.equals("Clear")) {
            recordLog("Deleted 1 Role.\n");
            response.sendRedirect("roles.htm?action=viewRoles&OK=01");
        }
        else {
            response.sendRedirect("roles.htm?action=viewRoles&OK=02");
        }
    }
    
    public void addRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newRole = request.getParameter("newRole");
        String resultMessage = service.checkRole(newRole);
        RequestDispatcher rd =request.getRequestDispatcher("viewRoles.jsp");
        if (resultMessage.equals("Clear")) {
            recordLog("Added a new Role.\n");
            service.addRole(newRole);
            response.sendRedirect("roles.htm?action=viewRoles&OK=03");
        }
        else {
            response.sendRedirect("roles.htm?action=viewRoles&OK=04");
        }
    }
    
    public ModelAndView addNewPersonByFile (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return new ModelAndView("upload");
    }
    
    public ModelAndView upload (HttpServletRequest request, HttpServletResponse response, FileUpload file) throws ServletException, IOException {
		BufferedReader in = null;
		MultipartFile multipartFile = file.getFile();
		String fileName = "";
		System.out.println("multip: " + multipartFile);
		if (!multipartFile.getOriginalFilename().equals("")) {
		    System.out.println("FILENAME: " + multipartFile.getOriginalFilename());
		    recordLog("Added a new Person from Uploaded File.\n");
		    String uploadsDir = "/uploads/";
            String realPathtoUploads =  request.getServletContext().getRealPath("/newPerson.txt");
            if(! new File(realPathtoUploads).exists())
            {
                new File(realPathtoUploads).mkdir();
            }
            File dest = new File(realPathtoUploads);
            multipartFile.transferTo(dest);
            String orgName = multipartFile.getOriginalFilename();
            String filePath = request.getServletContext().getRealPath("/") + "//newPerson.txt";
            
            String resultMessage = fileValidation.checkAddPersonByFile(filePath);
            
            if (resultMessage.equals("Clear")) {
                Set<RoleDTO> roleNameDTOs = service.getRoleNames();
                service.saveNewPersonFromFile(roleNameDTOs, realPathtoUploads);
                List<PersonDTO> personDTOs = service.getAndSortPerson("Sort by ID");
                ModelAndView model = new ModelAndView("persons");
		        model.addObject("persons", personDTOs);
		        return model;
            }
            else {
                return new ModelAndView("upload").addObject("resultMessage", resultMessage);
            }
		    
	    }
	    else {
	       return new ModelAndView("upload").addObject("resultMessage", "No File Selected!");
	    }
    }
    
    public void recordLog (String logMessage) {
        logger.info("INFO:  " + logMessage);
        if(logger.isDebugEnabled()){
			logger.debug("");
		}
    }
}
