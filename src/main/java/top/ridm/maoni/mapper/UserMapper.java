package top.ridm.maoni.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.ridm.maoni.model.DO.UserDO;

@Mapper
public interface UserMapper {

    @Select("select * from user where token = #{token}")
    UserDO getUserByToken(String token);

    @Select("select * from user where account = #{account} and password = #{password}")
    UserDO checkUser(@Param("account")String account, @Param("password")String password);

    @Insert("update user set token=#{token} where id = #{userId}")
    void addUserToken(@Param("userId")int userId,@Param("token")String token);

    @Select("select * from user where token=#{token}")
    UserDO findUserByToken(String token);

    @Select("select avatarUrl from user where id = #{userId}")
    String getAvatarUrlByUserId(int userId);

}
