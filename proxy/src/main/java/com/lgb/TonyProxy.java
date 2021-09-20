package com.lgb;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TonyProxy implements MethodInterceptor {

    private Object target ;

    public TonyProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("**************** " + method.getName());

        Float object = (Float) objects[0];
        if( object > 1.6 ){
            System.out.println("这是大于1.6的前置的 .... ");
        }else{
            System.out.println("这是小于1.6的前置的 .... ");
        }

        for (int i = 0; i < objects.length; i++) {
            System.out.println("代理时 , 方法参数:" + objects[i]);
        }


        System.out.println("Object o --> " + o.getClass().getName());

        Boolean o1 = (Boolean) methodProxy.invokeSuper(o, objects);
        System.out.println("CGLIB 继承模式中 , 调用父类的返回值 : " + o1);

        Boolean result = null ;

        if( this.target != null  ){
            System.out.println("target --> " + target.getClass().getName());
            result = (Boolean) method.invoke(target , objects);
        }
        System.out.println("后置的 .... ");

        return result;
    }
}
