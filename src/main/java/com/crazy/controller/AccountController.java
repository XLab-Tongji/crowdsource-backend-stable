package com.crazy.controller;

import com.crazy.entity.Developer;
import com.crazy.mapper.AccountMapper;
import com.crazy.entity.Account;

import com.crazy.service.AccountService;
import com.crazy.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**Account Controller
 * Created by SHIKUN on 2016/9/30.
 */

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @Autowired
    private Encryption encryption;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResJsonTemplate addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @RequestMapping(value = "/developer", method = RequestMethod.POST)
    @ResponseBody
    public ResJsonTemplate addDeveloper(@RequestBody Developer developer) {
        return accountService.addDeveloper(developer);
    }

    @RequestMapping(value = "/developer/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResJsonTemplate getDeveloperByName(@PathVariable String name) {
        return accountService.getDeveloperByName(name);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public  ResJsonTemplate checkAccount(@RequestBody Account account, @RequestHeader(value = "User-Agent") String useragent,
                                 HttpServletRequest request) {

        return accountService.checkAccount(account, useragent, request);
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResJsonTemplate getProjectEnrollcount(@PathVariable String name) {
        return accountService.getUserIdByName(name);

    }

    @RequestMapping(value = "/contact/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResJsonTemplate getContactByName(@PathVariable String name) {
        return accountService.getContactByName(name);

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestParam(value = "token") String token) {
        return encryption.tokenValidate(token);
    }






}
