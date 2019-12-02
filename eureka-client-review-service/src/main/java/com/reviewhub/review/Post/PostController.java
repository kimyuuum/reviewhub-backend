package com.reviewhub.review.Post;

import com.reviewhub.review.Post.Service.PostCreateService;
import com.reviewhub.review.Post.Service.PostDeleteService;
import com.reviewhub.review.Post.Service.PostFindService;
import com.reviewhub.review.Post.Service.PostUpdateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/post")
public class PostController {

    private final PostFindService postFindService;
    private final PostCreateService postCreateService;
    private final PostUpdateService postUpdateService;
    private final PostDeleteService postDeleteService;

    public PostController(PostFindService postFindService,
                          PostCreateService postCreateService,
                          PostUpdateService postUpdateService,
                          PostDeleteService postDeleteService) {
        this.postFindService = postFindService;
        this.postCreateService = postCreateService;
        this.postUpdateService = postUpdateService;
        this.postDeleteService = postDeleteService;
    }

    @GetMapping("")
    public List<PostDto.Response> findAllPosts() {
        return postFindService.findAll()
                .stream()
                .map(PostDto.Response::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{idx}")
    public PostDto.Response findPost(@PathVariable Long idx) {
        return new PostDto.Response(postFindService.findPost(idx));
    }

    @PostMapping("")
    public PostDto.Response createPost(@RequestBody PostDto.Request request) {
        return new PostDto.Response(postCreateService.create(request));
    }

    @PatchMapping("")
    public PostDto.Response updatePost(@RequestBody PostDto.Request request) {
        return new PostDto.Response(postUpdateService.update(request));
    }

    @DeleteMapping("/{idx}")
    public void deletePost(@PathVariable Long idx) {
        postDeleteService.delete(idx);
    }

}
