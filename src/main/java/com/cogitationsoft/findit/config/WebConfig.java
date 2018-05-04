package com.cogitationsoft.findit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author: Andy
 * @date: 5/2/2018 2:20 PM
 * @description: SpringMVC starter
 * @version: 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.cogitationsoft.findit")
public class WebConfig extends WebMvcConfigurerAdapter{

	/**
	 * Method Description:
	 * 〈配置视图解析器〉
	 *
	 * @param:      null
	 * @return:     ViewResolver
	 * @author:     Andy
	 * @date:       5/3/2018 4:05 PM
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".ftl");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	/**
	 * Method Description:
	 * 〈配置Freemarker〉
	 *
	 * @param:      null
	 * @return:
	 * @author:     Andy
	 * @date:       5/3/2018 4:07 PM
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.enableContentNegotiation(new MappingJackson2JsonView());
		registry.freeMarker().cache(false);
	}
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("/WEB-INF/views/");
		return configurer;
	}

	/**
	 * Method Description:
	 * 〈静态资源位置〉
	 *
	 * @param:      ResourceHandlerRegistry 静态资源处理器注册
	 * @return:     void
	 * @author:     Andy
	 * @date:       5/3/2018 4:45 PM
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
	}


}
