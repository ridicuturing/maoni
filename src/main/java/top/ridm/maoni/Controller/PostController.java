package top.ridm.maoni.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.ridm.maoni.enums.CommentTypeEnum;
import top.ridm.maoni.model.DO.TagDO;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.VO.CommentVO;
import top.ridm.maoni.model.VO.PostVO;
import top.ridm.maoni.service.CommentService;
import top.ridm.maoni.service.PostService;
import top.ridm.maoni.service.TagService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    TagService tagService;

    @GetMapping("/myPost")
    public String myPost(HttpServletRequest request,Model model){
        model.addAttribute("pagination",postService.myPost(((UserDO)request.getSession().getAttribute("user")).getId()));
        return "index";
    }

    @GetMapping("/post")
    public String post(Model model,int id){
        PostVO post = postService.getVOById(id);

        if(post == null){
            return "redirect:/";
        }
        postService.addPostView(id);
        model.addAttribute("post",post);
        List<TagDO> tags = tagService.listPostTags(id);
        model.addAttribute("tags",tags.stream().map(TagDO::getTag).collect(Collectors.toList()));
        model.addAttribute("comments",commentService.getCommentByParentId(id,CommentTypeEnum.POST));
        model.addAttribute("relatedPosts",postService.listRelated(id,tags));
        return "post";
    }
}
