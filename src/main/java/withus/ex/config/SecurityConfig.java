package withus.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import withus.ex.security.CustomUserDetailsService;
import withus.ex.security.SecurityAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityAuthenticationFilter securityAuthenticationFilter() {
		return new SecurityAuthenticationFilter();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/fonts/**", "/js/**", "/imges/**", "/lib/**");
		web.debug(true);
	} // 리소스파일들은 시큐리티세팅에서 관리하지 않도록

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override // 권한인증 설정해주기
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and() // CorsFilter 활성화
		.csrf().disable() // CSRF 보안 비활성화
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 사용 안 함
		.and()
		.authorizeRequests()
			.antMatchers("/**").permitAll()
			.antMatchers("/user/**").authenticated() // 나머지 API는 인증된 사용자만 접근 가능
			.antMatchers("/user/**").hasAnyRole("USER") // USER 역할을 가진 사용자만 접근 가능
			.anyRequest().permitAll() // 나머지 요청은 모든 사용자에게 허용
		.and()
		.formLogin().disable(); // 폼 로그인 사용 안 함

	http.addFilterBefore(securityAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

	}

}