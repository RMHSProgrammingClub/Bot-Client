package com.n9mtq4.botclient.world

/**
 * A Bot in the world.
 * 
 * Created by will on 11/24/15 at 5:31 PM.
 * 
 * A bot object in the world.
 * Has x, y, angle, and health
 * 
 * @param x the x pos
 * @param y the y pos
 * @param angle the angle of the bot (degrees -360 to 360)
 * @param health the health of the bot
 * @param team the team number of the bot
 * @property x the x pos
 * @property y the y pos
 * @property angle the angle of the bot (degrees -360 to 360)
 * @property health the health of the bot
 * @property team the team number of the bot
 * @author Will "n9Mtq4" Bresnahan
 */
data class Bot(override val x: Int, override val y: Int, val angle: Int, val health: Int, val team: Int) : WorldObject
