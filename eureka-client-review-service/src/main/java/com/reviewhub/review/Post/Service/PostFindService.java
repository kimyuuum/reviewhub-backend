package com.reviewhub.review.Post.Service;

import com.reviewhub.review.Exception.NotFoundException;
import com.reviewhub.review.Post.Post;
import com.reviewhub.review.Post.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostFindService {

    private final PostRepository postRepository;


    public PostFindService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findPost(Long idx) {
        return Optional.ofNullable(postRepository.findByIdx(idx))
                .orElseThrow(() -> new NotFoundException("Can not found posts"));
    }

}
