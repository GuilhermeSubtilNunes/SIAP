package br.com.senacrs;

import br.com.senacrs.spring.ThymeleafLayoutInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class HealthsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthsysApplication.class, args);
	}

	@Configuration
	public static class ThymeleafLayoutInterceptorConfig extends WebMvcConfigurationSupport {
		@Override
		protected void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new ThymeleafLayoutInterceptor());
		}
	}
}
