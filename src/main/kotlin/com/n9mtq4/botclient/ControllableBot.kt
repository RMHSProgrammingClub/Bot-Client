package com.n9mtq4.botclient

import com.n9mtq4.botclient.world.Block
import com.n9mtq4.botclient.world.BlockType
import com.n9mtq4.botclient.world.Bot
import com.n9mtq4.botclient.world.WorldObject
import java.io.IOException
import java.util.ArrayList
import kotlin.test.assertTrue

/**
 * Created by will on 11/24/15 at 3:16 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 * 
 * @param x The x position
 * @param y the y position
 * @param angle The angle in degrees
 * @param health The health
 * @param actionPoints The number of action points the bot has
 * @param vision An array of [WorldObject]s that you can see
 */
data class ControllableBot(var x: Int, var y: Int, var angle: Int, val health: Int, var actionPoints: Int, val vision: ArrayList<WorldObject>) {
	
	companion object {
		/**
		 * Creates a [ControllableBot] from the data provided from
		 * [Game.readAndMakeBot]
		 * 
		 * @param data some pre-parsed data from [Game.readAndMakeBot]
		 * @return A [ControllableBot] created from the given data
		 * */
		internal fun buildBot(data: List<String>): ControllableBot {
			
			val vision = ArrayList<WorldObject>()
			var i = 5 // skip first data set - the bot
			while (i < data.size) {
				
//				add different things to vision
				vision.add(when (data[i + 4]) {
//					god knows what these arguments are (ps: jake is god)
//					bot on team 1
					"1" -> Bot(data[i].toInt(), data[i + 1].toInt(), data[i + 2].toInt(), data[i + 3].toInt(), 1)
//					bot on team 2
					"2" -> Bot(data[i].toInt(), data[i + 1].toInt(), data[i + 2].toInt(), data[i + 3].toInt(), 2)
//					a wall
					"3" -> Block(data[i].toInt(), data[i + 1].toInt(), data[i + 2].toInt(), false, BlockType.WALL)
//					a block
					"4" -> Block(data[i].toInt(), data[i + 1].toInt(), data[i + 2].toInt(), true, BlockType.BLOCK)
					else -> throw IOException("Error reading vision data from socket")
				})
				
				i += 5 // next!
				
			}
			
//			return a ControllableBot with the x, y, angle, health, and newly created vision
			return ControllableBot(data[0].toInt(), data[1].toInt(), data[3].toInt(), data[2].toInt(), data[4].toInt(), vision)
			
		}
		
		/**
		 * Makes sure you can perform the action. Throws
		 * an exception if you can't
		 * 
		 * @param need How many action points you need
		 * @param have How many action points you have
		 * @param type The name of the desired action
		 * @throws CantPerformActionException if you can't perform the action
		 * */
		@Throws(CantPerformActionException::class)
		private fun assertActionPoints(need: Int, have: Int, type: String) {
			if (have - need < 0) throw CantPerformActionException(need, have, type)
		}
	}
	
	/**
	 * A list of all the actions that
	 * will/did happen this turn
	 * */
	val turnLog: ArrayList<String>
	
	/**
	 * Constructor for [ControllableBot]
	 * All it does is creates a blank [ArrayList]
	 * for the turn actions
	 * */
	init {
		this.turnLog = arrayListOf()
	}
	
	/**
	 * Moves the bot in the x or y direction
	 * Remember: negative y is up, and positive is down!
	 * 
	 * @param x the x value to move (-1, 0, or 1)
	 * @param y the y value to move (-1, 0, or 1)
	 * @return this bot, (a build method)
	 * @throws CantPerformActionException if you can't perform the action
	 * */
	@Throws(CantPerformActionException::class)
	fun move(x: Int, y: Int): ControllableBot {
		
//		check if in bounds
		assertTrue(x in -1..1, "x must be within -1 and 1")
		assertTrue(y in -1..1, "y must be within -1 and 1")
		
//		make sure that the bot can move
		assertActionPoints(calcMoveCost(x, y), actionPoints, "move")
		
		actionPoints -= calcMoveCost(x, y) // client side tracking of action points
		
		turnLog("MOVE $x $y") // add the movement to this turn's actions
		
//		update client copy
		this.x += x
		this.y += y
		
		return this
		
	}
	
	fun calcMoveCost(x: Int, y: Int) = MOVEMENT_COST
	
	/**
	 * Turns the bot [angle] degrees.
	 * 
	 * @param angle The angle to turn in degrees
	 * @return this bot, (a build method)
	 * @throws CantPerformActionException if you can't perform the action
	 * */
	@Throws(CantPerformActionException::class)
	fun turn(angle: Int): ControllableBot {
		
//		make sure the angle is in bounds
		assertTrue(angle in -360..360, "angle must be between -360 and 360")
		
//		make sure the bot can turn
		assertActionPoints(calcTurnCost(angle), actionPoints, "turn")
		
		actionPoints -= calcTurnCost(angle) // client side tracking of action points
		turnLog("TURN $angle") // add the turn to this turn's actions
		
//		update local copy
		this.angle += angle
		
		return this
		
	}
	
	fun calcTurnCost(angle: Int) = (angle / TURN_COST)
	
	/**
	 * Shoots a projectile from the bot.
	 * Uses the current angle for the shooting
	 * 
	 * @return this bot, (a build method)
	 * @throws CantPerformActionException if you can't perform the action
	 * */
	@Throws(CantPerformActionException::class)
	fun shoot(): ControllableBot {
		
//		make sure the bot can shoot
		assertActionPoints(calcShootCost(), actionPoints, "shoot")
		
		actionPoints -= calcShootCost() // client side tracking of action points
		turnLog("SHOOT") // add the shooting to this turn's actions
		
		return this
		
	}
	
	fun calcShootCost() = SHOOT_COST
	
	/**
	 * Spawns a new bot for your team on the map near the middle of the field
	 * 
	 * @return this bot, (a build method)
	 * @throws CantPerformActionException if you can't perform the action
	 * */
	@Throws(CantPerformActionException::class)
	fun spawnBot(): ControllableBot {
		
//		make sure the bot can spawn another bot
		assertActionPoints(calcSpawnCost(), actionPoints, "spawn")
		
		actionPoints -= calcSpawnCost() // client side tracking of action points
		turnLog("SPAWN") // add the spawning to this turn's actions
		
		return this
		
	}
	
	fun calcSpawnCost() = SPAWN_COST
	
	/**
	 * Places a new block right infront of you
	 * */
	@Throws(CantPerformActionException::class)
	fun placeBlock(x: Int, y: Int): ControllableBot {
		
//		check if in bounds
		assertTrue(x in -1..1, "x must be within -1 and 1")
		assertTrue(y in -1..1, "y must be within -1 and 1")
		
//		make sure the bot can spawn another bot
		assertActionPoints(calcPlaceBlock(), actionPoints, "place")
		
		actionPoints -= calcPlaceBlock() // client side tracking of action points
		turnLog("PLACE $x $y") // add the spawning to this turn's actions
		
		return this
		
	}
	
	fun calcPlaceBlock() = PLACE_COST
	
	/**
	 * Adds a command onto this turn's actions
	 * */
	private fun turnLog(msg: String) {
		turnLog.add(msg)
	}
	
}
