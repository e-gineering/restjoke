package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SpringBootApplication includes a lot of useful annotations: "@Configuration
 * -- tags class as a source of bean definitions for application context
 * "@EnableAutoConfiguration -- allows bean to be added based on classpath
 * settings, other beans, other settings "@EnableWebMvc -- SpringBoot actually
 * adds this automagically. adds key web application behaviors "@ComponentScan
 * -- tells Spring to look for other components, etc. in the package
 */
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

	public static String expectedToken = System.getenv("CN_EXPECTED_TOKEN");
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		super.configurePathMatch(configurer);

		configurer.setUseSuffixPatternMatch(false);
	}

}