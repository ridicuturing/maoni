package top.ridm.maoni.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.ridm.maoni.mapper.PostMapper;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.VO.PostVO;
import top.ridm.maoni.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller("/")
public class PublishController {


    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostService postService;


    @GetMapping("publish")
    public String publishPage(Model model, String id){
        int postId = -1;
        if(id != null){
            postId = Integer.valueOf(id);
            PostVO post = postMapper.getVOById(postId);
            model.addAttribute("post",post);
        }else{
            model.addAttribute("post",new PostVO());
        }

        return "publish";
    }

    @PostMapping("publish")
    public String publish(String id,String title, String description, String tags, HttpServletRequest request){
        UserDO user = (UserDO)request.getSession().getAttribute("user");
        if(id != null){
            postService.modifiedPost(user,Integer.valueOf(id),title,description,tags);
        }else{
            postService.newPost(user,Integer.valueOf(id),title,description,tags);
        }
        return "redirect:/post?id="+id;
    }
}
