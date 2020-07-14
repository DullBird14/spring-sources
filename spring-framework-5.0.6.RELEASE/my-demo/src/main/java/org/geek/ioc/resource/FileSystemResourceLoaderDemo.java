package org.geek.ioc.resource;

import org.geek.ioc.resource.util.ResourceUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * {@link org.springframework.core.io.FileSystemResourceLoader}
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月12日 23:22:00
 * @see org.springframework.core.io.ResourceLoader
 */
public class FileSystemResourceLoaderDemo {
	public static void main(String[] args) throws IOException {
		// todo 注意这里 dir ="//Users/..." 前面是双斜杠
		String dir = "/" + System.getProperty("user.dir")
				+ "/my-demo/src/main/java/org/geek/ioc/resource/FileSystemResourceLoaderDemo.java";

		System.out.println(dir);
		FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
		Resource resource = fileSystemResourceLoader.getResource(dir);
		System.out.println(ResourceUtils.getContent(resource, "UTF-8"));

	}
}
