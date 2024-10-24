package com.banky.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.banky.dto.AccountDto;
import com.banky.entities.UserAccount;
import com.banky.service.AccountOperationsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;



@Controller
public class AccountRegisterationController {
	
	@Autowired
	private AccountOperationsService accountOperationsService;
	
	@GetMapping("/register")
	public String accountCreationForm(Model model,RedirectAttributes redirectAttributes) {
		model.addAttribute("userAccReg",new UserAccount());
		redirectAttributes.addFlashAttribute("userAccReg",new UserAccount());

		return "register";
	}

		
	@PostMapping("/register")
	public ModelAndView  createNewAccount(
			ModelAndView model,
			@Valid @ModelAttribute("userAccReg") AccountDto accDto,
			BindingResult result
			) {
		
		System.out.println("-----createNewAccount ()-----");

		 if(result.hasErrors()) {

			 System.out.println("-------Validation error---------- :"+result);
			 System.out.println("result :"+result);	 
			 model.setViewName("register");
			 return model;
		 }
		
		
		try{
			System.out.println("Inside try block");
			
			accDto.setLastName("");
			accDto.setDepositAmount(0.0);
			accDto.setWithdrawAmount(0.0);
			accDto.setTransferAmount(0.0);
			
			AccountDto accDtoObject = accountOperationsService.createAccount(accDto);
			
			model.addObject("userAccReg",accDtoObject.toString());
			model.setViewName("redirect:/login");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	
		return model;
	}
}

