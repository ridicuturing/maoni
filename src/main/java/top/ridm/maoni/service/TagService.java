package top.ridm.maoni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ridm.maoni.Common.Common;
import top.ridm.maoni.DAO.PostTagDAO;
import top.ridm.maoni.DAO.TagDAO;
import top.ridm.maoni.model.DO.TagDO;

import java.util.*;

@Service
public class TagService {

    @Autowired
    TagDAO tagDAO;

    @Autowired
    PostTagDAO postTagDAO;

    public void deals(int commentId, String tagString, String oldTagString) {
        Set<String> tags = new HashSet<>(Arrays.asList(tagString.split(",")));
        for(String tag: tags) {
            deal(commentId, tag);
        }
        Set<String> oldTags = new HashSet<>(Arrays.asList(oldTagString.split(",")));
        if(oldTags == null){
            return;
        }
        oldTags.removeAll(tags);
        deleteTags(oldTags);

    }

    private void deleteTags(Set<String> oldTags) {
        if(oldTags == null || oldTags.size() == 0) {
            return;
        }
        postTagDAO.deleteTags(oldTags);
    }

    public void deals(int commentId, String tagString){
        deals(commentId,tagString,"");
    }

    public int deal(int commentId,String tag){
        TagDO t = tagDAO.getTag(tag);
        if(t != null){
            return postTagDAO.insert(commentId,t);
        }else{
            return createTag(commentId,tag);
        }
    }

    private int createTag(int commentId,String tag) {
        Integer id;
        if(isTagCreatable()){
            if((id = tagDAO.insert(tag,Common.getUser().getId())) != null){
                return postTagDAO.insert(commentId,id);
            }
        }
        return 0;
    }

    private boolean isTagCreatable() {
        if(Common.getUser() != null) {
            return true;
        }
        return false;
    }

    public List<TagDO> listPostTags(int postId){
        List<TagDO> tags = tagDAO.list(postId);
        return tags;
    }


}
