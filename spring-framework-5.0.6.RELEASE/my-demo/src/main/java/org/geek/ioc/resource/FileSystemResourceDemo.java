package org.geek.ioc.resource;

import org.geek.ioc.resource.util.ResourceUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URLStreamHandlerFactory;
import java.nio.charset.Charset;

/**
 * {@link FileSystemResource}
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月12日 23:22:00
 */
public class FileSystemResourceDemo {
	public static void main(String[] args) throws IOException {
//		ClassPathResource classPathResource = new ClassPathResource("");
//		UrlResource urlResource = new UrlResource("");
		String dir = System.getProperty("user.dir")
				+ "/my-demo/src/main/java/org/geek/ioc/resource/ResourceDemo.java";

		System.out.println(dir);
		FileSystemResource fileSystemResource = new FileSystemResource(dir);
		// FileSystemResource -> WritableResource -> Resource
		WritableResource writableResource = fileSystemResource;
		System.out.println(ResourceUtils.getContent(fileSystemResource, "UTF-8"));


	}
}
