package service;

import entity.User;

import javax.servlet.http.HttpSession;

public class AuthService {

    public User loginUser(User user, HttpSession session) throws Exception {
        if ("jon@doe.com".equals(user.getEmail()) == false) {
            throw new Exception("Email does not exist!");

        }
        if ("1234ss".equals(user.getPassword()) == false) {
            throw new Exception("Password didn't match");
        }

        session.setAttribute("user", user);
        return user;

    }
}
