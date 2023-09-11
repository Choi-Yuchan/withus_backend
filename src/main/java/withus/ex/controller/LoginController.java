package withus.ex.controller;

import java.nio.charset.Charset;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.config.ResponseMessage;
import withus.ex.config.StatusEnum;
import withus.ex.service.SignUpService;
import withus.ex.vo.UsersVO;

@CrossOrigin("http://localhost:3000")
@Slf4j
@RestController
public class LoginController {

	@Autowired // 회원가입 서비스 주입
	private SignUpService signUpService;
	


	// 회원가입
	@PostMapping("/signup")
	public String signup(@RequestBody UsersVO usersVO) {
		log.info("signup()..");
		signUpService.signup(usersVO);

		return "SUCCESS";
	}


	@PostMapping("/login")
	@ResponseBody
    public ResponseEntity<ResponseMessage> login(Authentication authentication, Principal principal) {
        log.info("login()..");
		ResponseMessage message = ResponseMessage.builder()
        	    .status(StatusEnum.OK)
        	    .message("SUCCESS")
        	    .data(authentication.getAuthorities())
        	    .build();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
	


}
