package com.reviewhub.review.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController {

    private final UserFindService userFindService;

    public UserController(UserFindService userFindService) {
        this.userFindService = userFindService;
    }

    @RequestMapping("")
    void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8080");
    }

    @GetMapping("/info")
    public User sendUserInfo(){
        return userFindService.sendUser();
    }

}
