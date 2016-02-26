package com.n9mtq4.botclient.world

/**
 * A Block / Obstacle in the world
 * Both "Blocks" and "Walls" are instances of this class
 * You can tell the difference by using
 * [WorldObject.isBlock] or [WorldObject.isWall]
 * 
 * Created by will on 11/24/15 at 3:20 PM.
 * 
 * @param x the x pos of the block
 * @param y the y pos of the block
 * @param health the health of the bot
 * @param isBreakable if the block is breakable
 * @param type what type of block this block is
 * 
 * @property x the x pos of the block
 * @property y the y pos of the block
 * @property health the health of the bot
 * @property isBreakable if the block is breakable
 * @property type what type of block this block is
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
data class Block(override val x: Int, override val y: Int, val health: Int, val isBreakable: Boolean, val type: BlockType) :
		WorldObject
