package top.ridm.maoni.DAO.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import top.ridm.maoni.model.DO.PostDO;
import top.ridm.maoni.model.PostBO;
import top.ridm.maoni.model.VO.PostVO;

import java.util.List;

@Mapper
public interface PostMapper {

    @Options(useGeneratedKeys=true,keyProperty = "id")
    @Insert("insert into post (title,description,user_id) values (#{title},#{description},#{userId})")
    Integer insert(PostDO post);

    @Options(useGeneratedKeys=true,keyProperty = "id")
    @Insert("insert into post (title,description,user_id) values (#{title},#{description},#{userId})")
    Integer inserta(@Param("title") String title, @Param("description") String description, @Param("userId") int userId, @Param("tags") String tags);

    @Select("select post.*,avatar_url from post left join user on post.user_id = `user`.id order by update_time desc")
    Page<PostBO> list();

    @Insert("INSERT INTO post (TITLE,description) values ('s','s')")
    void ainsert();

    @Select("select post.*,username,avatar_url from post left join user on post.user_id = user.id where user.id = #{userId}")
    Page<PostBO> myPost(int userId);

    @Select("select post.*,username,avatar_url from user,post where post.id=#{id} and user_id = user.id ")
    PostVO selectVOById(int id);

    @Select("select * from post where id=#{id}")
    PostDO getDOById(int id);

    @Update("update post set pageviews = pageviews+1 where id = #{id}")
    void addPostView(int id);

    @Update("update post set title=#{title}, description=#{description}, tags=#{tags} where id=#{id}")
    void updatePublic(PostDO post);

    @Select("select user_id from post where id=#{id}")
    Integer getCreatorIdByPostId(int id);

    @Update("update post set comment_count = comment_count + 1 where id = #{id}")
    void increaseConmentCount(int id);

    @Update("update post set comment_count = comment_count - 1 where id = #{id}")
    void decreaseConmentCount(int id);

    @Select("SELECT post.id,post.title " +
            "FROM post_tag LEFT JOIN post on post.id = post_tag.post_id  and post_tag.tag_id in (1,2) " +
            "where post.user_id != 3 " +
            "limit 50 ")
    List<PostVO> listRelated(int id, String sqlList);


    @Select("SELECT post.*,avatar_url from post left join user on post.user_id = `user`.id where title REGEXP #{regex}")
    Page<PostBO> searchByRegex(String regex);

}