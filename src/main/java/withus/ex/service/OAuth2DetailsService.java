package withus.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.AuthVO;
import withus.ex.vo.CustomUserDetailsVO;
import withus.ex.vo.GoogleUserInfo;
import withus.ex.vo.OAuth2UserInfo;
import withus.ex.vo.PrincipalDetail;
import withus.ex.vo.UsersVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class OAuth2DetailsService extends DefaultOAuth2UserService{
   
   
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Autowired
   private UserMapper userMapper;
   
   @Override //사용자 정보 불러오기
   public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

      OAuth2User oauth2User = super.loadUser(userRequest);

      OAuth2UserInfo oAuth2UserInfo = null;
      
      if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
         log.info("구글 로그인 요청");
         oAuth2UserInfo = new GoogleUserInfo(oauth2User.getAttributes());

//      }else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
//         log.info("페이스북 로그인 요청");
//         oAuth2UserInfo = new FacebookUserInfo(oauth2User.getAttributes());
//      }else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
//         log.info("네이버 로그인 요청");
//         oAuth2UserInfo = new NaverUserInfo((Map)oauth2User.getAttributes().get("response"));
//      }else if(userRequest.getClientRegistration().getRegistrationId().equals("kakao")){
//         log.info("카카오 로그인 요청");
//         oAuth2UserInfo = new KakaoUserInfo(oauth2User.getAttributes());
     }

      String username = oAuth2UserInfo.getProvider() + oAuth2UserInfo.getUsername();
      String password = bCryptPasswordEncoder.encode("user"); 
      String email = oAuth2UserInfo.getEmail();
      String name = oAuth2UserInfo.getName();


      UsersVO userVO = userMapper.getUser(userId);


      if(userVO==null) { //최초 로그인 시
         User user = User.builder() //사용자 정보를 나타내는 클래스
               .userId(userId)
               .password(password)
               .authority("ROLE_USER")
               .build();
         
         List<AuthVO> authList = new ArrayList<>();
      
         authList.add(authVO);
      }
   }
}