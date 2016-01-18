package com.loacg.notepad.controller;

import com.loacg.notepad.entity.Response;
import com.loacg.notepad.entity.User;
import com.loacg.notepad.service.UserService;
import com.loacg.notepad.utils.UUIDUtil;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * notepad
 *
 * User Action
 *
 *  status
 *      -2 : username or password error
 *      -1 : server error
 *      1  : login success
 *      0  : unknown error
 *
 * Date: 1/18/2016
 * Author: Sendya <yinliangliang@rd.keytop.com.cn>
 */

@Controller
@RequestMapping("/user")
public class UserAction {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Response login(HttpServletRequest request,
                          HttpServletResponse response) {
        Response message = new Response();
        message.setStatus(-2);
        message.setMessage("Wrong ! username or password");

        String auth = request.getHeader("Authorization");

        User loginUser = new User();
        try {
            if(!StringUtils.isNullOrEmpty(auth)) {
                String auths[] = auth.split(" ");
                if (auths.length == 2) {
                    // Send text exp:  UserName:PassWord
                    String dec[] = new String(Base64.decodeBase64(auths[1].getBytes("utf-8"))).split(":");
                    if (dec.length == 2) {
                        loginUser = userService.getUserByLoginNamePsd(dec[0],
                                dec[1]);
                        if (loginUser != null) {
                            message.setStatus(1);
                            message.setResource(loginUser);
                            message.setMessage("Login success");
                        }
                    }
                }
            }
            String token = UUIDUtil.getUId(); // create login token
            request.getSession().setAttribute("token", token);
            response.setHeader("Authorization", "Token " + token);

        } catch (Exception e) {
            e.printStackTrace();
            message.setMessage("Wrong ! login server");
            message.setStatus(-1);
        }
        return message;
    }

}
