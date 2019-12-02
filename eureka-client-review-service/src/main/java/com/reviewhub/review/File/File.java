package com.reviewhub.review.File;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.reviewhub.review.Post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "post_idx")
    private Long postIdx;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "branch_info")
    private String branchInfo;

    public void update(FileDto.Request dto){
        this.fileName = dto.getFileName();
        this.branchInfo = dto.getBranchInfo();
    }

}
