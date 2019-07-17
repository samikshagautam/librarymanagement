package service;

import entity.User;

import javax.servlet.http.HttpSession;

public class AuthService {

    public User loginUser(User user, HttpSession session) throws Exception {
        if (user.getEmail().equals("jon@doe.com") == false) {
            throw new Exception("Email does not exist!");

        }
        if (user.getPassword().equals("1234ss") == false) {
            throw new Exception("Password didn't match");
        }

        session.setAttribute("user", user);
        return user;

    }
}
