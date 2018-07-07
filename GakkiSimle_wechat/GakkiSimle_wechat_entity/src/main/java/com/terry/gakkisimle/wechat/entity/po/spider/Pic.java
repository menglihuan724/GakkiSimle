package com.terry.gakkisimle.wechat.entity.po.spider;

public class Pic {
    private  String pid;
    private  String url;
    private Integer  width;
    private  Integer heigh;

    @Override
    public String toString() {
        return "Pic{" +
                "pid='" + pid + '\'' +
                ", url='" + url + '\'' +
                ", width=" + width +
                ", heigh=" + heigh +
                '}';
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeigh() {
        return heigh;
    }

    public void setHeigh(Integer heigh) {
        this.heigh = heigh;
    }
}