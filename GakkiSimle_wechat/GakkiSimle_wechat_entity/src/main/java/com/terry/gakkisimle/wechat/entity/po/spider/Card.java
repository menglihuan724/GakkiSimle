package com.terry.gakkisimle.wechat.entity.po.spider;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "card")
public class  Card  extends Model<Card>  {
    @TableId( type=IdType.INPUT)
    @Id()
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String text;
    @Column(name = "is_long_text",columnDefinition="tinyint")
    private Boolean isLongText;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "text_length",columnDefinition="int")
    private Integer textLength;
    @Column(name = "pic_list",columnDefinition="json")
    private String picList;
    @Column(name = "pic_info",columnDefinition="json")
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

    public Boolean getLongText() {
        return isLongText;
    }

    public void setLongText(Boolean longText) {
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