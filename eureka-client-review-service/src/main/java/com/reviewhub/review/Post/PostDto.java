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

        @JsonProperty
        private String name;

        public Post toEntity() {
            return Post.builder()
                    .repositoryInfo(repositoryInfo)
                    .language(language)
                    .content(content)
                    .name(name)
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

        @JsonProperty
        private String name;

        public Response(Post post) {
            idx = post.getIdx();
            repositoryInfo = post.getRepositoryInfo();
            language = post.getLanguage();
            content = post.getContent();
            name = post.getName();
        }
    }

}
