package top.ridm.maoni.service;


import com.github.pagehelper.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.ridm.maoni.mapper.PostMapper;
import top.ridm.maoni.mapper.UserMapper;
import top.ridm.maoni.model.DO.PostDO;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.VO.PostVO;
import top.ridm.maoni.model.VO.PostPaginationVO;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;

    @Value("${maoni.defaultAvatarUrl}")
    private String defaultAvatarUrl;

    public PostPaginationVO list(){
        Page<PostDO> DOlist = postMapper.list();
        return translatePagination(DOlist);
    }

    public PostPaginationVO myPost(int userId){
        return translatePagination(postMapper.myPost(userId));
    }

    public PostPaginationVO translatePagination(Page<PostDO> DOlist){
        List<PostVO> VOlist = new ArrayList<>(DOlist.size());
        for(PostDO DO :DOlist){
            PostVO VO = new PostVO();
            if(VO.getAvatarUrl() == null){
                VO.setAvatarUrl(defaultAvatarUrl);
            }
            BeanUtils.copyProperties(DO,VO);
            VOlist.add(VO);
        }
        PostPaginationVO res = new PostPaginationVO(VOlist,DOlist.getPageNum(),DOlist.getPages());
        return res;
    }

    public PostVO getVOById(int id){
        return postMapper.getVOById(id);
    }

    public void addPostView(int id){
        postMapper.addPostView(id);
    }

    public boolean isMyPost(int id, int userId) {
        return postMapper.isMyPost(id,userId);
    }

    public void newPost(UserDO user, int id, String title, String description, String tags) {
        PostDO post = new PostDO();
        post.setTitle(title);
        post.setDescription(description);
        post.setTags(tags);
        post.setCreateBy(user.getId());
        postMapper.insert(post);
    }

    public boolean modifiedPost(UserDO user, int id, String title, String description, String tags) {
        PostDO post = postMapper.getDOById(id);
        if(user.getId() !=post.getCreateBy()){
            return false;
        }
        post.setTitle(title);
        post.setDescription(description);
        post.setTags(tags);
        postMapper.updatePublic(post);
        return true;
    }
}
