package com.lgb;

import net.sf.cglib.proxy.Enhancer;


/**
 * 先是描述类 , 指定父类或者接口 . 怎么增强的具体方法 .
 * 生成代理对象 .
 */
public class Test {

    public static void main1(String[] args) {
        Enhancer e = new Enhancer();
        TeachCang teachCang = new TeachCang();


        // 设置要代理的超类
        e.setSuperclass(Girl.class);

        // 设置增强回调 ..
        e.setCallback(new TonyProxy(teachCang));

        // 生成代理对象 ..
        Girl girlProxy = (Girl) e.create();

        girlProxy.dating(1.6f) ;

    }
    public static void main2(String[] args) {
        TeachCang teachCang = new TeachCang();


        Enhancer e = new Enhancer();
        // 设置要代理的超类
        e.setSuperclass(TeachCang.class);

        // 设置增强回调 ..
        e.setCallback(new TonyProxy(teachCang));

        // 生成代理对象 ..
        Girl girlProxy = (Girl) e.create();

        boolean dating = girlProxy.dating(1.5f);

        System.out.println("最终代理类的返回值 : " + dating);

    }
    public static void main(String[] args) {


        Enhancer e = new Enhancer();
        // 设置要代理的超类
        e.setSuperclass(Boy.class);

        // 设置增强回调 ..
        e.setCallback(new TonyProxy(new Boy()));

        // 生成代理对象 ..
        Boy girlProxy = (Boy) e.create();

        String dating = girlProxy.jFZ("第一次 .. ");

        System.out.println("最终代理类的返回值 : " + dating);

    }




}
