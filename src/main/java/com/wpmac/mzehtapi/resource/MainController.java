package com.wpmac.mzehtapi.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/9/22.
 */
@RestController
@RequestMapping("/mvc")
public class MainController {

    private final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/listActionLog", method = RequestMethod.GET)
    public String hello() {
        return "list_action_log";
    }

    /**
     * 登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "login";
    }

    /**
     * 后台主页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        System.out.println("home");
        return "home";
    }
    /**
     *
     */

}
