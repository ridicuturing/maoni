package top.ridm.maoni.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.ridm.maoni.Common.Common;
import top.ridm.maoni.DAO.mapper.TagDOMapper;
import top.ridm.maoni.DAO.mapper.TagMapper;
import top.ridm.maoni.model.DO.TagDO;
import top.ridm.maoni.model.DO.TagDOExample;

import java.util.List;

@Repository
public class TagDAO {

    @Autowired
    TagDOMapper tagDOMapper;

    @Autowired
    TagMapper tagMapper;

    public TagDO getTag(String tag) {
        TagDOExample example = new TagDOExample();
        example.createCriteria().andTagEqualTo(tag);
        List<TagDO> list = tagDOMapper.selectByExample(example);
        return Common.getOneFromList(list);
    }

    public Integer insert(String tag, Integer id) {
        TagDO record = new TagDO();
        record.setUserId(id);
        record.setTag(tag);
        tagMapper.insert(record);
        return record.getId();
    }

    public List<TagDO> list(int postId) {
        return tagMapper.selectTagsListByPostId(postId);
    }


}
