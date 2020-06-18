package com.reviewhub.review.Comment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class CommentDto {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Request{

        @JsonProperty
        private Long idx;

        @JsonProperty("post_idx")
        private Long postIdx;

        @JsonProperty
        private String content;

        @JsonProperty("user_idx")
        private Long userIdx;

        public Comment toEntity(){
            return Comment.builder()
                    .postIdx(postIdx)
                    .content(content)
                    .userIdx(userIdx)
                    .build();
        }
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Response{

        @JsonProperty
        private Long idx;

        @JsonProperty("post_idx")
        private Long postIdx;

        @JsonProperty
        private String content;

        @JsonProperty("user_idx")
        private Long userIdx;

        public Response(Comment comment){
            this.idx = comment.getIdx();
            this.postIdx = comment.getPostIdx();
            this.content = comment.getContent();
            this.userIdx = comment.getUserIdx();
        }
    }

}
