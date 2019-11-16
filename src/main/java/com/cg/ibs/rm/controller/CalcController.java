package com.cg.ibs.rm.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.ibs.rm.service.CustomerService;


@Controller
@RequestMapping("/")
public class CalcController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping({"/","/index"})
	public String home() {
		return "index";
	}
	
	@RequestMapping("/menu")
	public String menu() {
		return "menuPage";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/additi")
	public ModelAndView sayHello() {
		return new ModelAndView("showMessage","result","Internal error! Try Later!!"); 
	}
//
//	@RequestMapping(method = RequestMethod.POST, value = "/addition")
//	public ModelAndView sum(@RequestParam("num1") int n1, @RequestParam("num2") int n2) {
//		BowBean bean = new BowBean();
//		bean.setN1(n1);
//		bean.setN2(n2);
//		int result = service.sum(bean);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("r", result);
//		modelAndView.setViewName("showMessage");
//		return modelAndView;
//	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/getname")
	public ModelAndView getName(@RequestParam("uci") BigInteger uci) {
		return new ModelAndView("showMessage", "r", customerService.returnName(uci));
	}
	

}
