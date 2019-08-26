package top.ridm.maoni.model.DO;

import lombok.Data;

import java.sql.Date;

@Data
public class BaseDO {
    private int id;
    private Date createTime;
    private Date updateTime;
}
