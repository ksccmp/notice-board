package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.dao.CustomerDAO;
import board.dto.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDAO dao;
	
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
	
	@PostMapping(path="/search")
	public void search(@RequestParam(name="id", required=true) String id, @RequestParam(name="name", required=true) String name,
							@RequestParam(name="number", required=true) String number, HttpServletResponse response) throws IOException {
		Customer customer = dao.search(id);
		if(customer != null && customer.getName().equals(name) && customer.getNumber().equals(number)) {
			response.getWriter().append("비밀번호는 " + customer.getPassword() + "입니다.");
		} else {
			response.getWriter().append("정보가 올바르지 않습니다.");
		}
	}
}
