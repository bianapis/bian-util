package org.bian.util;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class JsonReader.
 */
public class JsonReader {
		
	/**
	 * Read.
	 *
	 * @param <T> the generic type
	 * @param path the path
	 * @param type the type
	 * @return the t
	 */
	public static <T> T read(String path, TypeReference<T> type) {

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		InputStream is = TypeReference.class.getResourceAsStream("/" + path);
		try {
			return mapper.readValue(is, type);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
