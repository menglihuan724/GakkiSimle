package com.terry.gakkisimle.im;

import com.terry.gakkisimle.im.socket.LoginRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.time.LocalDate;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * Created by terrymeng
 * IM启动类
 */

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.terry.gakkisimle.im")
@EntityScan(basePackages = {"com.terry.gakkisimle.wechat.entity.po", "com.terry.gakkisimle.im.entity.po"})
@EnableFeignClients
@EnableTransactionManagement()
@EnableJpaRepositories(basePackages = "com.terry.gakkisimle.im.dao")
@MapperScan("com.terry.gakkisimle.im.mapper")
public class IMApplication {
    private static final int PORT = 8000;
    public static void main(String[] args) throws Exception {

        SpringApplication.run(IMApplication.class, args);
        /*绑定socket*/
        startServer();

    }

    private static void startServer() throws Exception {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        SSLContext sslContext = createSSLContext("JKS",
                "D:\\myproject\\GakkiSimle\\GakkiSimle_im\\GakkiSimle_im_config\\src\\main\\resources\\wss.jks","netty123");
        //SSLEngine 此类允许使用ssl安全套接层协议进行安全通信
        SSLEngine engine = sslContext.createSSLEngine();
        engine.setUseClientMode(false);

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boosGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast("ssl", new SslHandler(engine));
                        //websocket协议本身是基于http协议的，所以这边也要使用http解编码器
                        ch.pipeline().addLast(new HttpServerCodec());
                        //以块的方式来写的处理器
                        ch.pipeline().addLast(new ChunkedWriteHandler());
                        //netty是基于分段请求的，HttpObjectAggregator的作用是将请求分段再聚合,参数是聚合字节的最大长度
                        ch.pipeline().addLast(new HttpObjectAggregator(8192));

                        // 空闲检测
//                        ch.pipeline().addLast(new IMIdleStateHandler());
//                        ch.pipeline().addLast(new Spliter());
//                        ch.pipeline().addLast(PacketCodecHandler.INSTANCE);
                        ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));
                        ch.pipeline().addLast(LoginRequestHandler.INSTANCE);
//                        ch.pipeline().addLast(HeartBeatRequestHandler.INSTANCE);
//                        ch.pipeline().addLast(AuthHandler.INSTANCE);
//                        ch.pipeline().addLast(IMHandler.INSTANCE);
                    }
                });


        bind(serverBootstrap, PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(LocalDate.now() + ": 端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
            }
        });
    }

    public static SSLContext createSSLContext(String type , String path , String password) throws Exception {
        KeyStore ks = KeyStore.getInstance(type); /// "JKS"
        InputStream ksInputStream = new FileInputStream(path); /// 证书存放地址
        ks.load(ksInputStream, password.toCharArray());
        //KeyManagerFactory充当基于密钥内容源的密钥管理器的工厂。
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());//getDefaultAlgorithm:获取默认的 KeyManagerFactory 算法名称。
        kmf.init(ks, password.toCharArray());
        //SSLContext的实例表示安全套接字协议的实现，它充当用于安全套接字工厂或 SSLEngine 的工厂。
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);
        return sslContext;
    }

}

@EnableAsync
@Configuration
class TaskPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        /*核心线程数*/
        executor.setCorePoolSize(10);
        /*最大线程数*/
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(200);
        /*除开核心线程的线程销毁时间*/
        executor.setKeepAliveSeconds(60);
        /*优雅关机*/
        executor.setWaitForTasksToCompleteOnShutdown(true);
        /*销毁时间,防止阻塞*/
        executor.setAwaitTerminationSeconds(60);
        executor.setThreadNamePrefix("taskExecutor-");
        /*拒绝任务策略*/
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
