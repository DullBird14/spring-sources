package org.geek.ioc.event;

import java.util.Observable;
import java.util.Observer;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月30日 13:36:00
 */
public class JavaObserverDemo {
	public static void main(String[] args) {
		Observer observer = (o, arg) -> System.out.printf("%s:args:%s\n", o, arg);
		MyObservable observable = new MyObservable();
		observable.addObserver(observer);
		// 如果不设置。不会触发监听
		observable.setChanged();
		observable.notifyObservers("hahha");
	}

	/**
	 * 事件触发者。改变的方法由于是 protect
	 * 所以需要 覆盖这个方法
	 */
	static class MyObservable extends Observable {
		@Override
		public synchronized void setChanged() {
			super.setChanged();
		}
	}
}
