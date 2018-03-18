package com.terry.gakkisimle.wechat.entity.vo;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

public class Test  extends Model<Test> {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
