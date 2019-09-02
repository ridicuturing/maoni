package top.ridm.maoni.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import top.ridm.maoni.Common.Common;
import top.ridm.maoni.DAO.PostDAO;
import top.ridm.maoni.model.VO.PostPaginationVO;

import java.util.Arrays;

@Service
public class SearchService {

    @Autowired
    PostDAO postDAO;

    public PostPaginationVO list(String keys) {
        String regex = ".*" + Arrays.asList(keys.split(" ")).stream().reduce((a,s)->a+".*"+s).get() + ".*";
        return Common.translatePagination(postDAO.search(regex));
    }
}
