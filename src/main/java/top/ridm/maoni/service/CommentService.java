package top.ridm.maoni.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ridm.maoni.DAO.CommentDAO;
import top.ridm.maoni.enums.CommentTypeEnum;
import top.ridm.maoni.model.DO.CommentDO;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.DTO.CommentDTO;
import top.ridm.maoni.model.VO.CommentVO;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentDAO commentDAO;

    @Autowired
    PostService postService;

    public List<CommentVO> getCommentByParentId(int parentId, CommentTypeEnum type){
        List<CommentVO> l = commentDAO.getCommentByParentId(parentId,type);;
        return l;
    }

    public void addComment(CommentDTO comment, UserDO user) {
        CommentDO commentDO = new CommentDO();
        BeanUtils.copyProperties(comment,commentDO);
        commentDO.setUserId(user.getId());
        commentDAO.addComment(commentDO);
        increaseCommentCount(comment);

    }
    void increaseCommentCount(CommentDTO comment){
        if(CommentTypeEnum.POST .getType() == comment.getType()){
            postService.increaseCommentCountById(comment.getParentId());
        }else if (CommentTypeEnum.COMMENT.getType() == comment.getType()){

        }

    }

    public void increaseLike(int commentId) {
        commentDAO.increaseLike(commentId);
    }
    public void decreaseLike(int commentId) {
        commentDAO.decreaseLike(commentId);
    }
}
