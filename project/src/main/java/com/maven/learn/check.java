package com.maven.learn;

import java.net.URL;

public class check {

	public static void main(String[] args) {
		ClassLoader classloader =
				   org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
				URL resPath = classloader.getResource(
				         "org/apache/poi/poifs/filesystem/POILogFactory.class");
				String path = resPath.getPath();
				System.out.println("The actual POI Path is " + path);

	}
}
