package org.bian.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.bian.dto.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class BianMapResponse.
 */
public class BianMapResponse extends Dto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The status. */
	private ResponseStatus status;
	
	/** The data. */
	private Map<String, BianResponse> data;
	
	/** The errors. */
	private List<ErrorDto> errors;

	/**
	 * Instantiates a new bian map response.
	 */
	public BianMapResponse() {

	}

	/**
	 * Instantiates a new bian map response.
	 *
	 * @param status the status
	 * @param data the data
	 */
	public BianMapResponse(ResponseStatus status, Map<String, BianResponse> data) {
		this.status = status;
		this.data = data;
	}

	/**
	 * Instantiates a new bian map response.
	 *
	 * @param status the status
	 * @param errors the errors
	 */
	public BianMapResponse(ResponseStatus status, List<ErrorDto> errors) {
		this.status = status;
		this.errors = errors;
	}

	/**
	 * For success.
	 *
	 * @param data the data
	 * @return the bian map response
	 */
	public static BianMapResponse forSuccess(Map<String, BianResponse> data) {
		return new BianMapResponse(ResponseStatus.SUCCESS, data);
	}

	/**
	 * For error.
	 *
	 * @param errors the errors
	 * @return the bian map response
	 */
	public static BianMapResponse forError(List<ErrorDto> errors) {
		return new BianMapResponse(ResponseStatus.ERROR, errors);
	}

	/**
	 * For error.
	 *
	 * @param errors the errors
	 * @return the bian map response
	 */
	public static BianMapResponse forError(ErrorDto... errors) {
		return new BianMapResponse(ResponseStatus.ERROR, Arrays.asList(errors));
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ResponseStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Map<String, BianResponse> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the data
	 */
	public void setData(Map<String, BianResponse> data) {
		this.data = data;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<ErrorDto> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(List<ErrorDto> errors) {
		this.errors = errors;
	}

	/**
	 * Checks for errors.
	 *
	 * @return true, if successful
	 */
	public boolean hasErrors() {
		return errors != null;
	}

}
