package org.geek.ioc.overview.dependent.main;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年03月21日 22:36:00
 */
public class Test implements  Runnable {
	private static Object obj=new Object();
	@Override
	public void run() {
		//持有资源
		synchronized (obj){
			System.out.println(Thread.currentThread().getName()+"占用资源");
			//挂起
			try {
				obj.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"释放资源");
		}

	}

	public static void main(String[] args) throws InterruptedException {
//		int i =100;
//		for (;i>0;i--) {
//			Thread thread=new Thread(new Test(),"线程" + i);
//			thread.start();
//			Thread.sleep(100L);
//		}
		Thread thread=new Thread(new Test(),"线程1");
		thread.start();
		Thread.sleep(100L);

		Thread deadThread=new Thread(new Test(),"线程2");
		deadThread.start();
		Thread.sleep(100L);
		synchronized (obj){
//			obj.notifyAll();
			obj.notify();
		}
		Thread.sleep(100L);

//		synchronized (obj){
//			obj.notify();
//		}
//		Thread.sleep(100L);
//
//		synchronized (obj){
//			obj.notify();
//		}
	}
}
