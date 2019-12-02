package com.reviewhub.review.Comment;

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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "post_idx")
    private Long postIdx;

    @Column
    private String content;

    @Column(name = "user_name")
    private String userName;

    public void update(CommentDto.Request dto){
        this.content = dto.getContent();
        this.userName = dto.getUserName();
    }

}
