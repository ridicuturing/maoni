package top.ridm.maoni.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.ridm.maoni.enums.CommentTypeEnum;
import top.ridm.maoni.model.DO.CommentDO;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.DTO.CommentDTO;
import top.ridm.maoni.model.VO.CommentVO;
import top.ridm.maoni.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${maoni.web.page.post}")
    private String postPage;

    @GetMapping("/comment")
    @ResponseBody
    public List<CommentVO> Comment(int id){
        return commentService.getCommentByParentId(id,CommentTypeEnum.COMMENT);
    }

    @PostMapping("/comment")
    @ResponseBody
    public String addCommentPost(@RequestBody CommentDTO comment, HttpServletRequest request){
        commentService.addComment(comment,(UserDO)request.getSession().getAttribute("user"));
        return "";
    }
}
