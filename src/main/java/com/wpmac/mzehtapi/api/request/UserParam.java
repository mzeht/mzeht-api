/*
* Copyright (c) 2017 mzeht. All Rights Reserved.
*/
package com.wpmac.mzehtapi.api.request;

/**
 * @author: wpmac  Date: 2017/1/17 Time: 上午10:46
 */
public class UserParam {

    private String companyName;	//公司名称	string
    private String emailAddress;    //邮箱地址	string
    private String password; //登录密码;	string
    private String phoneNumber;	//手机号码	string
    private String verificationCode;	//验证码
    private String confirmPassword;//确认密码

    /**
     * 极验证参数
     */
    private String challenge;
    /**
     * 极验证参数
     */
    private String validate;
    /**
     * 极验证参数
     */
    private String seccode;
    /**
     * 跳转URL
     */
    private String returnURL;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getSeccode() {
        return seccode;
    }

    public void setSeccode(String seccode) {
        this.seccode = seccode;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}