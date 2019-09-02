package top.ridm.maoni.model.VO;

import lombok.Data;

import java.sql.Date;

@Data
public class PostVO  {
    private int id;
    private String title;
    private String description;
    private int userId;
    private int pageviews;
    private int like;
    private String commentCount;
    private String tags;
    private String avatarUrl;
    private String username;
    private Date createTime;
    private Date updateTime;
}
