package com.states.pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Martin M. Morales
 * Wrapper class helps with JSOn upper level Array declaration
 * For single state response
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleStateResponse {
	
	@JsonProperty("RestResponse")
	RestResponse restResponse;	
	
	
	public RestResponse getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}

	public class RestResponse {
		@JsonProperty("messages")
		private ArrayList<String> messages;
		@JsonProperty("result")
		private State result;
		public ArrayList<String> getMessages() {
			return messages;
		}
		public void setMessages(ArrayList<String> messages) {
			this.messages = messages;
		}
		public State getResult() {
			return result;
		}
		public void setResult(State result) {
			this.result = result;
		}
		
		
	}

}
