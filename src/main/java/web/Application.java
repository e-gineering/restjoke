package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Bryson
 * @since 05/25/16
 * date last modified 05/31/16
 * 
 *         SpringBootApplication includes a lot of useful annotations:
 *         "@Configuration -- tags class as a source of bean definitions for
 *         application context "@EnableAutoConfiguration -- allows bean to be
 *         added based on classpath settings, other beans, other settings
 *         "@EnableWebMvc -- SpringBoot actually adds this automagically. adds
 *         key web application behaviors "@ComponentScan -- tells Spring to look
 *         for other components, etc. in the hello package (HelloController!)
 */
@SpringBootApplication
public class Application extends  WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
	    super.configurePathMatch(configurer);

	    configurer.setUseSuffixPatternMatch(false);
	}

}