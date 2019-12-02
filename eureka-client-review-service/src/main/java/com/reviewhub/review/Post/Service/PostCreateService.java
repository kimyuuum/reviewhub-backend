package com.reviewhub.review.Post.Service;

import com.reviewhub.review.Post.Post;
import com.reviewhub.review.Post.PostDto;
import com.reviewhub.review.Post.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostCreateService {

    private final PostRepository postRepository;

    public PostCreateService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post create(PostDto.Request dto) {
        return postRepository.save(dto.toEntity());
    }

}
