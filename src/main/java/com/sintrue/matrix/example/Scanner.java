package com.sintrue.matrix.example;

import wang.liangchen.matrix.framework.commons.classloader.LoadedScanner;
import wang.liangchen.matrix.framework.commons.configuration.ConfigurationResolver;
import wang.liangchen.matrix.framework.commons.network.URIUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author Liangchen.Wang 2022-05-26 23:08
 */
public class Scanner {
    public static void scan() {
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources("");
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                Path path = Paths.get(url.toURI());
                scan(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void scan(Path path) throws IOException {
        Files.walk(path)
                .filter(p -> Files.isRegularFile(p))
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        String urlString = "file:///D:/Project/LiangChen.Wang/matrix/matrix-example/target/matrix-example-1.0.0-SNAPSHOT.jar!/BOOT-INF/classes!/matrix-framework";
        URI uri = URIUtil.INSTANCE.toURI(urlString, "abc/def");
        URL url = URIUtil.INSTANCE.toURL(urlString, "abc/def");
        System.out.println(uri);
        System.out.println(url);
        uri = URIUtil.INSTANCE.expandURI(uri, "gh/ij");
        url = URIUtil.INSTANCE.expendURL(url, "gh/ij");
        System.out.println(uri);
        System.out.println(url);
    }
}
