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

public class RoleController extends MultiActionController{
    private PersonService service;
	
	public void setService (PersonService service) {
		this.service = service;
	}
	
	public void back (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("roles.htm?action=viewRoles");
    }

    public ModelAndView viewRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getRequestURI();
        String[] pathParts = pathInfo.split("/");
        Long id = Long.parseLong(pathParts[3]);
        RoleDTO roleDTO = service.fetchRole(id);
        ModelAndView model = new ModelAndView("viewRole");
        model.addObject("roleDTO", roleDTO);
        return model;
        
    }
}
