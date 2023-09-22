package withus.ex.controller;

import java.nio.charset.Charset;
import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.config.ResponseMessage;
import withus.ex.config.StatusEnum;
import withus.ex.mapper.UserMapper;
import withus.ex.service.SignUpService;
import withus.ex.vo.UsersVO;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
public class LoginController {

	@Autowired // 회원가입 서비스 주입
	private SignUpService signUpService;

	@Autowired
	private UserMapper userMapper;

	// 회원가입
	@PostMapping("/signup")
	public String signup(@RequestBody UsersVO usersVO) {
		log.info("signup().." + usersVO);
		signUpService.signup(usersVO);

		return "SUCCESS";
	}

	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<ResponseMessage> login(Authentication authentication, Principal principal) {
		log.info("login()..");
		UsersVO userInfo = userMapper.getUser(principal.getName());
		
		String authorityString = authentication.getAuthorities().toString();
		String authority = authorityString.replaceAll("\\[|\\]", "");
		
		int usernum = userInfo.getUserNumber();
		
		ResponseMessage message = ResponseMessage.builder().status(StatusEnum.OK).message("SUCCESS")
				.data(Map.of("authority", authority, "userNumber", usernum))
				.build();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<>(message, headers, HttpStatus.OK);
	}

}
