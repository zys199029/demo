package com.cogitationsoft.findit.config;

import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.regex.Pattern;

/**
 * @author: Andy
 * @date: 5/3/2018 5:11 PM
 * @description: 根配置信息, 用于加载SpringIoc Context
 * @version: 1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.cogitationsoft.findit"}, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)
})
@EnableTransactionManagement
@PropertySource("classpath:log4j2.properties")
@Import(MyBatisConfig.class)
public class RootConfig{
	// 内部类，用来排除 web 相关的包，因为这些包已经在 WebConfig 中导入了
	public static class WebPackage extends RegexPatternTypeFilter {
		public WebPackage() {
			super(Pattern.compile("org\\.acherie\\.web"));
		}
	}
}
