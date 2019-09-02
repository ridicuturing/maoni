package top.ridm.maoni.service;


import com.github.pagehelper.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.ridm.maoni.Common.Common;
import top.ridm.maoni.DAO.PostDAO;
import top.ridm.maoni.model.DO.PostDO;
import top.ridm.maoni.model.DO.TagDO;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.VO.PostVO;
import top.ridm.maoni.model.VO.PostPaginationVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    PostDAO postDAO;

    @Autowired
    TagService tagService;

    @Value("${maoni.defaultAvatarUrl}")
    private String defaultAvatarUrl;

    public List<PostVO> listRelated(int id, List<TagDO> tags) {
        int postsMaxLength = 10;
        if(tags == null || tags.size()==0){
            return null;
        }
        List<Integer> l = tags.stream().map(TagDO::getId).collect(Collectors.toList());
        return postDAO.listRelated(id,l);
    }

    public PostPaginationVO list(){
        return Common.translatePagination(postDAO.list());
    }

    public PostPaginationVO myPost(int userId){
        return Common.translatePagination(postDAO.myPost(userId));
    }



    public PostVO getVOById(int id){
        PostVO post = postDAO.selectByPrimaryKey(id);
        if(post != null){
            List<TagDO> list = tagService.listPostTags(id);
            if(list != null && list.size() > 0) {
                post.setTags(list.stream().map(TagDO::getTag).reduce((a, s) -> a + "," + s).get());
            }
        }
        return post;
    }

    public void addPostView(int id){
        postDAO.addPostView(id);
    }


    //return post id
    public int newPost(UserDO user, String title, String description, String tags) {
        PostDO post = new PostDO();
        post.setTitle(title);
        post.setDescription(description);
        post.setUserId(user.getId());
        postDAO.insert(post);
        tagService.deals(post.getId(),tags);
        return post.getId();
    }

    public boolean updatePost(UserDO user, int postId, String title, String description, String tags, String oldTags) {
        if(user.getId() != postDAO.getCreatorIdByPostId(postId)){
            return false;
        }
        PostDO post = new PostDO();
        post.setId(postId);
        post.setTitle(title);
        post.setDescription(description);
        postDAO.updatePost(post);
        tagService.deals(post.getId(),tags,oldTags);
        return true;
    }

    public void increaseCommentCountById(Integer id) {
        postDAO.increaseCommentCount(id);
    }
    public void decreaseCommentCountById(Integer id) {
        postDAO.decreaseCommentCount(id);
    }

}
