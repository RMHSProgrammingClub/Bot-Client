package com.n9mtq4.botclient

import java.io.IOException

/*
* 
* NOTICE THAT THIS FILE HAS VERY LONG LINES
* DON'T LOOK AT THE FOLLOWING CODE UNLESS YOU WANT TO GO INSANE
* 
* */

/**
 * 
 * This exception is thrown when you don't have enough action points to do something.
 * 
 * Created by will on 12/4/15 at 3:48 PM.
 * 
 * @param msg the msg
 * @author Will "n9Mtq4" Bresnahan
 */
class NotEnoughActionPointsException private constructor(msg: String) : CantPerformActionException(msg) {
	/**
	 * Generates a message based on [need], [have], and [action]
	 * @param need the ap needed
	 * @param have the ap that you have
	 * @param action the action trying to be performed
	 * */
	constructor(need: Int, have: Int, action: String) : this("Not enough action points to perform action: $action. Need: $need, have: $have, diff:${have - need}!")
}

/**
 * This exception is thrown when you don't have enough mana points to do something.
 * 
 * Created by will on 12/4/15 at 3:48 PM.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
class NotEnoughManaPointsException private constructor(msg: String) : CantPerformActionException(msg) {
	/**
	 * Generates a message based on [need], [have], and [action]
	 * @param need the mana needed
	 * @param have the mana that you have
	 * @param action the action trying to be performed
	 * */
	constructor(need: Int, have: Int, action: String) : this("Not enough mana points to perform action: $action. Need: $need, have: $have, diff:${have - need}!")
}

/**
 * This exception is thrown when you can't perform an action.
 * The superclass for [NotEnoughActionPointsException] and
 * [NotEnoughManaPointsException].
 * 
 * Created by will on 12/21/15 at 8:40 PM.
 * 
 * @param msg the msg
 * @property msg the message
 * @author Will "n9Mtq4" Bresnahan
 */
open class CantPerformActionException protected constructor(val msg: String) : Exception(msg)

/**
 * This exception is thrown when the game is ended
 * 
 * @param data the data of the end turn command
 * @property data the data of the end turn command
 * @author Will "n9Mtq4" Bresnahan
 * */
class GameEnded internal constructor(val data: String) : Exception("Game has ended with data: $data")

/**
 * This exception is thrown when the client gets wrong input from the server
 * 
 * @param msg the message
 * @param expected the expected server input
 * @param actual the actual server input
 * 
 * @author Will "n9Mtq4" Bresnahan
 * */
class ClientNetworkException internal constructor(msg: String, expected: String, actual: String) : IOException("$msg: EXPECTED: \"$expected\", GOT: \"$actual\"")
