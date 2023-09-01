package withus.ex.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
	
	
	@GetMapping("/login")
	public void login() {
//		return "SUCCESS"; 
	}
	
	/* 로그인 정보를 가져오는 방법 */
	@GetMapping("/loginInfo")
	public String loginInfo(Authentication authentication, Principal principal) {
		
	      String user_id;
	                   
	      System.out.println("authentication 유저 아이디:" + authentication.getName());
	      System.out.println("authentication 권한들:" + authentication.getAuthorities()   );
	      
	      System.out.println("Principal 유저 아이디:" + principal.getName() );
	        
	        return "redirect:/";
		
	}
	
	//회원가입뷰
	@GetMapping("/signup_view")
	public String signup_view() {
		log.info("signup_view()..");

		return "SUCCESS";
	}
	
	
	// 회원가입
	@PostMapping("/signup")
	public String signup(@RequestBody UsersVO usersVO) {
		log.info("signup()..");
		signUpService.signup(usersVO);

		return "SUCCESS";
	}

	
	

	
	
}
