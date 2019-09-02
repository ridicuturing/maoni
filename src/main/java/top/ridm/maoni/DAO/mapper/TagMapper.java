package top.ridm.maoni.DAO.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import top.ridm.maoni.model.DO.TagDO;

import java.util.List;

@Mapper
public interface TagMapper {

    @Options(useGeneratedKeys=true,keyProperty = "id")
    @Insert("insert into tag (tag,user_id) value (#{tag},#{userId})")
    int insert(TagDO tag);

    @Select("SELECT tag.id,tag FROM post_tag LEFT JOIN `tag` on tag_id = id where post_id=#{postId}")
    List<TagDO> selectTagsListByPostId(int postId);
}
