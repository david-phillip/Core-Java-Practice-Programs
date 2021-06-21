package test.prac.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {

    public static void main(String args[]) {

        List<Integer> list = new ArrayList<>();
        ReadWriteClass readWriteClassObj = new ReadWriteClass(list);

        Runnable r1 = () -> {
            readWriteClassObj.setElement(10);
            readWriteClassObj.setElement(20);
            readWriteClassObj.setElement(30);
            readWriteClassObj.setElement(40);
        };

        Runnable r2 = () -> {
            int i = readWriteClassObj.getElement(0);
            System.out.println(i);
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}

class ReadWriteClass{

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    List<Integer> list;

    public void setElement(int i){
        writeLock.lock();
        writeLock.lock();
        System.out.println("Locked setElement " + Thread.currentThread().getName());
        list.add(i);
        writeLock.unlock();
        writeLock.unlock();
        System.out.println("Unlocked setElement " + Thread.currentThread().getName());
    }

    public Integer getElement(int i){
        readLock.lock();
        try {
            System.out.println("Locked getElement " + Thread.currentThread().getName());
            return list.get(i);
        }finally {
            readLock.unlock();
            System.out.println("Unlocked getElement " + Thread.currentThread().getName());
        }
    }

    ReadWriteClass(List list){
        this.list = list;
    }
}
