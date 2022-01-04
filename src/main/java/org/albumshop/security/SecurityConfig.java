
package org.albumshop.security;


import org.albumshop.security.oauth.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableWebSecurity // security설정을 담당하는 Bean이다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomOAuth2UserService customOAuth2UserService ;


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // Spring Security에서 제공하는 비밀번호 암호화 객체
	}
 

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  System.out.println("configureGlobal....");
	  System.out.println(auth); 
	  // auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	}
	
	@Override // WebSecurity를 통해 HTTP 요청에 대한 웹 기반 보안을 구성
	public void configure(WebSecurity web) throws Exception {
		// 파일 기준은 resources/static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/lib/**");

	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
		http.authorizeRequests() // HttpServletRequest에 따라 접근(access)을 제한
				.antMatchers("**").permitAll() // 누구나 접근 허용
				.anyRequest().authenticated() // anyRequest() 나머지요청 , authenticated() : 인증된 사용자만 접근가능,
												// anonymous():인증도지않은 사용자가 접근가능
				.and().formLogin() // form 기반으로 인증을 하도록 한다. 로그인 정보는 기본적으로 HttpSession을 이용
				.loginPage("/user/login") // auth/login로그인 페이지 링크 .... post의 이름이 같다면 loginProcessingUrl생략
				.defaultSuccessUrl("/albumlist") // 로그인 성공 후 리다이렉트 주소
				.permitAll(); // 접근전부허용			
		http.logout() // 로그아웃에 관한 설정을 의미
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/albumlist") // 로그아웃 성공시
																											// 리다이렉트 주소
				.invalidateHttpSession(true); // 세션 지우기
				 // csrf(크로스사이트 위조요청에 대한 설정) 토큰 비활성화 (test시에는 disable권장)
		
		//구글인증
		
		 http.oauth2Login().userInfoEndpoint() //OAuth2 로그인 성공후 사용자정보를 가져오기 위함
		 .userService(customOAuth2UserService).and() ;
		//소셜로그인후 사용자정보 가져오기

    http.oauth2Login().defaultSuccessUrl("/albumlist");
		 
		
	}
	
}	 
