package com.terry.gakkisimle.wechat.entity.vo;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

public class Test  extends Model<Test> {
    int id;
    String name;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
