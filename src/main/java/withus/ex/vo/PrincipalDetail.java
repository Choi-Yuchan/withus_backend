import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class PrincipalDetail implements OAuth2User {

    private Map<String, Object> attributes;

    public PrincipalDetail(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // OAuth2 기반의 사용자의 권한 정보를 반환
        // 예를 들어, OAuth2 기반의 권한 정보를 attributes에서 추출하고 SimpleGrantedAuthority로 변환하여 반환
        // 이 예제에서는 빈 권한 리스트를 반환
        return Collections.emptyList();
    }

    @Override
    public String getName() {
        // 사용자의 이름을 반환 (일반적으로 OAuth2 제공업체에서 제공하는 사용자 이름)
        // 예를 들어, Google 로그인의 경우 "Google 사용자 이름" 반환
        return (String) attributes.get("name"); // 실제 사용자 이름 필드의 키를 사용해야 합니다.
    }
}
