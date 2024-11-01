package com.banky.controllers;

import com.banky.dto.LoginDto;
import com.banky.entities.UserAccount;
import com.banky.service.AccountOperationsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountLoginController {
  
  @Autowired
  private AccountOperationsService accountOperationsService;

  
  @GetMapping("/login")
  public String accountLoginForm(Model model, HttpServletRequest request) {
	 
	  System.out.println("-------- accountLoginForm()--------");
	  model.addAttribute("login",new UserAccount());
	  request.getSession().setAttribute("login", request);
	  return "login";
  }
  
  @PostMapping("/logout")
  public ModelAndView logout(@Valid HttpSession session, ModelAndView modelAndView) {
	  
	  LoginDto ldto = (LoginDto)session.getAttribute("login");
	  System.out.println(ldto.getEmail());
	  session.invalidate();
	  
	  return modelAndView;
	}

  


  @PostMapping("/login/userDashBoard")
  public ModelAndView loggedIn(
		  @Valid @ModelAttribute("login") LoginDto loginDto,
		  BindingResult result,
		  HttpServletRequest request,
		  ModelAndView modelAndView) {
	  
	  System.out.println("-----loggedIn ()-----");

	  if(result.hasErrors()) {
	
		  System.out.println("-------Validation error---------- :"+result);
		  System.out.println("result :"+result);
		  System.out.println(loginDto.toString());
			 
		  modelAndView.setViewName("login");

		  return modelAndView;
	 }
	 
	  LoginDto account = accountOperationsService.loginByEmailAndPassword
			  (
					  loginDto.getEmail(),
					  loginDto.getPassword()
			  );
	  System.out.println(account.toString());
	  System.out.println(" Account Id: "+account.getAccountId());
	  
	  //adding object to session
	  request.getSession().setAttribute("login", account);

	  modelAndView.addObject("login",account);
	  modelAndView.setViewName("userDashBoard");
	  return modelAndView;
  }
  
  
}
