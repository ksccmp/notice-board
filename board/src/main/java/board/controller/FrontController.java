package board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.dao.BoardDAO;
import board.dto.Customer;

@Controller
public class FrontController {
	
	@Autowired
	BoardDAO dao;
	
	@PostMapping(path="/signup")
	public String signup(@ModelAttribute Customer customer) {
		dao.insert(customer);
		return "redirect:main.jsp";
	}
	
	@PostMapping(path="/login")
	public String login(@RequestParam(name="id", required=true) String id, @RequestParam(name="password", required=true) String password, HttpSession session) {
		if(dao.login(id, password)) {
			session.setAttribute("IsLogin", id);
			return "redirect:main.jsp";
		}
		session.setAttribute("LoginError", "로그인에 실패했습니다!");
		return "redirect:login.jsp";
	}
	
	@GetMapping(path="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("IsLogin");
		return "redirect:main.jsp";
	}
}
