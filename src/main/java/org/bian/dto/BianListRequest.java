package org.bian.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Generic BIAN list request model.
 * 
 * @author Virtusa Inc.
 *
 * @param <T> Generic Type.
 */
public class BianListRequest<T> extends Dto{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The data. */
	List<BianRequest<T>> data;
	
	/**
	 * Instantiates a new bian list request.
	 */
	public BianListRequest() {
		
	}
	
	/**
	 * Instantiates a new bian list request.
	 *
	 * @param data the data
	 */
	public BianListRequest(List<BianRequest<T>> data) {
		this.data= data;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<BianRequest<T>> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<BianRequest<T>> data) {
		this.data = data;
	}



	
	
}
