package learn;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public interface test1 {
    int age = 0;
    default void setAge() {
        System.out.println(age);
    };

    static void aaa() {
        System.out.println(age);
    }

    void set();
}

abstract class a implements test1 {

    int age;

    private void setaaa() {
        age = 0;
    }
    abstract void set2();
}