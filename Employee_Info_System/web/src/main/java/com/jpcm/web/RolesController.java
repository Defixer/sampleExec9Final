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

public class RolesController extends MultiActionController {
    private PersonValidation validation;
	private PersonService service;
	
	public void setService (PersonService service) {
		this.service = service;
	}
	
	public void setValidation (PersonValidation validation) {
		this.validation = validation;
	}

    public ModelAndView viewRoles (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<RoleDTO> roleNameDTOs = service.getRoleNames();
        ModelAndView model = new ModelAndView("viewRoles");
        model.addObject("roleNames", roleNameDTOs);
        return model;
    }
    
    public void back (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("roles.htm?action=viewRoles");
    }
    
    public void deleteRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("roleId"));
        String resultMessage = service.deleteRole(id);
        if (resultMessage.equals("Clear")) {
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
            service.addRole(newRole);
            response.sendRedirect("roles.htm?action=viewRoles&OK=03");
        }
        else {
            response.sendRedirect("roles.htm?action=viewRoles&OK=04");
        }
    }
}
