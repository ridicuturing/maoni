package top.ridm.maoni.DAO.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostTagMapper {

    @Select("SELECT tag FROM post_tag LEFT JOIN `tag` on tag_id = id where post_id=#{postId}")
    List<String> selectTagsListByPostId(int postId);
}
