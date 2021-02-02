package net.slipp.web;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	private List<User> users = new ArrayList<User>();
	@PostMapping("/create")
	public String create(User user ) {
		System.out.println("user : " + user);
		users.add(user);
	//return "list"; list.html로 가게 됨. 차이점을 주어야함
		return "redirect:/list";
	}
	
	@GetMapping("/list") // 가입된 사용자 목록을 가져올 거라서 get으로 가져옴
	public String list(Model model) { // view로 전달하기위해 model을 씀
		model.addAttribute("users", users);
		return "list";
	}
	
	@GetMapping("/index")
	public String index(Model model) { // view로 전달하기위해 model을 씀
	return "index";
	}	

}
