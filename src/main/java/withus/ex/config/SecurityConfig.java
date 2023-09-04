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
	      web.ignoring().antMatchers("/css/**","/fonts/**", "/js/**", "/imges/**", "/lib/**");
	   }    //리소스파일들은 시큐리티세팅에서 관리하지 않도록
	
	 
	  @Override 
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	   }
	  
	  @Override //권한인증 설정해주기
	   protected void configure(HttpSecurity http) throws Exception {
		  http
		  		.cors().and() //CorsFilter활성화
		  		.csrf().disable() //보안해제
		  		.sessionManagement()
		  		//	.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //스프링시큐리티에서 세션관리x
		  			//클라이언트에서 요청하는 헤더에 token을 담아보낸다면 서버에서 토큰을 확인하여 인증하는 방식을 사용
		  			.and()
		  			
		  		.authorizeRequests() //인증절차 설정,특정url
		  		//	.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		  			.antMatchers("/**").permitAll() 
		  			.antMatchers("/user/**").authenticated() //인증완료되어야 api사용가능함(#200통과#403에러)
		  			//.antMatchers("/user/**").hasAnyRole("ROLE_USER") 
		  			//.antMatchers("/order/**").hasAnyRole("ROLE_USER")
                        	
		  			.anyRequest().permitAll()
                    .and()
                    .formLogin().disable();
		 
		  http
          .addFilterBefore(securityAuthenticationFilter(), 
          				 UsernamePasswordAuthenticationFilter.class);


	      
	  }	  
}