package top.ridm.maoni.Controller;


import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.ridm.maoni.model.VO.PostPaginationVO;
import top.ridm.maoni.service.SearchService;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public String search(String keys,Model model,int page){
        PageHelper.startPage(page,10);
        PostPaginationVO res = searchService.list(keys);
        model.addAttribute("pagination",res);
        return "index";
    }
}
