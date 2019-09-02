package top.ridm.maoni.Common;

import com.github.pagehelper.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.ridm.maoni.model.DO.PostDO;
import top.ridm.maoni.model.DO.UserDO;
import top.ridm.maoni.model.PostBO;
import top.ridm.maoni.model.VO.PostPaginationVO;
import top.ridm.maoni.model.VO.PostVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Common {

    public static String defaultAvatarUrl = "http://47.106.117.210/file/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180922223339.jpg";

    private static ThreadLocal user = new ThreadLocal();


    public static void setUser(UserDO user){
        Common.user.set(user);
    }

    public static UserDO getUser(){
        return (UserDO)Common.user.get();
    }

    public static <E> E getOneFromList(List<E> a){
        return (a == null || a.size() == 0)? null: a.get(0);
    }

    public static PostPaginationVO translatePagination(Page<PostBO> BOlist){
        List<PostVO> VOlist = new ArrayList<>(BOlist.size());
        for(PostBO BO :BOlist){
            PostVO VO = new PostVO();
            BeanUtils.copyProperties(BO,VO);
            if(VO.getAvatarUrl() == null){
                VO.setAvatarUrl(Common.defaultAvatarUrl);
            }
            VOlist.add(VO);
        }
        PostPaginationVO res = new PostPaginationVO(VOlist,BOlist.getPageNum(),BOlist.getPages());
        return res;
    }
}
