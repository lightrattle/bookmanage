package com.bookmanage.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 * 新建配置类继承WebMvcConfigurerAdapter类，重写addInterceptors方法
 * 既然要增加自己的拦截器，那当然要得到springboot加入拦截器的入口，然后把我们自己写的拦截器也注册到springboot中让其起作用
 * 需要加入@Configuration注解，在springboot启动的时候就会该配置类就会被扫描并加载，从而将我们的拦截器注册进去。这时候的拦截器已经可以正常工作了
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器并设置拦截的请求路径
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**") //拦截的路径
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/index.html")
                .excludePathPatterns("../images/**")
                .excludePathPatterns("/user/**");//排除的路径
    }

}