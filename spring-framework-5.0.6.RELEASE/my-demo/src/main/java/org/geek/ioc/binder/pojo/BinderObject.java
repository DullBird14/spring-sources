package org.geek.ioc.binder.pojo;

import org.springframework.lang.NonNull;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月23日 12:50:00
 */
public class BinderObject {
	@NonNull
	private String name;
	private Integer age;
	private String ename;
	private BinderSubObject subObject;

	public BinderSubObject getSubObject() {
		return subObject;
	}

	public void setSubObject(BinderSubObject subObject) {
		this.subObject = subObject;
	}
	@Deprecated
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "BinderObject{" +
				"name='" + name + '\'' +
				", age=" + age +
				", ename='" + ename + '\'' +
				", subObject=" + subObject +
				'}';
	}
}
