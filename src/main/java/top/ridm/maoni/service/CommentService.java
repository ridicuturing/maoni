package top.ridm.maoni.service;


import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ridm.maoni.enums.CommentTypeEnum;
import top.ridm.maoni.mapper.CommentMapper;
import top.ridm.maoni.model.DO.BaseDO;
import top.ridm.maoni.model.DO.CommentDO;
import top.ridm.maoni.model.VO.CommentVO;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<CommentVO> getCommentByParentId(int parentId){
        List<CommentDO> DOs = commentMapper.getCommentByParentId(parentId);
        List<CommentVO> res = new ArrayList<>(DOs.size());
        CommentVO VO = null;
        for(CommentDO DO : DOs ){
            BeanUtils.copyProperties(DO,VO);
            res.add(VO);
        }
        res.sort(Comparator.comparing(BaseDO::getCreateTime));
        return res;
    }
}
