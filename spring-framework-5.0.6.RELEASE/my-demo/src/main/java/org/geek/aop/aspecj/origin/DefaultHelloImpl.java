package org.geek.aop.aspecj.origin;

public class DefaultHelloImpl implements HelloInterface {
	@Override
	public void hello() {
		System.out.println("DefaultHelloImpl: say hello!");
	}
}
