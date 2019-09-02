package top.ridm.maoni.enums;

/**
 * Created by codedrinker on 2019/5/31.
 */
public enum CommentTypeEnum {
    POST((short)1),
    COMMENT((short)2);
    private short type;


    public short getType() {
        return type;
    }

    CommentTypeEnum(short type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
