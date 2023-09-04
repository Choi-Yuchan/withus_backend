package withus.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.SignUpService;
import withus.ex.vo.UsersVO;

@Slf4j
@Controller
public class LoginController{
	
	@Autowired // 회원가입 서비스 주입
	private SignUpService signUpService;
	
	

	
	// 회원가입
	@PostMapping("/signup")
	public String signup(@RequestBody UsersVO usersVO) {
		log.info("signup()..");
		signUpService.signup(usersVO);

		return "SUCCESS";
	}
	
	@GetMapping("/login")
	public void login() {
//		return "SUCCESS"; 
	}
	

	
	

	
	
}
