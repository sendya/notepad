package com.loacg.notepad.dao;

import com.loacg.notepad.entity.User;

import java.util.Map;

/**
 * notepad
 * Date: 1/18/2016
 * Author: Sendya <yinliangliang@rd.keytop.com.cn>
 */

@MyBatisRepository
public interface UserDao {

    /**
     * 根据用户名密码查询用户信息
     *
     * @param params
     * @return
     */
    public User getUserByLoginNamePsd(Map<String, Object> params);

    public User getUserByLoginName(String loginName);

    public void updatePassword(User user);

}
