package top.ridm.maoni.model.DTO;


import lombok.Data;
import top.ridm.maoni.enums.CommentTypeEnum;

@Data
public class CommentDTO {
    private String content;
    private Integer parentId;
    private short type;
}
