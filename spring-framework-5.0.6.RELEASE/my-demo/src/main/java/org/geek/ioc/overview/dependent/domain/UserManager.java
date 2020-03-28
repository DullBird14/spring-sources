package org.geek.ioc.overview.dependent.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cys
 * @date 2020-01-05 12:11
 */
@Component
public class UserManager {
	@Autowired
	@Qualifier("user")
	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "UserManager{" +
				"list=" + list +
				'}';
	}
}
