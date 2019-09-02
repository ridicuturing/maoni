package top.ridm.maoni.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.ridm.maoni.Common.Common;
import top.ridm.maoni.DAO.mapper.CommentDOMapper;
import top.ridm.maoni.DAO.mapper.UserDOMapper;
import top.ridm.maoni.model.DO.CommentDO;
import top.ridm.maoni.model.DO.CommentDOExample;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.DO.UserDOExample;

import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private UserDOMapper userDOMapper;

    public UserDO findUserByToken(String token){
        UserDOExample example = new UserDOExample();
        example.createCriteria().andTokenEqualTo(token);
        List<UserDO> list = userDOMapper.selectByExample(example);
        return Common.getOneFromList(list);
    }

    public UserDO checkUser(String account, String password) {
        UserDOExample example = new UserDOExample();
        example.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
        return Common.getOneFromList(userDOMapper.selectByExample(example));
    }

    public void addUserToken(Integer id, String token) {
        UserDO user = new UserDO();
        user.setId(id);
        user.setToken(token);
        userDOMapper.updateByPrimaryKeySelective(user);
    }
}
