package com.terry.gakkisimle.core.common.web.dto;

import java.io.Serializable;

/**
 * Created by terrymeng
 */
public class PageInfoDto implements Serializable {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String orderColumn;

    private String dir; //asc ,desc

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "PageInfoDto{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderColumn='" + orderColumn + '\'' +
                ", dir='" + dir + '\'' +
                '}';
    }
}
