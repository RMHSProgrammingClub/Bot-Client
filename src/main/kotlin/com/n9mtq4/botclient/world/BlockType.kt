package com.n9mtq4.botclient.world

/**
 * Created by will on 11/24/15 at 5:06 PM.
 * 
 * Stores the types of Obstacles/Blocks there are
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
enum class BlockType {
	
	/**
	 * A placed block, can be destroyed and has health
	 * */
	BLOCK, 
	
	/**
	 * The side of the map, cannot be destroyed and
	 * doesn't have health
	 * */
	WALL;
	
}
