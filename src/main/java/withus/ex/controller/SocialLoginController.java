package withus.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.OAuth2DetailsService;


@Slf4j
@RestController
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class SocialLoginController {


    @Autowired
    private OAuth2DetailsService oAuth2DetailsService;
    
    @GetMapping("/google")
    public String googleLogin() {
        return "redirect:/oauth2/authorization/google";
    }

    @GetMapping("/kakao")
    public String kakaoLogin() {
        return "redirect:/oauth2/authorization/kakao";
    }
	

	
}
