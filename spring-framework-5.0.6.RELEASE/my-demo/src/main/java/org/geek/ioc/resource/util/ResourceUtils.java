package org.geek.ioc.resource.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月15日 00:04:00
 */
public interface ResourceUtils {
	static String getContent(Resource resource) {
		try {
			return getContent(resource, "UTF-8");
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static String getContent(Resource resource, String charset) throws IOException {
		// 使用 EncodedResource 其中可以执行编码
		EncodedResource encodedResource = new EncodedResource(resource, charset);
		// 通过 EncodedResource 可以获取 Reader
		Reader reader = encodedResource.getReader();
		// 读取所有字符串，可以使用 apache 的 IoUtils 或 Guava的工具类读取
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringBuilder builder = new StringBuilder();
		String oneLine = null;
		while ((oneLine = bufferedReader.readLine()) != null) {
			builder.append(oneLine).append("\n");
		}
		return builder.toString();
	}

	;
}
