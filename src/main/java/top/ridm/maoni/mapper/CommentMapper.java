package top.ridm.maoni.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.ridm.maoni.model.DO.CommentDO;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment (parent_id,type,like,commentator) values (#{parentId},#{type},#{like},#{commentator})")
    void insert(CommentDO comment);

    @Select("select * from comment where parent_id=#{parentId}")
    List<CommentDO> getCommentByParentId(int parentId);
}
