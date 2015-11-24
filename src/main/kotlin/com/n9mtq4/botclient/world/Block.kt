package com.n9mtq4.botclient.world

/**
 * Created by will on 11/24/15 at 3:20 PM.
 * 
 * A Block / Obstacle in the world
 * Both "Blocks" and "Walls" are instances of this class
 * You can tell the difference by using
 * [WorldObject.isBlock] or [WorldObject.isWall]
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
data class Block(val x: Int, val y: Int, val health: Int, val isBreakable: Boolean, val type: BlockType) :
		WorldObject
