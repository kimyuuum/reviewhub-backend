package com.reviewhub.review.Post.Service;

import com.reviewhub.review.Post.Post;
import com.reviewhub.review.Post.PostDto;
import com.reviewhub.review.Post.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostUpdateService {

    private final PostRepository postRepository;

    public PostUpdateService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Post update(PostDto.Request dto) {
        Post post = postRepository.findByIdx(dto.getIdx());
        post.update(dto);
        return post;
    }

}
