package com.leeyom.scaffold.config;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.Parameter;
import net.bull.javamelody.SessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;

/**
 * 监控
 *
 * @author leeyom
 */
@Component
public class MelodyConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        servletContext.addListener(new SessionListener());
    }

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean javaMelody = new FilterRegistrationBean();
        javaMelody.setFilter(new MonitoringFilter());
        javaMelody.setAsyncSupported(true);
        javaMelody.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);
        javaMelody.addInitParameter(Parameter.LOG.getCode(), "true");
        return javaMelody;
    }
}
