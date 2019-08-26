package top.ridm.maoni.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Value("${maoni.web.page.login}")
    private String loginPage;
    @Value("${maoni.web.api.login}")
    private String loginApi;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        loginRegistry.excludePathPatterns(loginPage);
        loginRegistry.excludePathPatterns(loginApi);
        loginRegistry.excludePathPatterns("/**/*.js");
        loginRegistry.excludePathPatterns("/**/*.css");
        loginRegistry.excludePathPatterns("/**/*.png");
        loginRegistry.excludePathPatterns("/**/*.gif");
        loginRegistry.excludePathPatterns("/**/*.jpeg");

    }
}
