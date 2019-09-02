package top.ridm.maoni.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.ridm.maoni.Common.Common;
import top.ridm.maoni.DAO.mapper.PostTagDOMapper;
import top.ridm.maoni.DAO.mapper.PostTagMapper;
import top.ridm.maoni.DAO.mapper.TagDOMapper;
import top.ridm.maoni.model.DO.PostTagDO;
import top.ridm.maoni.model.DO.PostTagDOExample;
import top.ridm.maoni.model.DO.TagDO;
import top.ridm.maoni.model.DO.TagDOExample;

import java.sql.Array;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PostTagDAO {

    @Autowired
    PostTagDOMapper postTagDOMapper;

    @Autowired
    PostTagMapper postTagMapper;

    @Autowired
    TagDOMapper tagDOMapper;

    //@return: 0 fail,1 success
    public int insert(int commentId, TagDO t) {
        return insert(commentId,t.getId().intValue());
    }

    //@return: 0 fail,1 success
    public int insert(int commentId, int tagId) {
        PostTagDO record = new PostTagDO();
        record.setPostId(commentId);
        record.setTagId(tagId);
        try {
            return postTagDOMapper.insertSelective(record);
        }catch (Exception e){
            return 0;
        }
    }

    public void deleteTags(Set<String> oldTags) {
        TagDOExample tags = new TagDOExample();
        tags.createCriteria().andTagIn(oldTags.stream().collect(Collectors.toList()));
        List<TagDO> taglist = tagDOMapper.selectByExample(tags);

        PostTagDOExample example = new PostTagDOExample();
        example.createCriteria().andTagIdIn(taglist.stream().map(TagDO::getId).collect(Collectors.toList()));
        postTagDOMapper.deleteByExample(example);
    }
}
