package com.jvg.test.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class FileTestUtils {

	/**
	 * Gets the file as specified by the <code>fileName</code> in the package of
	 * the specified class <code>clazz</code>
	 * 
	 * @param fileName
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public static String getFileAsString(String fileName, Class clazz)
			throws IOException {

		String filePath = StringUtils.replace(clazz.getPackage().getName(),
				".", "/") + "/" + fileName;

		InputStream inputStream = clazz.getClassLoader().getResourceAsStream(
				filePath);

		String result = IOUtils.toString(inputStream);

		return result;
	}
}
