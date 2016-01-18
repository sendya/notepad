package com.loacg.notepad.service;

import com.loacg.notepad.dao.UserDao;
import com.loacg.notepad.entity.User;
import com.loacg.notepad.utils.Md5Utils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * notepad
 * Date: 1/18/2016
 * Author: Sendya <yinliangliang@rd.keytop.com.cn>
 */
@Component("userService")
@Transactional
public class UserService {

    private static Logger logger = Logger.getLogger(UserService.class);

    @Resource(name = "userDao")
    private UserDao userDao;

    /**
     * 用户密码验证
     * @param loginName
     * @param pwd
     * @return User
     */
    public User getUserByLoginNamePsd(String loginName, String pwd) {
        Map<String, Object> param = new HashMap<String, Object>(); //封装dao层参数
        param.put("userName", loginName);
        param.put("passWord", Md5Utils.md5(pwd));
        logger.debug("验证用户 ["+param+"]");
        User nowUser = null;
        nowUser = userDao.getUserByLoginNamePsd(param);
        return nowUser;
    }

}
