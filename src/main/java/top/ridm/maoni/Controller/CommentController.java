package top.ridm.maoni.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ridm.maoni.mapper.CommentMapper;
import top.ridm.maoni.model.DO.CommentDO;
import top.ridm.maoni.model.VO.CommentVO;
import top.ridm.maoni.service.CommentService;

import java.util.List;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${maoni.web.page.post}")
    private String postPage;

    @PostMapping("/addComment")
    public String addComment(CommentDO comment, int postId){
        //commentMapper.insert(comment);
        return "redirect:" + postPage + "?id=" + postId;
    }

    @GetMapping("comment")
    @ResponseBody
    public List<CommentVO> comment(int id){
        return commentService.getCommentByParentId(id);
    }
}
