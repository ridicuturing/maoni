package top.ridm.maoni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ridm.maoni.DAO.LikedDAO;

@Service
public class LikedService {

    @Autowired
    private LikedDAO likedDAO;

    @Autowired
    CommentService commentService;

    public void like(Integer userId, int commentId) {
        likedDAO.like(userId,commentId);
        commentService.increaseLike(commentId);
    }

    public void unlike(Integer userId, int commentId) {
        likedDAO.unlike(userId,commentId);
        commentService.decreaseLike(commentId);
    }
}
