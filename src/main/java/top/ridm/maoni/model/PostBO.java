package top.ridm.maoni.model;

import lombok.Data;
import top.ridm.maoni.model.DO.PostDO;

@Data
public class PostBO extends PostDO {
    private String userAvatarUrl;
}
