/**
 * 
 */
package com.states.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.states.pojo.AllStatesResponse;
import com.states.pojo.SingleStateResponse;
	
/**
 * @author Martin M. Morales
 * 
 * StatesClientImpl -  Implements the client interface
 *
 */
public class StatesClientImpl implements IStatesClient{
	
	public static final String BASE_URL = "http://services.groupkt.com/state/get/USA";
	public static final String ALL_STATES = "/all";
	public static final String ALABAMA = "/AL";
	public static final String GEORGIA = "/GA";
	

	@Override
	public ResponseEntity<AllStatesResponse> getAllStates() throws ClientProtocolException, HttpException, IOException {
		
		// Set the Accept header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Add the Jackson message converter
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		// Make the HTTP GET request, marshaling the response from JSON to a Response object
		ResponseEntity<AllStatesResponse> responseEntity = restTemplate.exchange(BASE_URL + ALL_STATES, HttpMethod.GET, requestEntity, AllStatesResponse.class);
		return responseEntity;
	}

	@Override
	public ArrayList<SingleStateResponse> getAlabGeorgia() throws ClientProtocolException, HttpException, IOException {
		
		// Set the Accept header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Add the Jackson message converter
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		// Make the HTTP GET request, marshaling the response from JSON to a Response
		// object. Make retrieve the Alabama record
		ResponseEntity<SingleStateResponse> responseEntity = restTemplate.exchange(BASE_URL + ALABAMA, HttpMethod.GET,
				requestEntity, SingleStateResponse.class);

		// Make the HTTP GET request, marshaling the response from JSON to a Response
		// object. Retrieve the Georgia record.
		ResponseEntity<SingleStateResponse> responseEntity2 = restTemplate.exchange(BASE_URL + GEORGIA, HttpMethod.GET,
				requestEntity, SingleStateResponse.class);
		
		//Add Alabama and Georgia to one response.
		ArrayList<SingleStateResponse> alabGeorgia = new ArrayList<>();
		alabGeorgia.add(responseEntity.getBody());
		alabGeorgia.add(responseEntity2.getBody());
		
		return alabGeorgia;
	}

	@Override
	public <T> ResponseEntity<T>  getState(String abbr) throws ClientProtocolException, HttpException, IOException {
		// Set the Accept header
				HttpHeaders requestHeaders = new HttpHeaders();
				requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
				HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

				// Create a new RestTemplate instance
				RestTemplate restTemplate = new RestTemplate();

				// Add the Jackson message converter
				restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

				// Make the HTTP GET request, marshaling the response from JSON to a Response
				// object. Make retrieve the single record
				ResponseEntity<SingleStateResponse> responseEntity = restTemplate.exchange(BASE_URL + "/" + abbr, HttpMethod.GET,
						requestEntity, SingleStateResponse.class);
				
				if(responseEntity.getBody().getRestResponse().getResult() == null) {

					ResponseEntity<AllStatesResponse> responseEntityAll = restTemplate.exchange(BASE_URL + ALL_STATES, HttpMethod.GET, requestEntity, AllStatesResponse.class);
					return (ResponseEntity<T>) responseEntityAll;
				}
				return (ResponseEntity<T>) responseEntity;
	}

}
