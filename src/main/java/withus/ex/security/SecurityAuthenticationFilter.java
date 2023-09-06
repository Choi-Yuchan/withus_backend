package withus.ex.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecurityAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String username = (String) request.getParameter("username"); // 예를 들어, 파라미터에서 사용자 이름을 추출
		String password = (String) request.getParameter("password");
		
	       log.info("SecurityAuthenticationFilter - username: " + username);

	        if (username != null && !username.isEmpty()) {
	            UserDetails authentication = customUserDetailsService.loadUserByUsername(username);
	            
	            // 비밀번호를 DB에서 가져와서 사용자 입력 비밀번호와 비교
	            String userPassword = authentication.getPassword();
	            
	            if (password != null && password.equals(userPassword)) {
	                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
	                        authentication.getUsername(), authentication.getPassword(), authentication.getAuthorities());
	                SecurityContextHolder.getContext().setAuthentication(auth);
	            } else {
	                // 비밀번호가 일치하지 않는 경우 에러 발생
	                throw new BadCredentialsException("비밀번호가 유효하지 않습니다.");
	            }
	        } else {
	            // username이 null 또는 빈 값인 경우에 대한 처리 (에러를 던질 수 있음)
	            throw new ServletException("사용자 이름이 유효하지 않습니다.");
	        }
	        
		filterChain.doFilter(request, response);

	}

}
