package withus.ex.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.SignUpService;
import withus.ex.vo.UsersVO;

@Slf4j
@RestController
@RequestMapping("/user/*")
public class UserController{
	
	 @Autowired //주입
	    private SignUpService signUpService;
	 
	 	//회원가입 뷰
	    @GetMapping("/signup_view")
	    public String signup_view() {
	    
	        return "SUCCESS";
	    }
	    
	    //회원가입
		@PostMapping("/")
		public String signup(@RequestBody UsersVO usersVO) {
			
			log.info("signup()..");
			signUpService.signup(usersVO);

			return "SUCCESS";
		}

	
	
}
