package com.iquantex.t3compliance;

import com.iquantex.t3compliance.bean.Hello;

public class TestMain {

    public static void main(String[] args) {

//        Hello hello = new Hello(true);
//
//        new Thread(()->hello.show()).start();
//
//        Hello hello1 = new Hello(true);
//
//        new Thread(()->hello1.show()).start();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        hello.doNotify();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        hello1.doNotify();
//        new Thread(()->hello.show()).start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        hello.setFlag(true);
//        hello.setFlag(false);
        Hello hello = new Hello(false);
        new Thread(()->hello.waitA()).start();
        new Thread(()->hello.waitB()).start();

        try {
            Thread.sleep(50*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
