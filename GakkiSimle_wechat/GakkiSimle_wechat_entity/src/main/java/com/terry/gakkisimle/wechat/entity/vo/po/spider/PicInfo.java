package com.terry.gakkisimle.wechat.entity.vo.po.spider;

public class PicInfo {
    private String page_url ;
    private String page_pic;
    private String page_title;

    @Override
    public String toString() {
        return "PicInfo{" +
                "page_url='" + page_url + '\'' +
                ", page_pic='" + page_pic + '\'' +
                ", page_title='" + page_title + '\'' +
                '}';
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }

    public String getPage_pic() {
        return page_pic;
    }

    public void setPage_pic(String page_pic) {
        this.page_pic = page_pic;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }
}