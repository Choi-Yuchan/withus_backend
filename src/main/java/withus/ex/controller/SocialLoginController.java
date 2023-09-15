//package withus.ex.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.extern.slf4j.Slf4j;
//import withus.ex.service.OAuth2DetailsService;
//
//
//@Slf4j
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping(value = "/login/oauth2/code", produces = "application/json")
//public class SocialLoginController {
//
//
//    @Autowired
//    private OAuth2DetailsService oAuth2DetailsService;
//    
//    @GetMapping("/google")
//    public String googleLogin() {
//        return "redirect:/oauth2/authorization/google";
//    }
//
//    @GetMapping("/kakao")
//    public String kakaoLogin() {
//        return "redirect:/oauth2/authorization/kakao";
//    }
//    
//	
//    @ResponseBody
//    @GetMapping("/kakao/callback")
//    public void kakaoCallback(@RequestParam("code") String code) {
//        System.out.println("code:" + code);
//    }
//
//	
//}
