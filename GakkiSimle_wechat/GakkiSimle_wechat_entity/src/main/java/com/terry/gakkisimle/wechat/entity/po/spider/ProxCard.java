package com.terry.gakkisimle.wechat.entity.po.spider;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxCard implements InvocationHandler {
    private Object object;

    public ProxCard(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // TODO Auto-generated method stub
            System.out.println("MyInvocationHandler invoke begin");
            System.out.println("proxy: "+ proxy.getClass().getName());
            System.out.println("method: "+ method.getName());
            for(Object o : args){
                System.out.println("arg: "+ o);
            }
            System.out.println("MyInvocationHandler invoke end");
            return null;
    }
}