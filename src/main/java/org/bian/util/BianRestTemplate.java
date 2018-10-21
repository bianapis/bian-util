package org.bian.util;

import org.bian.dto.BianRequest;
import org.bian.dto.BianResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class BianRestTemplate.
 */
public class BianRestTemplate {
	
	/** The rest template. */
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public HttpHeaders getHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
	/**
	 * Gets the http entity.
	 *
	 * @param <T> the generic type
	 * @param request the request
	 * @return the http entity
	 */
	public <T> HttpEntity<BianRequest<T>> getHttpEntity(T request){
		BianRequest<T> req = new BianRequest<T>(request);
		HttpEntity<BianRequest<T>> entity = new HttpEntity<BianRequest<T>>(req, getHeaders());
		return entity;
	}
	
	/**
	 * Do exchange.
	 *
	 * @param <T> the generic type
	 * @param <U> the generic type
	 * @param request the request
	 * @param type the type
	 * @param URL the url
	 * @param method the method
	 * @return the u
	 */
	public <T,U> U doExchange(T request, TypeReference<U> type, String URL, HttpMethod method){
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ParameterizedTypeReference<BianResponse<U>> typeRef = new ParameterizedTypeReference<BianResponse<U>>() {};
		
		ResponseEntity<BianResponse<U>> responseEntity = restTemplate.exchange(URL, method, getHttpEntity(request),typeRef);
		return mapper.convertValue(responseEntity.getBody().getData(), type);
	}
	
}
