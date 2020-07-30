package org.geek.ioc.convertor;


import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月27日 10:40:00
 */
public class StringToPropertyEditor extends PropertyEditorSupport  {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		//对象类型转化
		Properties properties = new Properties();
		try {
			properties.load(new StringReader(text));
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		//临时存储
		setValue(properties);
	}
}
