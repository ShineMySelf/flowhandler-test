package com.iquantex.t3compliance.bean;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hello {
    Lock lock = new ReentrantLock();

    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();

    private boolean flag;

    public Hello(boolean flag){
        this.flag = flag;
    }

    public void show(){
        while (true){
            synchronized (this){
                while (flag){
                    try {
                        System.out.println(Thread.currentThread().getName()+"wait...");
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+":进行中。。。");

            }
        }
    }

    public void doNotify(){
        synchronized (this){
            this.flag = false;
            this.notify();
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void waitA(){
        lock.lock();
        try {
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void waitB(){
        lock.lock();
        System.out.println("come in...");
        lock.unlock();
    }

    public synchronized void waitC(){

    }

}
