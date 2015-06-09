package com.tga.fbooking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginBack() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username")String username,
			@RequestParam("password")String password, HttpSession session) {
		UserDTO dto = UserDAO.checkLogin(username, password);
		if (dto != null) {
			session.setAttribute("user", dto.getUsername());
			return "redirect:/home";
		}
		session.setAttribute("invalid", "Invalid username or password!!!");
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login/facebook", method = RequestMethod.GET)
	public String loginFB(HttpServletRequest request, HttpSession session) {
		String code = request.getParameter("code");
		if (code == null) {
			return "redirect:/";
		}
		//Tu code da lay, chuyen thanh access token
		APIWrapper wrapper = new APIWrapper();
		String accessToken = wrapper.getAccessToken(code);
		wrapper.setAccessToken(accessToken);
		
		//Truy cap thong tin user
		UserDTO dto = wrapper.getUserInfo();
		boolean userExist = UserDAO.checkLogin(dto.getFacebookId()) != null;
		
		//User chua ton tai trong db thi dang ki
		if (!userExist) {
			session.setAttribute("user", dto);
			return "register";
		}
		
		//Dua thong tin cao session de login vao
		session.setAttribute("user", UserDAO.checkLogin(dto.getFacebookId()).getUsername());
		return "home";
	}
	
	@RequestMapping(value = "/login/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("username") String username,
			@ModelAttribute("password") String password,
			@ModelAttribute("firstname") String firstname,
			@ModelAttribute("lastname") String lastname,
			@ModelAttribute("facebookId") String facebookId,
			@ModelAttribute("facebookUrl") String facebookUrl, HttpSession session) {

		if (UserDAO.checkExisted(username)) {
			session.setAttribute("duplicate", "This username is already in use.");
			return "redirect:/register";
		}

		UserDAO.register(username, password, firstname.trim(), lastname.trim(),
				facebookId, facebookUrl);

		// Dua thong tin cao session de ve trang home
		session.setAttribute("user", username);
		return "home";
	}
	
	@RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
       session.invalidate();
       return "redirect:/";
    }
	
}
