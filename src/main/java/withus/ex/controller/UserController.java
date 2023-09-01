package withus.ex.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.GetUserInfoService;
import withus.ex.service.SignUpService;
import withus.ex.vo.UsersVO;

@CrossOrigin("http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/user/*")
public class UserController {

	@Autowired // 회원가입 서비스 주입
	private SignUpService signUpService;

	@Autowired // 회원정보조회 서비스 주입
	private GetUserInfoService getUserInfoService;

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

	// 회원정보 조회
	@GetMapping("/userInfo/{userNumber}")
	public UsersVO list(@PathVariable int userNumber) {
		log.info("userInfo().."  + userNumber);
		UsersVO user = getUserInfoService.getUserInfoList(userNumber);
		log.info("user: " + user);
		return user;

		// jsonObject.put("key1", "value1");
		// jsonObject.put("key2", "value2");
		// return ResponseEntity.ok(jsonObject);
		// Json으로보내는방법 예시임. 회원정보를 key-value값으로 보내야함 이때 (이름명:이름값, 비번명:비번값)이렇게넘어가야해

	}
	//로그인 하기
	@GetMapping("/login")
	public String login() {
		return "login/login"; 
	}
	
	/* 로그인 정보를 가져오는 방법 */
	@GetMapping("/loginInfo")
	public String loginInfo(Authentication authentication, Principal principal) {
		
	      String user_id;
	     
	      //1.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할수있음 )      
	     // Authentication  auth = SecurityContextHolder.getContext().getAuthentication();
	      //  user_id = auth.getName();
	      //  System.out.println("유저 아이디:" + user_id   );
	                      
	      //2.authentication 객체로 가져오는 방법(많은 )              
	      System.out.println("authentication 유저 아이디:" + authentication.getName());
	      System.out.println("authentication 권한들:" + authentication.getAuthorities()   );
	      
	      //3.Principal 객체로 가져오는 방법(가져올수 있는게 getName() 정도             
	      System.out.println("Principal 유저 아이디:" + principal.getName() );
	        
	        return "redirect:/";
		
	}
	
	
	
	
}
