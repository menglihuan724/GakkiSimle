package com.terry.gakkisimle.im.entity.dto.protocol;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import static com.terry.gakkisimle.im.entity.dto.protocol.Command.LOGIN_REQUEST;

/**
 * @author:menglihuan
 * @data:2018/12/1
 * @ds:登录请求类
 */
@Data
@Getter
@Setter
public class LoginRequestPacket extends Packet {
    private String userName;

    private String password;

    @Override
    public Byte getCommand() {

        return LOGIN_REQUEST;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}