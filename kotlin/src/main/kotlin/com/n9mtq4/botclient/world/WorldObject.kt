package com.n9mtq4.botclient.world

/**
 * The interface world WorldObjects
 * 
 * Created by will on 11/24/15 at 5:08 PM.
 * 
 * Indicates if an object is in the world
 * These are added to vision
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
interface WorldObject {
	
	/**
	 * The x pos of the WorldObject
	 * */
	val x: Int
	/**
	 * The y pos of the WorldObject
	 * */
	val y: Int
	
	/**
	 * Returns true if the world object
	 * is a bot
	 * */
	fun isBot() = this is Bot
	
	/**
	 * Returns true if the world object
	 * is a block (by extension also a wall)
	 * */
	fun isObstacle() = this is Block
	
	/**
	 * Returns true if the object is a block.
	 * Will return false if the obstacle is
	 * a wall
	 * */
	fun isBlock() = !isWall()
	
	/**
	 * Returns true if the object is a wall
	 * Will return false if the obstacle is
	 * a block. (even though a wall is a block)
	 * */
	fun isWall(): Boolean {
		if (this is Block) {
			return this.type == BlockType.WALL
		}
		return false;
	}
	
}
