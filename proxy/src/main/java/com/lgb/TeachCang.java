package com.lgb;

public class TeachCang extends Girl{
    @Override
    boolean dating(float length) {

        if (length > 1.75){
            System.out.println("身高合适 , 可以约 ... ");
            return true;
        }else {
            System.out.println("有点矮 , 不合适 ... ");
            return false;
        }

    }
}
