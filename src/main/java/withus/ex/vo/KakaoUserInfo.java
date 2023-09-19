package withus.ex.vo;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo {

	private String id;
	private Map<String, Object> kakaoAccount;

	public KakaoUserInfo(Map<String, Object> attributes, String id) {
		this.kakaoAccount = attributes;
		this.id = id;
	}

	@Override
	public String getProviderId() {
		return id;
	}

	@Override
	public String getProvider() {
		return "kakao";
	}


	@Override
	public String getName() {
	     return null;
	}

	@Override
	public String getUsername() {
		 return String.valueOf(kakaoAccount.get("account_email"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail() {
	     return String.valueOf(kakaoAccount.get("account_email"));
	}

}