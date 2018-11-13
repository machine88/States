/**
 * 
 */
package com.states.client;

import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import com.states.pojo.State;

/**
 * @author Martin M. Morales
 * 
 * Utility class to implement the client.
 *
 */
public class ClientUtility {
	
	//method to process the status code. 
	public static HttpResponse executeHttp(HttpResponse execute) throws HttpException {

		HttpResponse response;

		response = execute;
		int statusCode = response.getStatusLine().getStatusCode();

		if (statusCode != HttpStatus.SC_OK) {
			throw new HttpException("Invalid response code: " + statusCode);
		}

		return response;
	}
	
	public static List<State> getAllStatesFromJson(HttpResponse response){
		return null;
	}
}
