package withus.ex.vo;

import java.util.Map;

public class GoogleUserInfo implements OAuth2UserInfo {
	  
	private Map<String, Object> attributes;
	
	public GoogleUserInfo(Map<String, Object> attributes){
	        
		this.attributes = attributes;
	 }
	
	 @Override
	    public String getProvider() {
	        return "google_";
	    }

	    @Override
	    public String getUsername() {
	        return (String) attributes.get("sub");
	    }

	    @Override
	    public String getPassword() {
	        return null;
	    }


	    @Override
	    public String getName() {
	        return (String) attributes.get("name");
	    }

		@Override
		public String getEmail() {
			// TODO Auto-generated method stub
			return null;
		}
	  	  


}
