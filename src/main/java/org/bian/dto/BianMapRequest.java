package org.bian.dto;

import java.util.Map;


// TODO: Auto-generated Javadoc
/**
 * The Class BianMapRequest.
 *
 * @param <T> the generic type
 */
public class BianMapRequest<T> extends Dto{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The data. */
	Map<String, BianRequest<T>> data;
	
	/**
	 * Instantiates a new bian map request.
	 */
	public BianMapRequest() {
		
	}
	
	/**
	 * Instantiates a new bian map request.
	 *
	 * @param data the data
	 */
	public BianMapRequest(Map<String, BianRequest<T>> data) {
		this.data= data;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Map<String, BianRequest<T>> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the data
	 */
	public void setData(Map<String, BianRequest<T>> data) {
		this.data = data;
	}

	
	
}
