package com.reviewhub.review.Post.Service;

import com.reviewhub.review.Post.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostDeleteService {

    private final PostRepository postRepository;

    public PostDeleteService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void delete(Long idx) {
        postRepository.deleteById(idx);
    }

}
