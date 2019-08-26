package top.ridm.maoni.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import top.ridm.maoni.model.DO.PostDO;
import top.ridm.maoni.model.VO.PostVO;

@Mapper
public interface PostMapper {

    @Insert("insert into post (title,description,createBy,tags) values (#{title},#{description},#{createBy},#{tags})")
    void insert(PostDO post);

    @Select("select * from post")
    Page<PostDO> list();

    @Insert("INSERT INTO post (TITLE,description) values ('s','s')")
    void ainsert();

    @Select("select post.*,username,avatar_url from user,post where create_by = #{userId} and userId = #{userId}")
    Page<PostDO> myPost(int userId);

    @Select("select post.*,username,avatar_url from user,post where post.id=#{id} and create_by = user.id ")
    PostVO getVOById(int id);

    @Select("select * from post where id=#{id}")
    PostDO getDOById(int id);

    @Update("update post set pageviews = pageviews+1 where id = #{id}")
    void addPostView(int id);

    @Select("select * from post where id=#{id} and createBy=#{userId}")
    boolean isMyPost(@Param("id") int id, @Param("userId")int userId);

    @Update("update post set title=#{title}, description=#{description}, tags=#{tags} where id=#{id}")
    void updatePublic(PostDO post);
}