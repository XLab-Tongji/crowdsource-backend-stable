package com.crazy.service;
import com.crazy.entity.Account;
import javax.servlet.http.HttpServletRequest;


import com.crazy.entity.Account;
import com.crazy.util.ResJsonTemplate;

import javax.servlet.http.HttpServletRequest;

/**用户服务
 * Created by SHIKUN on 2016/10/29.
 */
public interface AccountService {

    //注册用户
    public ResJsonTemplate addAccount(Account account);

    //用户登录
    public ResJsonTemplate checkAccount(Account account, String useragent, HttpServletRequest request);




}

