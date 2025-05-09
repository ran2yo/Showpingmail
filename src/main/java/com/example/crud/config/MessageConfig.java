package com.example.crud.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
@ComponentScan("server")
public class MessageConfig implements WebMvcConfigurer{
	
	
	@Bean
	public LocaleResolver localeResolver() {
	
		SessionLocaleResolver resolver = new SessionLocaleResolver(); //session에 로케일 정보 저장 
		resolver.setDefaultLocale(Locale.KOREA);  //기본어 한국어
		return resolver;
	}
	
	
	//로케일 변경 
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	

}
