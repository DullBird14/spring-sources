package org.geek.ioc.binder.pojo;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月23日 12:50:00
 */
public class BinderSubObject {
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "BinderSubObject{" +
				"address='" + address + '\'' +
				'}';
	}
}
