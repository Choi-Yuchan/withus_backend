package withus.ex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@Slf4j
@RestController
@RequestMapping("/user/*")
public class UserController {

	@Autowired // 회원가입 서비스 주입
	private SignUpService signUpService;

	@Autowired // 회원정보조회 서비스 주입
	private GetUserInfoService getUserInfoService;

	// 회원가입
	@PostMapping("/singup")
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
	
	
}
