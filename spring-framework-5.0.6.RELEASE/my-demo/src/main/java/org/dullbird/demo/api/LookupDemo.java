//package org.dullbird.demo.api;
//
//import org.dullbird.demo.bean.LookupUser;
//import org.dullbird.demo.bean.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Lookup;
//import org.springframework.stereotype.Component;
//
///**
// * @author cys
// * @date 2019-12-28 21:32
// */
//@Component
//public class LookupDemo {
//	@Autowired
//	private LookupUser user;
//
//	//此处没办法通过参数传递，方法内部需要返回不同对象的情况
//
//	/**
//	 * 希望每次调用返回的user都是不同的。
//	 * 此处没办法通过参数传递，方法内部需要返回不同对象的情况
//	 * @return
//	 */
//	public LookupUser invokeAndReturnNewUser(){
//		return createUser();
//	}
//
//	/**
//	 * 限制可以lookup的方法格式
//	 * <public|protected> [abstract] <return-type> theMethodName(no-arguments);
//	 * 返回类型为所需要的对象，即user,并且填写bean的名称
//	 * @return
//	 */
//	@Lookup("user")
//	public LookupUser createUser(){
//		return null;
//	}
//
//}
