package top.ridm.maoni.DAO;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import top.ridm.maoni.DAO.mapper.PostDOMapper;
import top.ridm.maoni.DAO.mapper.PostMapper;
import top.ridm.maoni.model.DO.PostDO;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.PostBO;
import top.ridm.maoni.model.VO.PostVO;

import java.util.List;

@Repository
public class PostDAO {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostDOMapper postDOMapper;


    public Page<PostBO> list() {
        return postMapper.list();
    }

    public Page<PostBO> myPost(int userId) {
        return postMapper.myPost(userId);
    }

    public PostVO selectByPrimaryKey(int id) {
        return postMapper.selectVOById(id);
    }

    public void addPostView(int id) {
        postMapper.addPostView(id);
    }

    public int insert(PostDO post) {
        postMapper.insert(post);
        return post.getId();
    }

    public Integer getCreatorIdByPostId(int id) {
        return postMapper.getCreatorIdByPostId(id);
    }

    public void updatePost(PostDO post) {
        postDOMapper.updateByPrimaryKeySelective(post);
    }

    public void increaseCommentCount(Integer id) {
        postMapper.increaseConmentCount(id);
    }
    public void decreaseCommentCount(Integer id) {
        postMapper.decreaseConmentCount(id);
    }

    public List<PostVO> listRelated(int id, List<Integer> tags) {
        String sqlList = "(" + tags.stream().map(e->e.toString()).reduce((a,s)->{return a+","+s;}).toString() + ")";
        return postMapper.listRelated(id,sqlList);
    }

    public Page<PostBO> search(String regex) {
        return postMapper.searchByRegex(regex);
    }
}
