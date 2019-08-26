package top.ridm.maoni.model.DO;


import lombok.Data;

import java.sql.Date;

@Data
public class CommentDO extends BaseDO{
    private int parentCommentId;
    private int type;
    private int like;
    private int commentator;
    private int commentCount;
    private String content;

}
