package com.terry.gakkisimle.im.entity.dto.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author:menglihuan
 * @data:2018/12/1
 * @ds:socket数据包
 */
@Data
@Getter
@Setter
public abstract class Packet  {

    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)

    public Byte version = 1;


    @JSONField(serialize = false)
    public abstract Byte getCommand();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }
}