package io.netty.test;

/**
 * Created by zhisheng_tian on 2017/12/20.
 */
public class ThreadLocalTest {
    //创建一个Integer型的线程本地变量
    public static final ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int j = 0; j < 5; j++) {
            threads[j] = new Thread(() -> {
                //获取当前线程的本地变量，然后累加5次
                int num = local.get();
                for (int i = 0; i < 5; i++) {
                    num++;
                }
                //重新设置累加后的本地变量
                local.set(num);
                System.out.println(Thread.currentThread().getName() + " : "+ local.get());

            }, "Thread-" + j);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
