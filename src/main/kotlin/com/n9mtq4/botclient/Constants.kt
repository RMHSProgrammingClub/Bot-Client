package com.n9mtq4.botclient

/**
 * Created by will on 11/24/15 at 3:25 PM.
 * 
 * Contains constants used in the client (and server)
 * These are mostly self-explanatory, but
 * ask Jake if there is a confusing one
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
val API_LEVEL = 1

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
