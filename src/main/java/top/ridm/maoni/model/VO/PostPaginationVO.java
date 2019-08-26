package top.ridm.maoni.model.VO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class PostPaginationVO {
    private List<PostVO> posts;
    private boolean showFirstPage;
    private boolean showPrevious;
    private boolean showNext;
    private boolean showEndPage;
    private int page;
    private List<Integer> pages = new ArrayList<>();
    private int totalPage;
    static int showPageLength = 7;

    public PostPaginationVO(List<PostVO> posts, int page, int totalPage){
        this.posts = posts;
        this.page = page;
        this.totalPage = totalPage;
        showFirstPage = page > ( showPageLength / 2 ) ? true : false;
        showPrevious  = page > 1;
        showNext = page < totalPage;
        showEndPage = ( totalPage - page ) > ( showPageLength / 2 ) ? true : false;
        for(int i = 0; i < showPageLength; i++ ){
            int index = i + page - ( showPageLength / 2 );
            if(index > 0 && index <= totalPage) {
                pages.add(index);
            }
        }
    }
}
