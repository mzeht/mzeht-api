/*
* Copyright (c) 2017 mzeht. All Rights Reserved.
*/
package com.wpmac.mzehtapi.api.response;

import java.io.Serializable;

/**
 * @author: wpmac  Date: 2017/1/17 Time: 下午3:27
 */
public class UserBean implements Serializable {

    private static final long serialVersionUID = -4562877327172131185L;
    private String email;
    private String phoneNumber;
    private Long userId;
    private String userName;
    private boolean isExist;
    private Long merchantId;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}