package com.terry.gakkisimle.im.handler;

import com.terry.gakkisimle.im.entity.dto.protocol.LoginRequestPacket;
import com.terry.gakkisimle.im.entity.dto.protocol.LoginResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDate;


/**
 * @author:menglihuan
 * @data:2018/12/1
 * @ds:
 */
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    protected LoginRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) {
        System.out.println(loginRequestPacket);
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        loginResponsePacket.setUserName(loginRequestPacket.getUserName());

        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
//            String userId = IDUtil.randomId();
            loginResponsePacket.setUserId("123");
            loginResponsePacket.setReason("333");
            System.out.println("[" + loginRequestPacket.getUserName() + "]登录成功");
//            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUserName()), ctx.channel());
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(LocalDate.now() + ": 登录失败!");
        }

        // 登录响应
        ctx.writeAndFlush(new TextWebSocketFrame(loginResponsePacket.toString()));
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
//        SessionUtil.unBindSession(ctx.channel());
    }
}