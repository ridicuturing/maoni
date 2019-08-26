package top.ridm.maoni.model.DO;


import lombok.Data;

@Data
public class UserDO extends BaseDO{
    private String account;
    private String password;
    private String username;
    private String token;
    private String avatarUrl;
}
