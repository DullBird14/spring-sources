package org.geek.ioc.validation;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月19日 20:51:00
 * @See {@link Errors}
 */
public class ErrorsDemo {
	public static void main(String[] args) {
		//0. 创建user
		User user = new User();
		user.setName("hahaha");
		// 1. 构造BeanPropertyBindingResult
		BeanPropertyBindingResult result = new BeanPropertyBindingResult(user, "user");
		// 2. 创建消息文案
		StaticMessageSource messageSource = new StaticMessageSource();
		messageSource.addMessage("user.required", Locale.getDefault(), "user对象不能为空");
		messageSource.addMessage("name.not.null", Locale.getDefault(), "user的名称不能为空");
		// 3.调用方法
		result.reject("user.required");
		result.rejectValue("name", "name.not.null");
		// 4.获取结果
		List<ObjectError> allErrors = result.getAllErrors();
		for (ObjectError oneErrors : allErrors) {
			System.out.println(messageSource.getMessage(oneErrors.getCode(),
					oneErrors.getArguments(), Locale.getDefault()));
		}
	}
}
