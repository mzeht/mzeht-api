/*
* Copyright (c) 2017 mzeht. All Rights Reserved.
*/
package com.wpmac.mzehtapi.dto;

/**
 * @author: wpmac  Date: 2017/1/21 Time: 下午3:44
 */
public class PageDTO {

    private int pageNum;
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}