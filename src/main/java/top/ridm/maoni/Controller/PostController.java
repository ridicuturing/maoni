package top.ridm.maoni.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.VO.PostVO;
import top.ridm.maoni.service.CommentService;
import top.ridm.maoni.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/myPost")
    public String myPost(HttpServletRequest request,Model model){
        model.addAttribute("pagination",postService.myPost(((UserDO)request.getSession().getAttribute("user")).getId()));
        return "index";
    }

    @GetMapping("/post")
    public String post(Model model,int id){
        int postId = -1;
        try {
            postId = Integer.valueOf(id);
        }catch (Exception e){
            return "redirect:/";
        }
        PostVO post = postService.getVOById(postId);
        if(post == null){
            return "redirect:/";
        }
        postService.addPostView(postId);
        model.addAttribute("post",post);
        model.addAttribute("comments",commentService.getCommentByParentId(id));
        return "post";
    }
}
