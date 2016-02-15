/**   
 * Basket.java 
 * com.concurrent 
 * @Description:
 * @author Yhc yinhc@yinhu.com
 * 2016年1月14日 下午2:18:46 
 * @version V1.0   
 */

package com.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project：TestJava
 * @Package：com.concurrent
 * @ClassName: Basket
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yhc yinhc@yinhu.com
 * @date 2016年1月14日 下午2:18:46
 */
public class Basket {
	// 篮子，能够容纳3个苹果
	BlockingQueue	basket	= new ArrayBlockingQueue<String>(3);

	// 生产苹果，放入篮子
	public void produce() throws InterruptedException {
		// put方法放入一个苹果，若basket满了，等到basket有位置
//		basket.put("An apple");
		if(!basket.offer("An apple")){
			System.out.println("basket满了，等到basket有位置");
		}
	}

	// 消费苹果，从篮子中取走
	public String consume() throws InterruptedException {
		// get方法取出一个苹果，若basket为空，等到basket有苹果为止
		if(basket.isEmpty()){
			System.out.println("basket为空，等到basket有苹果");
		}else{
			return (String) basket.take();
		}
		return null;
	}

	// 　测试方法
	public static void testBasket() {
		// 建立一个装苹果的篮子
		final Basket basket = new Basket();
		// 定义苹果生产者
		class Producer implements Runnable {
			public void run() {
				try {
					while (true) {
						// 生产苹果
						System.out.println("生产者准备生产苹果："
								+ System.currentTimeMillis());
						basket.produce();
						System.out.println("生产者生产苹果完毕："
								+ System.currentTimeMillis());
						// 休眠300ms
						Thread.sleep(300);
					}
				} catch (InterruptedException ex) {
				}
			}
		}
		// 定义苹果消费者
		class Consumer implements Runnable {
			public void run() {
				try {
					while (true) {
						// 消费苹果
						System.out.println("消费者准备消费苹果："
								+ System.currentTimeMillis());
						basket.consume();
						System.out.println("消费者消费苹果完毕："
								+ System.currentTimeMillis());
						// 休眠1000ms
						Thread.sleep(200);
					}
				} catch (InterruptedException ex) {
				}
			}
		}

		ExecutorService service = Executors.newCachedThreadPool();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
		service.submit(consumer);
		// 程序运行5s后，所有任务停止
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		service.shutdownNow();
	}

	public static void main(String[] args) {
		Basket.testBasket();
	}
}
