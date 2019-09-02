package top.ridm.maoni.Controller;


import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
public class LoginAndLogoutController {


    @Autowired
    private UserService userService;

    @Value("${maoni.web.page.login}")
    private String loginPage;

    @Value("${maoni.web.page.logout}")
    private String logoutPage;


    @GetMapping("hello")
    public String hello(HttpServletRequest request, String name, Model model){
        request.getSession().setAttribute("user","alan");
        return "hello";
    }



    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, HttpServletResponse response, String account, String password){
        if(null != request.getSession().getAttribute("user")){
            return "redirect:/";
        }
        return "redirect:" + loginPage;
    }

    @PostMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response, String account, String password){
        if(request.getSession().getAttribute("user") != null){
            return "{\"status\":\"1\"}";
        }
        UserDO user = userService.checkUser(account,password);
        if(user == null){
            return "{\"status\":\"-1\"}";
        }
        request.getSession().setAttribute("user",user);
        String token = UUID.randomUUID().toString().replace("-","");
        response.addCookie(new Cookie("token",token));
        userService.addUserToken(user.getId(),token);
        return "{\"status\":\"1\"}";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("user");
        response.addCookie(new Cookie("token",""));
        return "redirect:" + logoutPage;
    }

    @ToString
    class LoginStatus{
        int status = -1;

    }
}
