package com.reviewhub.review.Post;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "repository_info")
    private String repositoryInfo;

    private String language;

    private String content;
    
    @Column(name = "user_idx")
    private Long userIdx;
    
    private String title;
    

    public void update(PostDto.Request dto) {
        this.repositoryInfo = dto.getRepositoryInfo();
        this.language = dto.getLanguage();
        this.content = dto.getContent();
        this.userIdx = dto.getUserIdx();
        this.title = dto.getTitle();
    }


}
