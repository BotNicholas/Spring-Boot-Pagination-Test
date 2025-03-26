package org.botnicholas.projects.demopagination.config;

import org.botnicholas.projects.demopagination.config.filters.LoggingFilter;
import org.botnicholas.projects.demopagination.controller.interceptors.LoggingRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoggingRequestInterceptor loggingRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingRequestInterceptor);
    }


//    We can use this approach If we want to register the filter manually or customize it's order or Url Pattern, for example...
//    @Bean
//    public FilterRegistrationBean<LoggingFilter> loggingFilter(){
//        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new LoggingFilter());
//        registrationBean.addUrlPatterns("/*"); // логируем все запросы
//        registrationBean.setOrder(1);
//
//        return registrationBean;
//    }
}
