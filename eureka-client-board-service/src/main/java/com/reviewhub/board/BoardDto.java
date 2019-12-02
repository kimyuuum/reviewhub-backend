package com.reviewhub.board;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class BoardDto {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Request{

        @JsonProperty
        private Long idx;

        @JsonProperty
        private String title;

        @JsonProperty
        private String content;

        @JsonProperty("user_name")
        private String userName;

        public Board toEntity(){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .userName(userName)
                    .build();
        }
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Response{

        @JsonProperty
        private Long idx;

        @JsonProperty
        private String title;

        @JsonProperty
        private String content;

        @JsonProperty("user_name")
        private String userName;

        public Response(Board board){
            this.idx = board.getIdx();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.userName = board.getUserName();
        }
    }

}
