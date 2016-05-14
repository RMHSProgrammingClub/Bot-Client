@file:JvmName("BotClientConstants")
package com.n9mtq4.botclient

/**
 * Constants for the client and the server
 * 
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
 * @property BOTS_TO_WIN how many bots need to be around a flag to win
 * 
 * @author Will "n9Mtq4" Bresnahan
 */

/**
 * the api level of the client
 * */
const val API_LEVEL = 1

/*
* The following code is copy-pasted from
* https://github.com/RMHSProgrammingClub/Bot-Server/blob/master/server/constants.rb
* with a little find and replace.
* All the same names should work for fast updating with the ruby server
* */

/**
 * The version of the server that the client must have compliance with
 * */
const val SERVER_VERSION = "v1.0.5-beta" // The version of the server that the client must have compliance with
/**
 * the port the server is running on
 * */
const val SOCKET_PORT = 2000 // The port of the socket server
/**
 * The width of the map
 * */
const val MAP_WIDTH = 64 // The width of the map
/**
 * The height of the map
 * */
const val MAP_HEIGHT = 128 // The height of the map
/**
 * The number of random blocks that are generated
 * */
const val NUM_BLOCKS = 100 // The number of random blocks that are generated
/**
 * The max turns in a map
 * Note: this can be overridden by a start param in the server, so don't use it in the client.
 * */
const val MAX_TURNS = 100 // The max turns in a map
/**
 * The starting mana amount
 * */
const val MAX_MANA = 100 // The starting mana amount
/**
 * The number of turns that each bot cannot shoot
 * */
const val TURNS_INVULN = 3 // The number of turns that each bot cannot shoot
/**
 * The amount of mana that it costs to spawn a new bot
 * */
const val SPAWN_MANA_COST = 50 // The amount of mana that it costs to spawn a new bot
/**
 * The amount of mana that it costs to place a new block
 * */
const val PLACE_MANA_COST = 20 // The amount of mana that it costs to place a new block
/**
 * The amount of mana that each team gains per turn
 * */
const val MANA_PER_TURN = 5 // The amount of mana that each team gains per turn
/**
 * The spacing between each bot when they are spawned
 * */
const val BOT_SPACING = 10 // The spacing between each bot when they are spawned
/**
 * The number of bots per team
 * */
const val NUM_BOTS = 5 // The number of bots per team
/**
 * The angle that the bot can see
 * */
const val FOV = 90 // The angle that the bot can see
/**
 * The number of action points each bot gets per turn
 * */
const val ACTION_POINTS = 10 // The number of action points each bot gets per turn
/**
 * The starting health of each bot
 * */
const val BOT_HEALTH = 100 // The starting health of each bot
/**
 * The starting health of each block
 * */
const val BLOCK_HEALTH = 10 // The starting health of each block
/**
 * The action point cost of moving a bot
 * */
const val MOVEMENT_COST = 1 // The action point cost of moving a bot
/**
 * The action point cost of placing a block
 * */
const val PLACE_COST = 10 // The action point cost of placing a block
/**
 * The action point cost of spawning a bot
 * */
const val SPAWN_COST = 10 // The action point cost of spawning a bot
/**
 * The action point cost of turning a bot
 * Higher is better. Calculated with cost = angle / TURN_COST
 * */
const val TURN_COST = 20 // The action point cost of turning a bot
/**
 * The action point cost of shooting
 * */
const val SHOOT_COST = 6 // The action point cost of shooting
/**
 * The health that is lost when a bot gets shot
 * */
const val BOT_HIT_LOSS = 34 // The health that is lost when a bot gets shot
/**
 * The health that is lost when a block gets shot
 * */
const val BLOCK_HIT_LOSS = 10 // The health that is lost when a block gets shot
/**
 * The bots needed to surround the flag to win
 * */
const val BOTS_TO_WIN = 3 // The bots needed to surround the flag to win
/**
 * Multiplied by radians to get degrees
 * */
const val TO_DEGREES = 180 / Math.PI // Multiplied by radians to get degrees
/**
 * Multiplied by degrees to get radians
 * */
const val TO_RADIANS = Math.PI / 180 // Multiplied by degrees to get radians
