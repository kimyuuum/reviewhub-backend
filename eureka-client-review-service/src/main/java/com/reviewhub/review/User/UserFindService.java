package com.reviewhub.review.User;

import org.springframework.stereotype.Service;

@Service
public class UserFindService {

    private final UserRepository userRepository;
    private User catchUser = null;

    public UserFindService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User currentUser(User loginUser){
        catchUser = userRepository.findByGithub(loginUser.getGithub());
        return catchUser;
    }

    public User sendUser(){
        return catchUser;
    }
}
