package com.reviewhub.review.Post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class PostDto {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Request {

        @JsonProperty
        private Long idx;

        @JsonProperty("repository_info")
        private String repositoryInfo;

        @JsonProperty
        private String language;

        @JsonProperty
        private String content;

        @JsonProperty("user_idx")
        private Long userIdx;
        
        @JsonProperty
        private String title;

        public Post toEntity() {
            return Post.builder()
                    .repositoryInfo(repositoryInfo)
                    .language(language)
                    .content(content)
                    .userIdx(userIdx)
                    .title(title)
                    .build();
        }
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Response {

        @JsonProperty
        private Long idx;

        @JsonProperty("repository_info")
        private String repositoryInfo;

        @JsonProperty
        private String language;

        @JsonProperty
        private String content;

        @JsonProperty("user_idx")
        private Long userIdx;
        
        @JsonProperty
        private String title;

        public Response(Post post) {
            idx = post.getIdx();
            repositoryInfo = post.getRepositoryInfo();
            language = post.getLanguage();
            content = post.getContent();
            userIdx = post.getUserIdx();
            title = post.getTitle();
        }
    }

}
