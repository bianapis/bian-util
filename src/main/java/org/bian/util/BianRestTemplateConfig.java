package org.bian.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class BianRestTemplateConfig.
 */
@Configuration
public class BianRestTemplateConfig {
	
	/**
	 * Rest template.
	 *
	 * @return the rest template
	 */
	@Bean
    public RestTemplate restTemplate() {
    	
		return new RestTemplate();
		
    }
	
	/**
	 * Bian rest template.
	 *
	 * @return the bian rest template
	 */
	@Bean
    public BianRestTemplate bianRestTemplate() {
    	
		return new BianRestTemplate();
		
    }
    
    
}
