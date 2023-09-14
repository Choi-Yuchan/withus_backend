package withus.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.service.GetUserInfoService;
import withus.ex.service.ModifyUserService;
import withus.ex.vo.UsersVO;

@CrossOrigin("http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/user/*")
public class UserController {

	@Autowired // 회원정보조회 서비스 주입
	private GetUserInfoService getUserInfoService;

	@Autowired // 회원정보 수정
	private ModifyUserService modifyUserService; // 추가된 부분

	// 회원정보 조회
	@GetMapping("/userInfo/{userNumber}")
	public UsersVO list(@PathVariable int userNumber) {
		log.info("userInfo().." + userNumber);
		UsersVO user = getUserInfoService.getUserInfoList(userNumber);
		log.info("user: " + user);
		return user;

	}

	// 회원정보 수정
//		@PostMapping("/ModifyuserInfo/{userNumber}")	
//		public UsersVO Modify(@PathVariable int userNumber) {
//		UsersVO user = modifyUserInfoService.modifyUserInfo(userNumber);
//			
//			return user;
	

	
	@GetMapping("/updateUser")
	public String updateUser(@RequestBody UsersVO modifiedUser) {
		
		modifyUserService.modifyUser(modifiedUser);
		return "SUCCESS";

	}
	
	//로그아웃
	@GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		log.info("request: " + request);
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        logoutHandler.isInvalidateHttpSession();
        
        return "LogOutSUCCESS";
    }
	


}