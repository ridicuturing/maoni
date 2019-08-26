package top.ridm.maoni.model.DO;

import lombok.Data;

import java.sql.Date;

@Data
public class PostDO extends BaseDO{
    private String title;
    private String description;
    private int createBy;
    private int pageviews;
    private int like;
    private String commentCount;
    private String tags;

}
