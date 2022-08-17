package com.springboot.sessionmanagement.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@SuppressWarnings("unchecked")
@Controller
public class SessionController {

    private static final Logger log = LoggerFactory.getLogger(SessionController.class);
    private static final String usrname="trash";
    private static final String pwd="trash";
    @GetMapping(value = "/index")
    public String home(final Model model, final HttpSession session) {        
        return "home";      
    }

    @PostMapping(value = "/user")
    public String saveNote(@RequestParam("username") final String username, @RequestParam("password") final String password, final HttpServletRequest request) {
        if(usrname.equals(username) && pwd.equals(password) ) {
            request.getSession().invalidate();
            HttpSession newSession = request.getSession();
            return "profile";
        }
        return "redirect:/index";
    }

    @PostMapping(value = "/destroy/session")
    public String destroySession(final HttpServletRequest request) {
        log.info("Invaliding the session and removing the data.");
        // Invalidate the session and this will clear the data from the database.
        request.getSession().invalidate();
        return "redirect:/index";
    }
}
