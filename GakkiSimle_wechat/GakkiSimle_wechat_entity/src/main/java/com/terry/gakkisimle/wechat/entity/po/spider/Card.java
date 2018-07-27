package com.terry.gakkisimle.wechat.entity.po.spider;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import javax.persistence.Column;
import java.io.Serializable;

public class  Card  extends Model<Card>  {
    @TableId( type=IdType.INPUT)
    private String id;
    private String text;
    @Column(name = "isLongText")
    private boolean isLongText;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "textLength")
    private Integer textLength;
    @Column(name = "picList")
    private String picList;
    @Column(name = "picInfo")
    private String picInfo;

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", isLongText=" + isLongText +
                ", created_at='" + created_at + '\'' +
                ", textLength=" + textLength +
                ", picList=" + picList +
                ", picInfo=" + picInfo +
                '}';
    }

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList;
    }

    public String getPicInfo() {
        return picInfo;
    }

    public void setPicInfo(String picInfo) {
        this.picInfo = picInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isLongText() {
        return isLongText;
    }

    public void setLongText(boolean longText) {
        isLongText = longText;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Integer getTextLength() {
        return textLength;
    }

    public void setTextLength(Integer textLength) {
        this.textLength = textLength;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}