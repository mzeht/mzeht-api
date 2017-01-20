/*
* Copyright (c) 2017 mzeht. All Rights Reserved.
*/
package com.wpmac.mzehtapi.api;

import com.wpmac.mzehtapi.api.base.ApiResult;
import com.wpmac.mzehtapi.api.request.UserParam;
import com.wpmac.mzehtapi.api.response.UserBean;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 用户相关
 * @author: wpmac  Date: 2017/1/17 Time: 上午10:08
 */
public interface CommonApi {
    //-----------------------------------用户服务------------------------------------------------
    /**
     * 用户注册
     * @param userParam
     * @return
     */
    @POST("/common/user/v1/register")
    Call<ApiResult> register(@Body UserParam userParam);

    /**
     * 用户信息
     * @param userParam
     * @return
     */
    @POST("/common/user/v1/info")
    Call<ApiResult<UserBean>> info(@Body UserParam userParam);

    /**
     * 用户登录
     * @param userParam
     * @return
     */
    @POST("common/user/v1/login")
    Call<ApiResult<UserBean>> login(@Body UserParam userParam);

    /**
     * 用户是否存在
     * @param userParam
     * @return
     */
    @POST("common/user/v1/isexist")
    Call<ApiResult<UserBean>> isexist(@Body UserParam userParam);

    /**
     * 忘记密码
     * @param userParam
     * @return
     */
    @POST("common/user/v1/resetps")
    Call<ApiResult> resetps(@Body UserParam userParam);


    //-----------------------------------短信服务------------------------------------------------
    /**
     * 注册验证码
     * @param userParam
     * @return
     */
    @POST("common/sms/v1/register/sendvcode")
    Call<ApiResult> vcodeOfRegister(@Body UserParam userParam);

    /**
     * 重置验证码
     * @param userParam
     * @return
     */
    @POST("common/sms/v1/resetps/sendvcode")
    Call<ApiResult> vcodeOfResetps(@Body UserParam userParam);


}