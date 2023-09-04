package withus.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.GetUserInfoService;
import withus.ex.service.ModifyUserInfoService;
import withus.ex.service.SignUpService;
import withus.ex.vo.UsersVO;

@CrossOrigin("http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/user/*")
public class UserController {

	@Autowired // 회원정보조회 서비스 주입
	private GetUserInfoService getUserInfoService;
	
	@Autowired // 회원정보 수정 
	private ModifyUserInfoService modifyUserInfoService; // 추가된 부분
	
    
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

	}
	
    // modifiedUser, modifyUserInfo 이렇게 변경함 modifyUserInfoService(변경전이름)
	// 겹치기도하고 가독성 떨어져서... 근데 바꿔도 되는지 물어보기 파일이 없으니까
	
	// 회원정보 수정
	@PostMapping("/modifyUserInfoService/{userNumber}") // 추가된 부분
	public ResponseEntity<String> modifyUserInfoService(
	    @PathVariable int userNumber,
	    @RequestBody UsersVO modifiedUser
	) {
	    log.info("modifyUserInfoService() for userNumber: {}", userNumber);
	
	    boolean isSuccess = modifyUserInfoService.modify(userNumber);
	
	    if (isSuccess) {
	        return ResponseEntity.ok("SUCCESS");
	    } else {
	        return ResponseEntity.badRequest().body("Failed to update user information.");
	    }
	}

}
