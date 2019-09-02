package top.ridm.maoni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ridm.maoni.DAO.UserDAO;
import top.ridm.maoni.DAO.mapper.UserDOMapper;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.DO.UserDOExample;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDO findUserByToken(String token) {
        return userDAO.findUserByToken(token);
    }

    public UserDO checkUser(String account, String password) {
        return userDAO.checkUser(account,password);
    }

    public void addUserToken(Integer id, String token) {
        userDAO.addUserToken(id,token);
    }
}
