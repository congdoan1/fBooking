package com.tga.fbooking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tga.fbooking.api.APIWrapper;
import com.tga.fbooking.dao.UserDAO;
import com.tga.fbooking.dto.UserDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username")String username,
			@RequestParam("password")String password, Model model) {
		UserDTO dto = UserDAO.checkLogin(username, password);
		if (dto != null) {
			model.addAttribute("user", dto.getUsername());
			return "home";
		}
		//model.addAttribute("invalid", "Invalid username or password!!!");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login/facebook", method = RequestMethod.GET)
	public String login(@RequestParam("code")String code, Model model) {
		
		//Tu code da lay, chuyen thanh access token
		APIWrapper wrapper = new APIWrapper();
		String accessToken = wrapper.getAccessToken(code);
		wrapper.setAccessToken(accessToken);
		
		//Truy cap thong tin user
		UserDTO dto = wrapper.getUserInfo();
		boolean userExist = UserDAO.checkLogin(dto.getFacebookId()) != null;
		
		//User chua ton tai trong db thi dang ki
		if (!userExist) {
			UserDAO.register(dto.getUsername(), dto.getFirstName(), 
					dto.getLastName(), dto.getFacebookId().trim(), dto.getFacebookUrl());
		}
		
		//Dua thong tin cao session de login vao
		model.addAttribute("user", dto);
		return "home";
	}
	
}
