package org.wecancodeit.reviews.Storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.CommentRepository;
import org.wecancodeit.reviews.Models.Comment;

@Service
public class CommentStorage {
    private final CommentRepository commentRepo;

    @Autowired
    public CommentStorage(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    public void addComment(Comment inComment){
        commentRepo.save(inComment);
    }

    public Iterable<Comment> retrieveAllComments(){
        return commentRepo.findAll();
    }

    public Comment retrieveAllCommentsById(Long id) {
        return commentRepo.findById(id).get();
    }
}
