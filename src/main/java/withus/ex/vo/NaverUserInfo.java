package withus.ex.vo;

import java.util.Map;

public class NaverUserInfo implements OAuth2UserInfo {

	private Map<String, Object> attributes;

	public NaverUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	  @Override
	    public String getProviderId() {
	        return String.valueOf(attributes.get("id"));
	    }

	    @Override
	    public String getProvider() {
	        return "naver";
	    }

	@Override
	public String getUsername() {
		 return String.valueOf(attributes.get("id"));
				 //(String) attributes.get("sub");
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
	    return String.valueOf(attributes.get("name"));

	}

	@Override
	public String getEmail() {
        return String.valueOf(attributes.get("email"));
	}

}