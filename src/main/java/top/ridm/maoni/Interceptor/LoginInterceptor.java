package top.ridm.maoni.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.ridm.maoni.mapper.UserMapper;
import top.ridm.maoni.model.DO.UserDO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Value("${maoni.web.page.login}")
    private String loginPage;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if(request.getSession().getAttribute("user") != null){
            return true;
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if("token".equals(cookie.getName())){
                if(cookie.getValue().length() == 32) {
                    UserDO user = userMapper.findUserByToken(cookie.getValue());
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                        return true;
                    }
                }
            }
        }
        response.sendRedirect(loginPage);
        return false;
    }
}
