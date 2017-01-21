package com.wpmac.mzehtapi.resource;

import com.alibaba.druid.filter.config.ConfigTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/9/22.
 */
@RestController
@RequestMapping("/mvc")
public class MainController {

    private final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/listActionLog", method = RequestMethod.GET)
    public String hello() {


        //密码明文
        String password = "123456";
        System.out.println("密码[ "+password+" ]的加密信息如下：\n");

        String [] keyPair = new String[0];
        try {
            keyPair = ConfigTools.genKeyPair(512);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
//私钥
        String privateKey = keyPair[0];
//公钥
        String publicKey = keyPair[1];
//用私钥加密后的密文
        try {
            password = ConfigTools.encrypt(privateKey, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("privateKey:"+privateKey);
        System.out.println("publicKey:"+publicKey);
        System.out.println("password:"+password);
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
