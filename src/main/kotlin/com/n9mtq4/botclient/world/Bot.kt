package com.n9mtq4.botclient.world

/**
 * Created by will on 11/24/15 at 5:31 PM.
 * 
 * A bot object in the world.
 * Has x, y, angle, and health
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
data class Bot(val x: Int, val y: Int, val angle: Int, val health: Int) : WorldObject
