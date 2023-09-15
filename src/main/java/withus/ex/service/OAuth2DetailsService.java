//package withus.ex.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//import lombok.extern.slf4j.Slf4j;
//import withus.ex.mapper.UserMapper;
//import withus.ex.vo.AuthVO;
//import withus.ex.vo.CustomUserDetailsVO;
//import withus.ex.vo.GoogleUserInfo;
//import withus.ex.vo.KakaoUserInfo;
//import withus.ex.vo.OAuth2UserInfo;
//import withus.ex.vo.PrincipalDetail;
//import withus.ex.vo.UsersVO;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//
//import lombok.RequiredArgsConstructor;
//
//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class OAuth2DetailsService extends DefaultOAuth2UserService{
//   
//   
//   @Autowired
//   private BCryptPasswordEncoder bCryptPasswordEncoder;
//   
//   
//
//   @Autowired
//   private UserMapper userMapper;
//   
//   @Override //사용자 정보 불러오기
//   public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//	
//	
//      OAuth2User oauth2User = super.loadUser(userRequest);
//      
//      OAuth2UserInfo oAuth2UserInfo = null;
//
//
//      
//      if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
//          log.info("구글 로그인 요청");
//          oAuth2UserInfo = new GoogleUserInfo(oauth2User.getAttributes());
//       }else if(userRequest.getClientRegistration().getRegistrationId().equals("kakao")){
//          log.info("카카오 로그인 요청");
//          oAuth2UserInfo = new KakaoUserInfo(oauth2User.getAttributes());
//       }
//         
//      
//      String UserId = oAuth2UserInfo.getUsername(); // ID로 사용자 식별
//
//      // 사용자 정보를 DB에서 찾거나 생성
//      UsersVO user = userMapper.getUser(UserId);
//
//
//      if (user == null) { // 최초 로그인 시
//          user = new UsersVO();
//          user.setUserId(UserId);
//          user.setPassword(bCryptPasswordEncoder.encode(UUID.randomUUID().toString())); // 랜덤 비밀번호 설정
//          userMapper.insert(user);
//       }
//
//      // 사용자 정보를 반환
//      return new PrincipalDetail(user);
//   }
//}