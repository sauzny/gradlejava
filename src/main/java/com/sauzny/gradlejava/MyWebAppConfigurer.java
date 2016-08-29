package com.sauzny.gradlejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sauzny.gradlejava.utils.CommonConfUtils;


@Configuration
@ConfigurationProperties(prefix="service")
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Autowired private CommonConfUtils commonConfUtils;
	
	/**
	 * 	方法描述:  静态资源映射
	 *
	 *  @author : ljx 创建时间 2016年8月26日 上午11:04:24
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
        registry.addResourceHandler("/tempUpPath/**")
        	.addResourceLocations("file:///"+commonConfUtils.getTempUpPath());
        
        registry.addResourceHandler("/tempDownPath/**")
        	.addResourceLocations("file:///"+commonConfUtils.getTempDownPath());
        
        super.addResourceHandlers(registry);
    }

	/**
	 * 	方法描述:  跨域设置
	 *
	 *  @author : ljx 创建时间 2016年8月26日 下午3:36:16
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/c/**").allowedOrigins("*")
				.allowedMethods("POST", "GET", "OPTIONS")
				.allowedHeaders("Content-Type", "Accept", "X-Requested-With")
				.allowCredentials(true)
				.maxAge(3600);
	}
	

	
}
