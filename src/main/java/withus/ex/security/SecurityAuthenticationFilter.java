package withus.ex.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecurityAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // GET 요청인 경우 JSON 데이터 파싱을 스킵
        if (request.getMethod().equals(HttpMethod.GET.name())) {
            filterChain.doFilter(request, response);
            return;
        }
        if(request.getRequestURI().equals("/signup")) {
        	filterChain.doFilter(request, response);
        	return;
        }
        log.info("request: " + request.getRequestURI());
        
        // Jackson ObjectMapper를 생성합니다.
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 요청 본문에서 JSON 데이터를 읽어와서 JsonNode로 파싱합니다.
            JsonNode jsonNode = objectMapper.readTree(request.getInputStream());

            // JsonNode에서 사용자 이름과 비밀번호를 추출합니다.
            String username = jsonNode.get("username").asText();
            String password = jsonNode.get("password").asText();

            log.info("SecurityAuthenticationFilter - username: " + username);

            if (username != null && !username.isEmpty()) {
                UserDetails authentication = customUserDetailsService.loadUserByUsername(username);

                // 비밀번호를 DB에서 가져와서 사용자 입력 비밀번호와 비교합니다.
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
        } catch (Exception e) {
            // 예외 처리 로직 추가
            // 예를 들어, 인증 실패 시 적절한 응답을 생성할 수 있습니다.
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("인증 실패");
        }
    }
}
