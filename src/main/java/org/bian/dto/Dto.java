package org.bian.dto;

import java.io.Serializable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class Dto.
 */
public abstract class Dto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant OBJECT_MAPPER. */
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Instantiates a new dto.
     */
    public Dto() {
    	
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        try {
            return OBJECT_MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException var2) {
            return "";
        }
    }
	
}
