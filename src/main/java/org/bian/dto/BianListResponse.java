package org.bian.dto;

import java.util.Arrays;
import java.util.List;
import org.bian.dto.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class BianListResponse.
 */
public class BianListResponse extends Dto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The status. */
	private ResponseStatus status;
	
	/** The data. */
	private List<BianResponse> data;
	
	/** The errors. */
	private List<ErrorDto> errors;

	/**
	 * Instantiates a new bian list response.
	 */
	public BianListResponse() {

	}

	/**
	 * Instantiates a new bian list response.
	 *
	 * @param status the status
	 * @param data the data
	 */
	public BianListResponse(ResponseStatus status, List<BianResponse> data) {
		this.status = status;
		this.data = data;
	}

	/**
	 * For success.
	 *
	 * @param data the data
	 * @return the bian list response
	 */
	public static BianListResponse forSuccess(List<BianResponse> data) {
		return new BianListResponse(ResponseStatus.SUCCESS, data);
	}

	/**
	 * For success.
	 *
	 * @param data the data
	 * @return the bian list response
	 */
	public static BianListResponse forSuccess(BianResponse... data) {
		return new BianListResponse(ResponseStatus.SUCCESS, Arrays.asList(data));
	}

	/**
	 * For error.
	 *
	 * @param errors the errors
	 * @return the bian list response
	 */
	public static BianListResponse forError(List<ErrorDto> errors) {
		BianListResponse response = new BianListResponse();
		response.setStatus(ResponseStatus.ERROR);
		response.setErrors(errors);
		return response;
	}

	/**
	 * For error.
	 *
	 * @param errors the errors
	 * @return the bian list response
	 */
	public static BianListResponse forError(ErrorDto... errors) {
		BianListResponse response = new BianListResponse();
		response.setStatus(ResponseStatus.ERROR);
		response.setErrors(Arrays.asList(errors));
		return response;
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
	public List<BianResponse> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<BianResponse> data) {
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
