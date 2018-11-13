/**
 * 
 */
package com.states.client;

import java.util.List;

import com.states.pojo.State;

/**
 * @author Martin M. Morales
 * 
 * StatesClient - Interface to perform client operation.
 *
 */
public interface IStatesClient {
	
	 
	/**
	 * GET's all the states;
	 */
	 List<State> getAllStates();

}
