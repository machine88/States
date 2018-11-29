/**
 * 
 */
package com.states.rest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.states.client.IStatesClient;
import com.states.client.StatesClientImpl;
import com.states.pojo.AllStatesResponse;
import com.states.pojo.SingleStateResponse;

/**
 * @author Martin Morales
 * rest service to retrieve states
 *
 */
@RestController
@RequestMapping("/StateService")
public class StatesRestService {
	
	IStatesClient client =  new StatesClientImpl();
	

	 @RequestMapping(value = "/AlabamaGeorgia", method = RequestMethod.GET)
	public ArrayList<SingleStateResponse> getAlabGeorgia() throws ClientProtocolException, HttpException, IOException{
		 
		return client.getAlabGeorgia();
	}
	 
	 @RequestMapping(value = "/allStates", method = RequestMethod.GET)
		public ResponseEntity<AllStatesResponse> getAllStates() throws ClientProtocolException, HttpException, IOException{
			 
			return client.getAllStates();
		}
	 
	 @SuppressWarnings("unchecked")
	@RequestMapping(value = "/{abbr}", method = RequestMethod.GET)
		public <T> ResponseEntity<T> getState(@PathVariable(value = "abbr") String abbr) throws ClientProtocolException, HttpException, IOException{
		 
		 ResponseEntity<SingleStateResponse> resp =  client.getState(abbr);
			 
			return (ResponseEntity<T>) resp;
		}


}
