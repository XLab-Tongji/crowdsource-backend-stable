package com.crazy.mapper;

import com.crazy.entity.AccountLogin;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by SHIKUN on 2016/9/30.
 */
@Mapper
public interface AccountMapper {

    @Insert("INSERT INTO ACCOUNT (username,name,icon,password,mobile,create_time,update_time,email,ext_params) VALUES" +
            " (#{username},#{name},#{icon},#{password},#{mobile},NOW(),NOW(),#{email},#{ext_params})")
    int addAcount(@Param("username") String username, @Param("name") String name, @Param("icon") String icon,
                  @Param("password") String password, @Param("mobile") String mobile,
                  @Param("email") String email, @Param("ext_params") String ext_params);


    @Select("SELECT username FROM ACCOUNT")
    List<String> getAllUsername();

    @Select("SELECT account_id FROM ACCOUNT WHERE username=#{username}")
    Long getUserId(@Param("username") String username);


    @Select("SELECT username,password FROM ACCOUNT")
    List<String> getNameAndPassword();

    @Select("SELECT username,password FROM ACCOUNT WHERE username=#{username}")
    Map<String, String> getCheckInfo(@Param("username") String username);

    @Select("SELECT mobile,email FROM ACCOUNT WHERE username=#{username}")
    Map<String, String> getContactByName(@Param("username") String username);

    @Insert("INSERT INTO ACCOUNT_LOGIN_LOG (ip,token,create_time,expire_time,account_id,plat,username) VALUES " +
            "(#{ip},#{token},#{create_time},#{expire_time},#{account_id},#{plat},#{username})")
    int addLoginLog(@Param("ip") String ip, @Param("token") String token, @Param("create_time") Date create_time,
                    @Param("expire_time") Date expire_time, @Param("account_id") Long account_id,
                    @Param("plat") String plat, @Param("username") String username);

    @Select("SELECT id,expire_time,account_id FROM ACCOUNT_LOGIN_LOG WHERE token=#{token}")
    AccountLogin getTokenInfo(@Param("token") String token);

    @Update("UPDATE ACCOUNT_LOGIN_LOG SET token=#{token}, create_time=#{create_time},expire_time=#{expire_time} WHERE id=#{id}")
    int updateToken(@Param("token") String token, @Param("create_time") Date create_time, @Param("expire_time") Date expire_time,
                    @Param("id") Long id);

    @Insert("INSERT DEVELOPER (username,account_id,dev_domain,dev_intro,ext_param,enroll_date) VALUES (" +
            "#{username},#{account_id},#{dev_domain},#{dev_intro},#{ext_param},NOW())")
    int addDevInfo(@Param("username") String username, @Param("account_id") Long account_id, @Param("dev_domain") String dev_domain,
                   @Param("dev_intro") String dev_intro, @Param("ext_param") String ext_param);

    @Update("UPDATE DEVELOPER SET dev_domain=#{dev_domain} WHERE username=#{username}")
    int updateDevInfo(@Param("dev_domain") String dev_domain, @Param("username") String username);

    @Update("UPDATE DEVELOPER SET dev_intro=#{dev_intro} WHERE username=#{username}")
    int updateDevproject(@Param("dev_intro") String dev_intro, @Param("username") String username);


    @Update("UPDATE ACCOUNT SET dev_id=#{dev_id} WHERE username=#{username}")
    int changeDevStatus(@Param("dev_id") Long dev_id, @Param("username") String username);

    @Select("SELECT dev_id FROM DEVELOPER WHERE username=#{username}")
    Long getDevloperId(@Param("username") String username);

    @Select("SELECT dev_domain,dev_intro,ext_param  FROM DEVELOPER WHERE username=#{username}")
    Map<String, String> getDeveloperByName(@Param("username") String username);


}

