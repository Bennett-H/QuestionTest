package learn;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程创建
 */
public class Learn01dxc {
    // public 同一线程，其他类也可以使用该ThreadLocal
    public static ThreadLocal<String> objectThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Integer> objectThreadLocal2 = new ThreadLocal<>();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadEntity threadEntity = new ThreadEntity();
        threadEntity.start();

        Thread runnableEntity = new Thread(new RunnableEntity());
        runnableEntity.start();

        FutureTask<String> futureTask = new FutureTask<>(new CallableEntity());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(threadEntity);

        Thread thread1 = new Thread(new SynchronizedEntity());
        thread1.start();
        Thread thread2 = new Thread(new SynchronizedEntity());
        thread2.start();

        Thread thread3 = new Thread(new ReentrantLockEntity());
        thread3.start();
        Thread thread4 = new Thread(new ReentrantLockEntity());
        thread4.start();

        new Thread(() -> {
            Learn01dxc.objectThreadLocal.set("local_A");
            Learn01dxc.objectThreadLocal2.set(1);
            //打印本地变量
            print();
            System.out.println("after remove : " + objectThreadLocal.get());
            System.out.println("after remove : " + objectThreadLocal2.get());

        },"A").start();

        new Thread(() -> {
            Learn01dxc.objectThreadLocal.set("local_B");
            Learn01dxc.objectThreadLocal2.set(2);
            //打印本地变量
            print();
            objectThreadLocal.remove();
            objectThreadLocal2.remove();
            System.out.println("after remove : " + objectThreadLocal.get());
            System.out.println("after remove : " + objectThreadLocal2.get());

        },"B").start();

    }

    private static void print() {
        System.out.println(objectThreadLocal.get());
        System.out.println(objectThreadLocal2.get());
    }
}

class ThreadEntity extends Thread {

    @Override
    public void run() {
        System.out.println("ThreadEntity");
    }
}

class RunnableEntity implements Runnable {
    @Override
    public void run() {
        System.out.println("RunnableEntity");
    }
}

class CallableEntity implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "CallableEntity";
    }
}

class SynchronizedEntity implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for(int i=0;i<10;i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class ReentrantLockEntity implements Runnable {
    private final Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        try {
            for(int i=0;i<10;i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        } finally {
            lock.unlock();
        }
    }
}