package jms.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jms.domain.ConfirmEmailForResetPassword;
import jms.domain.LoginRequest;
import jms.domain.ResetPassword;
import jms.domain.UserRegistrationRequest;
import jms.entity.UserEntity;
import jms.mapper.UserMapper;
import jms.securty.mail.Mail;
import jms.service.EmailService;
import jms.service.UserEntityService;
import jms.utils.RandomToken;
import jms.validator.anotation.CheckEmail;




@Controller
public class BaseController {
@Autowired private UserEntityService userEntityService;
	@Autowired EmailService emailService;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@GetMapping({"/", "/home"})
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/registration")
	public String showPageRegistration(Model model) {
		model.addAttribute("registerModel", new UserRegistrationRequest());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String createCustomer(Model model, 
			@ModelAttribute("registerModel") @Valid UserRegistrationRequest userRegistrationRequest,
			BindingResult result) {
		if(result.hasErrors()) {
			return "registration";
			}
	
		
		UserEntity user = UserMapper.registerToUser(userRegistrationRequest);
		
		String token = RandomToken.generateRandomString();
		user.setToken(token);
		user.setActivated(false);
		userEntityService.saveUserEntity(user);
		
		Mail mail = new Mail();
		mail.setTo(userRegistrationRequest.getEmail());
		mail.setSubject("You are successfully registered");
		mail.setContent("Please verify your email addres by follow link:"
				+ "http://localhost:8090/verify?token="+ token 
				+ "&userid=" + user.getId());
		emailService.sendMessage(mail);
		return "redirect:/login";
	}
	
	@GetMapping("/verify")
	public String verifyUserEmail(@RequestParam("token")String token, @RequestParam("userid")String userIdStr, Model model) {//можна шукати по самому токену але це велика нагрузка на бд
		int userId = Integer.valueOf(userIdStr);
		
		UserEntity user = userEntityService.findUserByIntId(userId);
		if(user.getToken().equals(token)) {
			user.setToken("");
			user.setActivated(true);
			userEntityService.updateUser(user);
			model.addAttribute("userEmail", user.getEmail());
			return "successVerify";
		}
	
		return "redirect:/login";
	}
	
	@GetMapping("/reset_password")
	public String resetPassword(@RequestParam("token")String token, @RequestParam("userid")String userIdStr, Model model) {
		int userId = Integer.valueOf(userIdStr);
		
		UserEntity user = userEntityService.findUserByIntId(userId);
		if(user.getToken().equals(token)) {
			model.addAttribute("id", userId);
			model.addAttribute("resetPasswordForm", new ResetPassword());
			return "resetPassword";
		}
	
		return "redirect:/home";
	}
	
	@PostMapping("/reset_password/{id}")
	public String resetPasswordPost(@ModelAttribute("resetPasswordForm")@Valid ResetPassword resetPassword, BindingResult result, @PathVariable("id")int userIdStr, @RequestParam("password")String password) {
		int userId = Integer.valueOf(userIdStr);
		UserEntity userFind = userEntityService.findUserByIntId(userId);
	//String passwordGet = resetPassword.getPassword();
		if(result.hasErrors()) {
			return "resetPassword";
			}
		userFind.setToken("");
		userFind.setPassword(passwordEncoder.encode(password));
		userEntityService.updateUser(userFind);
		return "redirect:/home";
	}
	
	@GetMapping("/forget_password")
	public String enterEmailForResetPassword(Model model) {
		model.addAttribute("checkEmail", new ConfirmEmailForResetPassword());
		return"forgetPassword";
	}
	
	@PostMapping("/forget_password")
	public String confirmPassword(@ModelAttribute("checkEmail")@Valid ConfirmEmailForResetPassword confirmEmailForResetPassword, BindingResult result) {
		
	  UserEntity user =  userEntityService.findUserByEmail(confirmEmailForResetPassword.getEmail());
	
	  if(result.hasErrors() ) {
			return "forgetPassword";
			}
	  
	  
	 String token = RandomToken.generateRandomString();
		user.setToken(token);
		userEntityService.saveUserEntity(user);
		
		Mail mail = new Mail();
		mail.setTo(confirmEmailForResetPassword.getEmail());
		mail.setSubject("Reset your password");
		mail.setContent("If you requested a password reset for"+ user.getNameUser() +", click the link. If you didn't make this request, ignore this email. "
				+ "Please verify your email addres by follow link:"
				+ "http://localhost:8080/reset_password?token="+ token 
				+ "&userid=" + user.getId());
		emailService.sendMessage(mail);
		
		return "redirect:/home";
	}


	
	@GetMapping("/login")
//	@PreAuthorize ----------!!!!!!
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/reset_passwordTest")
	public String resetPasswordTest( Model model) {
		
		
			
			model.addAttribute("resetPasswordTest", new ResetPassword());
		
	
		return "resetPasswordTest";
	}
	
	@PostMapping("/reset_passwordTest")
	public String resetPasswordPostTest(@ModelAttribute("resetPasswordTest")@Valid ResetPassword resetPassword, BindingResult result,@RequestParam("password")String password) {
		
		UserEntity userFind = userEntityService.findUserByIntId(1);
	
		if(result.hasErrors()) {
			return "resetPasswordTest";
			}
	
		userFind.setPasswordConfirnation(password);
		userEntityService.updateUser(userFind);
		return "redirect:/home";
	}
	
	
	
	
	
}
