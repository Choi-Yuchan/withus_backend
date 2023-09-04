package withus.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import withus.ex.security.CustomUserDetailsService;


@Configuration //@Component+설정
@EnableWebSecurity//스프링시큐리티필터가 스프링 필터체인에 등록됨 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	 @Bean
		public PasswordEncoder passwordEncoder() {
		  return new BCryptPasswordEncoder();
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
	      http.csrf().disable(); //공격에 대한 방어해제
	      http.authorizeRequests() //페이지에권한부여
	        .antMatchers("/user/**").hasAnyRole("USER") //user부분권한설정(user만접근가능
	        .antMatchers("/order/**").hasAnyRole("USER")
	        .antMatchers("/**").permitAll();

	//      http.authorizeRequests() // 인증과 권한을 설정
	//      .antMatchers("/user/**").hasAnyRole("USER")  // 경로 패턴을 지정,권한있는자만 접근가능하게//user아이디로 로그인하게되면user자격얻음
	//      .antMatchers("/**").permitAll(); //모든 경로에 대해 인증되지 않은 사용자도 접근을 허용 (모두에게)  
	      
	      http.formLogin() //스프링 시큐리티에 있는 기본 로그인 폼을 사용하겠다는뜻
	      	//.loginPage("/login") //loginPage()는 말그대로 로그인할 페이지 url이고
	      	.defaultSuccessUrl("/")//로그인 성공후 메인으로 가도록
	      	.permitAll(); //모든 유저가 로그인화면을 볼 수 있게 한다
	//  }
	    
	  }
}