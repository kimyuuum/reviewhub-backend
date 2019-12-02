package com.reviewhub.review.File;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class FileDto {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Request{

        @JsonProperty
        private Long idx;

        @JsonProperty("post_idx")
        private Long postIdx;

        @JsonProperty("file_name")
        private String fileName;

        @JsonProperty("branch_info")
        private String branchInfo;

        public File toEntity(){
            return File.builder()
                    .postIdx(postIdx)
                    .fileName(fileName)
                    .branchInfo(branchInfo)
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

        @JsonProperty("file_name")
        private String fileName;

        @JsonProperty("branch_info")
        private String branchInfo;

        public Response(File file){
            this.idx = file.getIdx();
            this.postIdx = file.getPostIdx();
            this.fileName = file.getFileName();
            this.branchInfo = file.getBranchInfo();
        }
    }

}
