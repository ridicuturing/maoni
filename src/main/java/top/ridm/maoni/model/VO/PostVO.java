package top.ridm.maoni.model.VO;

import lombok.Data;
import top.ridm.maoni.model.DO.BaseDO;

import java.sql.Date;

@Data
public class PostVO extends BaseDO {
    private int id;
    private String title;
    private String description;
    private int createBy;
    private int pageviews;
    private int like;
    private String commentCount;
    private String tags;
    private String avatarUrl;
    private String username;
}
