package top.ridm.maoni.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ridm.maoni.DAO.LikedDAO;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.service.LikedService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LikeController {
    @Autowired
    private LikedService likedService;

    @GetMapping("/like")
    @ResponseBody
    public void like(HttpServletRequest request,int commentId){
        likedService.like(((UserDO)request.getSession().getAttribute("user")).getId(),commentId);
    }

    @GetMapping("/unlike")
    @ResponseBody
    public void unlike(HttpServletRequest request,int commentId){
        likedService.unlike(((UserDO)request.getSession().getAttribute("user")).getId(),commentId);
    }
}
