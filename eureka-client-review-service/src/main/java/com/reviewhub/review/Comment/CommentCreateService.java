package com.reviewhub.review.Comment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentCreateService {

    private final CommentRepository commentRepository;

    public CommentCreateService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment create(CommentDto.Request dto){
        return commentRepository.save(dto.toEntity());
    }

    public List<Comment> findAllComment(Long postIdx){
        return commentRepository.findByPostIdx(postIdx);
    }


}
