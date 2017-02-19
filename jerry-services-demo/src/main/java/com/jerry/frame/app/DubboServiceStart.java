package com.jerry.frame.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboServiceStart {

	public static void main(String args[]) {
		long start = System.currentTimeMillis();

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/spring/spring-application-context.xml" });
		/**
		 * 在基于web的ApplicationContext实现中，已有相应的实现来处理关闭web应用时恰当地关闭Spring
		 * IoC容器。但，如果你正在一个非web应用的环境下使用Spring的IoC容器
		 * ，如dubbo服务，你想让容器优雅的关闭，并调用singleton的bean相应destory回调方法
		 * ，你需要在JVM里注册一个“关闭钩子”（shutdown hook）。这一点非常容易做到，并且将会确保你的Spring
		 * IoC容器被恰当关闭，以及所有由单例持有的资源都会被释放。
		 */
		applicationContext.registerShutdownHook();
		applicationContext.start();
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("启动服务花费" + time + "秒");
		while (true) {
			try {
				Thread.currentThread().sleep(3000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//测试git
			}
		}
	}

}
