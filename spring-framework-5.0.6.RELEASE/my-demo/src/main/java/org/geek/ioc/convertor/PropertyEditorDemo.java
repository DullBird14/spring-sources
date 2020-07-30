package org.geek.ioc.convertor;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月27日 10:39:00
 */
public class PropertyEditorDemo {
	public static void main(String[] args) {
		String text = "name = hahah";
		StringToPropertyEditor editor = new StringToPropertyEditor();
		editor.setAsText(text);
		System.out.println(editor.getValue());
	}
}
