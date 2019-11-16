package com.cg.ibs.rm.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.ibs.rm.exception.IBSExceptions;
import com.cg.ibs.rm.service.Bank_AdminService;

@Controller

public class AdminController {

	@Autowired
	private Bank_AdminService service;
	
	@RequestMapping("/rmadmin")
	public String adminpage() {
		return "rmadmin";

	}
	
	@RequestMapping(value = "/cardRequests", method = RequestMethod.GET)
	public ModelAndView showUnapprovedRequests() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cards", service.showUnapprovedCreditCards());
		modelAndView.setViewName("cardRequests");
		return modelAndView;
	}
	
	@RequestMapping(value = "/beneficiaryRequests", method = RequestMethod.GET)
	public ModelAndView beneficiaryRequestList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("beneficiaries", service.showUnapprovedBeneficiaries());
		modelAndView.setViewName("beneficiaryRequests");
		return modelAndView;
	}


	@RequestMapping("/acceptCards")
	public ModelAndView acceptCards(@RequestParam("cardNumber") BigInteger cardNumber,
			@RequestParam("decision") String decision) {
		ModelAndView modelAndView = new ModelAndView();
		if (decision.equalsIgnoreCase("accept")) {
			try {
				service.saveCreditCardDetails(cardNumber);
			} catch (IBSExceptions e) {
				modelAndView.addObject("result", e.getMessage());
				modelAndView.setViewName("exception");
			}
		} else {
			try {
				service.disapproveCreditCard(cardNumber);
			} catch (IBSExceptions e) {
				modelAndView.addObject("result", e.getMessage());
				modelAndView.setViewName("exception");
			}
		}
		modelAndView.addObject("cards", service.showUnapprovedCreditCards());
		modelAndView.setViewName("cardRequests");
		return modelAndView;

	}
	
	@RequestMapping("/acceptBeneficiaries")
	public ModelAndView acceptBeneficiaries(@RequestParam("accountNumber") BigInteger accountNumber,
			@RequestParam("decision") String decision) {
		ModelAndView modelAndView = new ModelAndView();
		if (decision.equalsIgnoreCase("accept")) {
			try {
				service.saveBeneficiaryDetails(accountNumber);
			} catch (IBSExceptions e) {
				modelAndView.addObject("result", e.getMessage());
				modelAndView.setViewName("exception");
			}
		} else {
			try {
				service.disapproveBenficiary(accountNumber);
			} catch (IBSExceptions e) {
				modelAndView.addObject("result", e.getMessage());
				modelAndView.setViewName("exception");
			}
		}
		modelAndView.addObject("beneficiaries", service.showUnapprovedBeneficiaries());
		modelAndView.setViewName("beneficiaryRequests");
		return modelAndView;

	}

}
