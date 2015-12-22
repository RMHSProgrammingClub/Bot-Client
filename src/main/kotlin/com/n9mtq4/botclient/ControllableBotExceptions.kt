package com.n9mtq4.botclient

/**
 * Created by will on 12/4/15 at 3:48 PM.
 * 
 * This exception is thrown when you don't have enough action points to
 * do something.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
class NotEnoughActionPointsException(msg: String) : CantPerformActionException(msg) {
	
	constructor(need: Int, have: Int, action: String) : this("Not enough action points to perform action: $action. Need: $need, have: $have, diff:${have - need}!")
	
}

/**
 * Created by will on 12/4/15 at 3:48 PM.
 *
 * This exception is thrown when you don't have enough mana points to
 * do something.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
class NotEnoughManaPointsException(msg: String) : CantPerformActionException(msg) {
	
	constructor(need: Int, have: Int, action: String) : this("Not enough mana points to perform action: $action. Need: $need, have: $have, diff:${have - need}!")
	
}

/**
 * Created by will on 12/21/15 at 8:40 PM.
 *
 * This exception is thrown when you can't perform an action.
 * The superclass for [NotEnoughActionPointsException] and
 * [NotEnoughManaPointsException].
 *
 * @author Will "n9Mtq4" Bresnahan
 */
open class CantPerformActionException(val msg: String) : Exception(msg)
