/**
 * 
 */
package com.states.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Martin M. Morales
 * Wrapper class helps with JSOn upper level Array declaration
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllStatesResponse  {

	
	@JsonProperty("RestResponse")
    RestResponse response;
	public RestResponse getResponse() {
		return response;
	}
	public void setResponse(RestResponse response) {
		this.response = response;
	}
	public class RestResponse {
		@JsonProperty("messages")
		private ArrayList<String> messages;
		@JsonProperty("result")
		private ArrayList<State> result;

		public List<String> getMessages() {
			return messages;
		}

		public void setMessages(ArrayList<String> messages) {
			this.messages = messages;
		}

		public List<State> getResult() {
			return result;
		}

		public void setResult(ArrayList<State> result) {
			this.result = result;
		}

	}
	
	
}
    
	


