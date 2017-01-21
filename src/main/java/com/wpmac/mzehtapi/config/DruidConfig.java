package com.wpmac.mzehtapi.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package: cn.upg.credit.common.config Description: 数据库监控类
 *
 * @author : yingxiaohong
 * @create : yingxiaohong 2016-11-11-下午4:28
 * @update : yingxiaohong (2016-11-11-下午4:28)
 **/

@Configuration
public class DruidConfig {


    /**
     * druid监控servlet配置
     * @return
     */
	@Bean
	public ServletRegistrationBean druidServlet(@Value("${druidpool.monitor.mapping}") String mapping,
			@Value("${druidpool.monitor.allow}") String allow, @Value("${druidpool.monitor.deny}") String deny,
			@Value("${druidpool.monitor.user}") String user, @Value("${druidpool.monitor.pass}") String pass) {
		ServletRegistrationBean reg = new ServletRegistrationBean();
		reg.setServlet(new StatViewServlet());
		reg.addUrlMappings(mapping);
		reg.addInitParameter("allow", allow);
		reg.addInitParameter("deny", deny);
		reg.addInitParameter("loginUsername", user);
		reg.addInitParameter("loginPassword", pass);
		return reg;
	}

	/**
     * druid监控filter配置
     * @return
     */
	@Bean
	public FilterRegistrationBean filterRegistrationBean(@Value("${druidpool.monitor.mapping}") String mapping,
			@Value("${druidpool.monitor.exclusions}") String exclusions) {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns(mapping);
		filterRegistrationBean.addInitParameter("exclusions", exclusions);
		return filterRegistrationBean;
	}
}
