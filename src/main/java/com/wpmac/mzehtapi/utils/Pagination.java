package com.wpmac.mzehtapi.utils;

/**
 * @author caizhen
 * @Description: 分页对象
 * @date 2015年6月9日 下午5:38:57
 */
public class Pagination {

    private Object dataList;        // 数据列表
    private Integer total;            // 总数据量
    private Integer currentPage;    // 当前页
    private Integer pageSize;        // 一页数据量


    public Pagination() {
    }

    public Pagination(Object dataList, Integer total, Integer currentPage, Integer pageSize) {
        this.dataList = dataList;
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }


    public Object getDataList() {
        return dataList;
    }

    public void setDataList(Object dataList) {
        this.dataList = dataList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public Integer getPages() {
        if (total == 0)
            return 1;
        return (total % pageSize == 0 ? (total / pageSize)
                : (total / pageSize + 1));
    }
}
