package top.ridm.maoni.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.ridm.maoni.Common.Common;
import top.ridm.maoni.DAO.mapper.CommentDOMapper;
import top.ridm.maoni.DAO.mapper.CommentMapper;
import top.ridm.maoni.enums.CommentTypeEnum;
import top.ridm.maoni.model.DO.CommentDO;
import top.ridm.maoni.model.DO.CommentDOExample;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.VO.CommentVO;

import java.util.List;

@Repository
public class CommentDAO {

    @Autowired
    private CommentDOMapper commentDOMapper;

    @Autowired
    private CommentMapper commentMapper;

    public List<CommentVO> getCommentByParentId(int parentId, CommentTypeEnum type){
        UserDO u = Common.getUser();
        return commentMapper.getPostComments(u.getId(),parentId,type.getType());
    }

    public void addComment(CommentDO commentDO) {
        commentDOMapper.insertSelective(commentDO);
    }

    public void increaseLike(int commentId) {
        commentMapper.increaseLike(commentId);
    }

    public void decreaseLike(int commentId) {
        commentMapper.decreaseLike(commentId);
    }

    public void increaseCommentCount(int commentId) {
        commentMapper.increaseCommentCount(commentId);
    }

    public void decreaseCommentCount(int commentId) {
        commentMapper.decreaseCommentCount(commentId);
    }
}
