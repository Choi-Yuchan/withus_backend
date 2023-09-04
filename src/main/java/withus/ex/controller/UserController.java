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
import withus.ex.vo.UsersVO;

@CrossOrigin("http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/user/*")
public class UserController {

	@Autowired // 회원정보조회 서비스 주입
	private GetUserInfoService getUserInfoService;


	// 회원정보 조회
	@GetMapping("/userInfo/{userNumber}")
	public UsersVO list(@PathVariable int userNumber) {
		log.info("userInfo().."  + userNumber);
		UsersVO user = getUserInfoService.getUserInfoList(userNumber);
		log.info("user: " + user);
		return user;

	}
	
	
}
