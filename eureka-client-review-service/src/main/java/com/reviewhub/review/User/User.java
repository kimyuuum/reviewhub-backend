package com.reviewhub.review.User;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.reviewhub.review.Post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idx;

    private String email;

    private String name;

    private String github;

    @Column(name = "avatar_url")
    private String avatarUrl;

    public User(String email, String name, String githubLogin, String avatar) {
        this.email = email;
        this.name = name;
        this.github = githubLogin;
        this.avatarUrl = avatar;
    }

//    @OneToMany(mappedBy = "user")
//    private List<Comment> commentList = new ArrayList<>();

}