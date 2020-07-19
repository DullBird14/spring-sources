package org.geek.ioc.i18n;

import java.text.MessageFormat;
import java.util.Date;

/**
 * {@link MessageFormat}
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月16日 20:56:00
 */
public class MessageFormatDemo {
	public static void main(String[] args) {
		int planet = 7;
		String event = "a disturbance in the Force";

		String result = MessageFormat.format(
				"At {1,time, long} on {1,date, full}, there was {2} on planet {0,number,integer}.",
				planet, new Date(), event);
		System.out.println(result);
	}

}
