package com.n9mtq4.botclient.world

/**
 * Created by will on 12/9/15 at 8:53 PM.
 * 
 * @param x the x pos of the bot
 * @param y the y pos of the bot
 * @param team the team that this flag belongs to
 * 
 * @property x the x pos of the bot
 * @property y the y pos of the bot
 * @property team the team that this flag belongs to
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
data class Flag(override val x: Int, override val y: Int, val team: Int) : WorldObject
