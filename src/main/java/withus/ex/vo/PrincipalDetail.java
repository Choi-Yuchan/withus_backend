package withus.ex.vo;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import withus.ex.vo.UsersVO;

import java.util.Collection;
import java.util.Map;

public class PrincipalDetail implements UserDetails, OAuth2User {

    private UsersVO user;

    public PrincipalDetail(UsersVO user) {
        this.user = user;
    }
    

    @Override
	public Map<String, Object> getAttributes() {
		return null;
	}


	@Override
	public String getName() {
		return null;
	}


	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        // 사용자의 암호를 반환하는 코드를 구현
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // 사용자의 식별자를 반환하는 코드를 구현
        return user.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정이 만료되었는지 여부를 반환하는 코드를 구현
        return true; // 만료되지 않음
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정이 잠겨있는지 여부를 반환하는 코드를 구현
        return true; // 잠겨있지 않음
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 자격 증명(비밀번호 등)이 만료되었는지 여부를 반환하는 코드를 구현
        return true; // 만료되지 않음
    }

    @Override
    public boolean isEnabled() {
        // 계정이 활성화되었는지 여부를 반환하는 코드를 구현
        return true; // 활성화됨
    }
}
