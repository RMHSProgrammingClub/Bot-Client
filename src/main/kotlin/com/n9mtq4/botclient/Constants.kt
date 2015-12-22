package com.n9mtq4.botclient

/**
 * Created by will on 11/24/15 at 3:25 PM.
 * 
 * Contains constants used in the client (and server)
 * These are mostly self-explanatory, but
 * ask Jake if there is a confusing one
 * 
 * @property API_LEVEL the api level of the client
 * @property SOCKET_PORT the port the server is running on
 * @property MAP_WIDTH the width of the map
 * @property MAP_HEIGHT the height of the map
 * @property MAX_TURNS the number of tuns the game will last
 * @property MAX_MANA the maximum amount of mana you can have
 * @property BOT_SPACING how far apart the bots are
 * @property NUM_BOTS how many bots there are to start
 * @property FOV your field of view in degrees
 * @property ACTION_POINTS the number of action points per bot
 * @property BOT_HEALTH the amount of hp the bots have to start
 * @property BLOCK_HEALTH the amount of hp the blocks have to start
 * @property BOT_VISION God knows that this thing does.
 * @property MOVEMENT_COST how much moving costs (action points)
 * @property PLACE_COST how much placing a block costs (mana)
 * @property SPAWN_COST how much spawning another bot costs (mana)
 * @property TURN_COST how much turning costs (~angle / [TURN_COST]) (action points)
 * @property SHOOT_COST how much shooting costs (action points)
 * @property BOT_HIT_LOSS how much damage a bot takes when hit
 * @property BLOCK_HIT_LOSS how much damage a block takes when hit
 * @property BOTS_TO_WIN how many bots need to be arround a flag to win
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
val API_LEVEL = 2

val SOCKET_PORT = 2000
val MAP_WIDTH = 128
val MAP_HEIGHT = 64
val MAX_TURNS = 100
val MAX_MANA = 100
val BOT_SPACING = 10 //TODO: Settle on correct coefficient (preferably scale)
val NUM_BOTS = 5
val FOV = 90
val ACTION_POINTS = 10
val BOT_HEALTH = 100
val BLOCK_HEALTH = 10
val BOT_VISION = 50
val MOVEMENT_COST = 1
val PLACE_COST = 10
val SPAWN_COST = 10
val TURN_COST = 20 // higher is lower
val SHOOT_COST = 6
val BOT_HIT_LOSS = 20
val BLOCK_HIT_LOSS = 10
val BOTS_TO_WIN = 3
