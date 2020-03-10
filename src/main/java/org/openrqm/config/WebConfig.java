/*
 * openrqm-server
 * SPDX-License-Identifier: GPL-2.0-only
 * Copyright (C) 2019 Marcel Jaehn
 */

package org.openrqm.config;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .allowedHeaders("*");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pmc) {}

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer cnc) {}

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asc) {}

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer dshc) {}

    @Override
    public void addFormatters(FormatterRegistry fr) {}

    @Override
    public void addInterceptors(InterceptorRegistry ir) {}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry rhr) {}

    @Override
    public void addViewControllers(ViewControllerRegistry vcr) {}

    @Override
    public void configureViewResolvers(ViewResolverRegistry vrr) {}

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {}

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {}

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {}

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {}

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {}

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {}

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
