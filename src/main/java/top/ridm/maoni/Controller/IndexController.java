package top.ridm.maoni.Controller;


import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ridm.maoni.DAO.PostDAO;
import top.ridm.maoni.model.VO.PostPaginationVO;
import top.ridm.maoni.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {


    @Autowired
    private PostService postService;

    @Autowired
    PostDAO postDAO;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model, @RequestParam(defaultValue = "1")int page){
        PageHelper.startPage(page,10);
        PostPaginationVO res = postService.list();
        model.addAttribute("pagination",res);
        return "index";
    }

    @GetMapping("/a")
    @ResponseBody
    public String a(){
        for(int i = 0; i < 1000;i++){
            new Thread(()->postService.increaseCommentCountById(6)).start();
        }
        return "";
    }


}
