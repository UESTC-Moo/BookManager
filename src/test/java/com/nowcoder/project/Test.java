package com.nowcoder.project;

import org.apache.commons.lang3.StringUtils;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Test {
    public static volatile int num = 0;
    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
//        //开启30个线程进行累加操作
//        for(int i=0;i<30;i++){
//            new Thread(){
//                public void run(){
//                    for(int j=0;j<10000;j++){
////                        num++;//自加操作
//                        num = num + 1;
//                    }
//                    countDownLatch.countDown();
//                }
//            }.start();
//        }
//        //等待计算线程执行完
//        countDownLatch.await();
//        System.out.println(num);
//        List list = new ArrayList();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String str = iterator.next();
//            System.out.println(str);
//            if (str.equals("b")){
//                iterator.remove();
//            }
//
//        }
//
//        System.out.println(list.toString());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{new Thread().start();}); //?


        BlockingQueue queue = new LinkedBlockingQueue(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,10,null, queue);



    }
}
