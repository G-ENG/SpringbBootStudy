package com.aop.log;

import com.aop.bean.User;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * TODO
 *
 * @Author GenG
 * @Date 2020/11/23
 **/
public class LogConsumer implements Runnable {
    private BlockingQueue<User> blockingQueue;
    private List<User> userList = new LinkedList<>();

    public LogConsumer(BlockingQueue<User> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("启动消费者线程！");
        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("正从队列获取数据...");
                userList.clear();
                userList.add(blockingQueue.take());
                for (int i = 0; i < 1000; i++) {
                    User poll = blockingQueue.poll();
                    if (poll != null) {
                        userList.add(poll);
                    } else {
                        System.out.println(Arrays.toString(userList.toArray()));
                        //todo
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("退出消费者线程！");
            System.out.println("hello");
        }
    }

}
