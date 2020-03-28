package org.geek.ioc.overview.dependent.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author cys
 * @date 2020-01-05 11:52
 */
@Component
public class SuperUser extends User {
	private String address;
	private String tag;
//	@PostConstruct
//	private void init(){
//		this.setId(2);
//		this.setName("cys-super");
//		this.setAddress("abc street");
//	}


	public SuperUser() {
	}

	public SuperUser(int id) {
		super(id);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				", tag='" + tag + '\'' +
				'}';
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		return;
	}
}
