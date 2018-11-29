/**
 * 
 */
package com.states.client;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.springframework.http.ResponseEntity;

import com.states.pojo.AllStatesResponse;
import com.states.pojo.SingleStateResponse;

/**
 * @author Martin M. Morales
 * 
 *         StatesClient - Interface to perform client operation.
 *
 */
public interface IStatesClient {

	/**
	 * GET's all the states;
	 * 
	 * @throws IOException
	 * @throws HttpException
	 * @throws ClientProtocolException
	 */
	ResponseEntity<AllStatesResponse> getAllStates() throws ClientProtocolException, HttpException, IOException;

	/**
	 * GET's Alabama and Georgia
	 * 
	 * @throws IOException
	 * @throws HttpException
	 * @throws ClientProtocolException
	 */
	ArrayList<SingleStateResponse> getAlabGeorgia() throws ClientProtocolException, HttpException, IOException;
	
	/**
	 * GET's A single State based on abbreviation.
	 * 
	 * @throws IOException
	 * @throws HttpException
	 * @throws ClientProtocolException
	 */
	<T> ResponseEntity<T>  getState(String abbr) throws ClientProtocolException, HttpException, IOException;

}
