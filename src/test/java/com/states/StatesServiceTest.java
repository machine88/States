package com.states;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.states.client.StatesClientImpl;
import com.states.pojo.AllStatesResponse;
import com.states.pojo.SingleStateResponse;

public class StatesServiceTest {
	private StatesClientImpl clientImpl = new StatesClientImpl();
	
	@Test
	public void getAllStatesTest() throws ClientProtocolException, HttpException, IOException {

		ResponseEntity<AllStatesResponse> states = clientImpl.getAllStates();
		assertTrue(states.getBody().getResponse().getResult() != null);
		assertTrue(states.getBody().getResponse().getResult().size() == 55);

	}

	@Test
	public void getAlabadnGeorgiaTest() throws ClientProtocolException, HttpException, IOException {

		ArrayList<SingleStateResponse> states = clientImpl.getAlabGeorgia();
		assertTrue(states.get(0).getRestResponse().getResult().getName().equals("Alabama"));
		assertTrue(states.get(1).getRestResponse().getResult().getName().equals("Georgia"));
	}

	@Test
	public void getStateTest() throws ClientProtocolException, HttpException, IOException {
		String abbr = "/TX";

		ResponseEntity<SingleStateResponse> state = clientImpl.getState(abbr);
		assertTrue(state.getBody().getRestResponse().getResult().getAbbr().equals("TX"));

	}
	
	// Case if user sends the wrong abbreviation then return all the states
	@Test
	public void getStateTestAll() throws ClientProtocolException, HttpException, IOException {
		String abbr = "/Ti";

		ResponseEntity<AllStatesResponse> states = clientImpl.getState(abbr);
		assertTrue(states.getBody().getResponse().getResult().size() == 55);

	}
	
}
