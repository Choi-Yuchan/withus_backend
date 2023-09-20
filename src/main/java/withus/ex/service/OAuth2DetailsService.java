package withus.ex.service;

import java.sql.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.GoogleUserInfo;
import withus.ex.vo.KakaoUserInfo;
import withus.ex.vo.NaverUserInfo;
import withus.ex.vo.OAuth2UserInfo;
import withus.ex.vo.PrincipalDetail;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class OAuth2DetailsService extends DefaultOAuth2UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserMapper userMapper;

	@Override // 사용자 정보 불러오기
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

		OAuth2User oAuth2User = super.loadUser(userRequest);

		OAuth2UserInfo oAuth2UserInfo = null;

		if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());

		} else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
			oAuth2UserInfo = new NaverUserInfo((Map<String, Object>) oAuth2User.getAttributes().get("response"));
			
		} else if (userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
			oAuth2UserInfo = new KakaoUserInfo((Map<String, Object>) oAuth2User.getAttributes().get("kakao_account"),
				String.valueOf(oAuth2User.getAttributes().get("account_email")));
		}


		String UserId = oAuth2UserInfo.getUsername(); // ID로 사용자 식별

		// 사용자 정보를 DB에서 찾거나 생성
		UsersVO user = userMapper.getUser(UserId);

		if (user == null) { // 최초 로그인 시
			user = new UsersVO();
			user.setUserId(UserId);
			user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString())); // 랜덤 비밀번호 설정

			user.setUserName("stest");
			user.setPhoneNumber("1234567890");
			user.setAddr1("서울시");
			user.setAddr2("강동구");
			user.setAddr3("어딘가");
			user.setBirth(new Date(2000 - 1900, 9, 25)); // Month starts from 0
			user.setGender("M");
			// userMapper.insertAuth(user);
			userMapper.insert(user);
		}

		// 사용자 정보를 반환
		return new PrincipalDetail(user);

}
}