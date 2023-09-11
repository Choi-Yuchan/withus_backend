package withus.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.OAuth2DetailsService;

@CrossOrigin("http://localhost:3000")
@Slf4j
@RestController
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class SocialLoginController {


	@Autowired
    private OAuth2DetailsService  googleloginService;

	//@GetMapping("/login/{registrationId}")

	
}
