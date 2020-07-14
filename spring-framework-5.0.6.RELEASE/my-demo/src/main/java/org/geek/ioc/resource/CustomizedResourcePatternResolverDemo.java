package org.geek.ioc.resource;

import org.geek.ioc.resource.util.ResourceUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * {@link PathMatchingResourcePatternResolver}
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月14日 23:55:00
 * @see ResourcePatternResolver
 * @see PathMatcher
 */
public class CustomizedResourcePatternResolverDemo {
	public static void main(String[] args) throws IOException {
		// todo 注意这里 dir ="//Users/..." 前面是双斜杠
		String currentPath = "/" + System.getProperty("user.dir")
				+ "/my-demo/src/main/java/org/geek/ioc/resource/";
		String patternPath = currentPath + "*.java";
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
		// 自定义匹配器
		resolver.setPathMatcher(new JavaFileMather());
		Resource[] resources = resolver.getResources(patternPath);
		Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);
	}
	static class JavaFileMather implements PathMatcher {

		@Override
		public boolean isPattern(String path) {
			return path.endsWith(".java");
		}

		@Override
		public boolean match(String pattern, String path) {
			return path.endsWith(".java");
		}

		@Override
		public boolean matchStart(String pattern, String path) {
			return false;
		}

		@Override
		public String extractPathWithinPattern(String pattern, String path) {
			return null;
		}

		@Override
		public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
			return null;
		}

		@Override
		public Comparator<String> getPatternComparator(String path) {
			return null;
		}

		@Override
		public String combine(String pattern1, String pattern2) {
			return null;
		}
	}
}
