package top.ridm.maoni.DAO.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import top.ridm.maoni.model.DO.PostDO;
import top.ridm.maoni.model.VO.CommentVO;
import top.ridm.maoni.model.VO.PostVO;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select `comment`.id as comment_id,comment.like,comment_count,user.id as user_id,`user`.avatar_url,`user`.username,content,`comment`.create_time ,(case when liked.user_id is not null then 1 else 0 end)'liked' " +
            "from (comment LEFT JOIN user on `user`.id = `comment`.user_id) " +
            "LEFT JOIN liked " +
            "on `comment`.id= liked.comment_id " +
            "and liked.user_id  = #{userId}" +
            " where parent_id=#{parentId} and type=#{type} ")
    List<CommentVO> getPostComments(@Param("userId") int userId,@Param("parentId") int parentId, @Param("type")short type);

    @Update("update comment set `comment`.`like` = `comment`.`like` + 1 where id = #{commentId} ")
    void increaseLike(int commentId);

    @Update("update comment set `comment`.`like` = `comment`.`like` + 1 where id = #{commentId} ")
    void decreaseLike(int commentId);

    @Update("update comment set comment_count = comment_count + 1 where id = #{commentId} ")
    void increaseCommentCount(int commentId);

    @Update("update comment set comment_count = comment_count - 1 where id = #{commentId} ")
    void decreaseCommentCount(int commentId);
}