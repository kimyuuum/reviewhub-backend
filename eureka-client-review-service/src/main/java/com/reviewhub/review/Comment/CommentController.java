package com.reviewhub.review.Comment;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentCreateService commentCreateService;

    public CommentController(CommentCreateService commentCreateService) {
        this.commentCreateService = commentCreateService;
    }

    @GetMapping("/{postIdx}")
    public List<CommentDto.Response> getCommentList(@PathVariable Long postIdx){
        return commentCreateService.findAllComment(postIdx)
                .stream()
                .map(CommentDto.Response::new)
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public CommentDto.Response create(@RequestBody CommentDto.Request dto){
        return new CommentDto.Response(commentCreateService.create(dto));
    }

}
