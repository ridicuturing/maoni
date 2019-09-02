package top.ridm.maoni.model.VO;

import lombok.Data;
import org.springframework.util.DigestUtils;
import top.ridm.maoni.Common.Common;
import top.ridm.maoni.model.DO.CommentDO;

import java.sql.Date;

@Data
public class CommentVO extends CommentDO {
    private Integer commentId;
    private Integer userId;
    private String avatarUrl;
    private String username;
    private String content;
    private Date createTime;
    private Integer liked;

    public String getUsername(){
        return DigestUtils.md5DigestAsHex((getUserId() + " " + getParentId()).getBytes());
    }

    public String getAvatarUrl(){
        if(avatarUrl == null){
            return Common.defaultAvatarUrl;
        }
        return avatarUrl;
    }
}
