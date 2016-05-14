package com.n9mtq4.botclient.world

import com.n9mtq4.botclient.ControllableBot

/**
 * The interface world WorldObjects
 * 
 * Created by will on 11/24/15 at 5:08 PM.
 * 
 * Indicates if an object is in the world.
 * These are added to vision.
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
	 * is a bot.
	 * 
	 * NOTE: this will return false on a [ControllableBot].
	 * */
	fun isBot() = this is Bot
	
	/**
	 * Returns true if this world object is a [ControllableBot].
	 * @deprecated You shouldn't need this method. ControllableBots aren't added in the vision.
	 * */
	@Deprecated("You shouldn't need this method. ControllableBots aren't added in the vision", ReplaceWith("nothing - don't use it"))
	fun isControllableBot() = this is ControllableBot
	
	/**
	 * Returns true if the world object
	 * is a block or a wall. If you want just
	 * a block or just a wall, use
	 * [isBlock] or [isWall], respectively.
	 * 
	 * @see isBlock
	 * @see isWall
	 * */
	fun isObstacle() = this is Block
	
	/**
	 * Returns true if this world object
	 * is a flag, false otherwise
	 * */
	fun isFlag() = this is Flag
	
	/**
	 * Returns true if this world object is a block.
	 * Will return false if it is a bot, flag or WALL.
	 * 
	 * (it is the opposite of [isWall])
	 * */
	fun isBlock() = !isWall()
	
	/**
	 * Returns true if the object is a wall
	 * Will return false if the obstacle is
	 * a block. (even though a wall is a block)
	 * */
	fun isWall(): Boolean {
		if (this is Block) return this.type == BlockType.WALL
		return false
	}
	
}
