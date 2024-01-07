package com.example.demo.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.SalaryModel;
import com.example.demo.service.SalaryService;


/**
 * eclipse version : 4.19.0
 * java version : 11
 * spring boot version : 2.4.10
 * mysql version: 8.0.26
 */
@Controller
public class HomeController {
	
	@Autowired
	SalaryService salaryService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView goHome(HttpServletRequest request) {	
		ModelAndView mav = new ModelAndView(); 
		List<SalaryModel> salaryList = salaryService.getSalary();
		
		mav.addObject("resultList",salaryList); 
		mav.setViewName("content/home"); 
		return mav;
	}
}
