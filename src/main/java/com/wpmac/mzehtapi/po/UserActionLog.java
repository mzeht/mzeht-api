package com.wpmac.mzehtapi.po;

import java.io.Serializable;
import java.sql.Date;


public class UserActionLog implements Serializable {

    private long id;
    private String loginId, sessionId, ipAddrV4, ipAddrV6, osName, osVersion, broName, broVersion, requestBody, description, other, method;
    private Date time;

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIpAddrV4() {
        return ipAddrV4;
    }

    public void setIpAddrV4(String ipAddrV4) {
        this.ipAddrV4 = ipAddrV4;
    }

    public String getIpAddrV6() {
        return ipAddrV6;
    }

    public void setIpAddrV6(String ipAddrV6) {
        this.ipAddrV6 = ipAddrV6;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getBroName() {
        return broName;
    }

    public void setBroName(String broName) {
        this.broName = broName;
    }

    public String getBroVersion() {
        return broVersion;
    }

    public void setBroVersion(String broVersion) {
        this.broVersion = broVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserActionLog{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", ipAddrV4='" + ipAddrV4 + '\'' +
                ", ipAddrV6='" + ipAddrV6 + '\'' +
                ", osName='" + osName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", broName='" + broName + '\'' +
                ", broVersion='" + broVersion + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", description='" + description + '\'' +
                ", other='" + other + '\'' +
                ", method='" + method + '\'' +
                ", time=" + time +
                '}';
    }
}
