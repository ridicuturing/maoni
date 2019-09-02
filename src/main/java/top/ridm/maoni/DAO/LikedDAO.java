package top.ridm.maoni.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.ridm.maoni.DAO.mapper.LikedDOMapper;
import top.ridm.maoni.model.DO.LikedDOKey;

@Repository
public class LikedDAO {

    @Autowired
    private LikedDOMapper likedDOMapper;

    public void like(int userId,int commentId){
        LikedDOKey like = new LikedDOKey();
        like.setUserId(userId);
        like.setCommentId(commentId);
        likedDOMapper.insertSelective(like);
    }

    public void unlike(Integer userId, int commentId) {
        LikedDOKey key = new LikedDOKey();
        key.setUserId(userId);
        key.setCommentId(commentId);
        likedDOMapper.deleteByPrimaryKey(key);
    }
}
