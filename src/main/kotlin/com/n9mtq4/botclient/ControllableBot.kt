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
	 * */
	fun move(x: Int, y: Int) {
		
//		check if in bounds
		assertTrue(x in -1..1, "x must be within -1 and 1")
		assertTrue(y in -1..1, "y must be within -1 and 1")
		
//		make sure that the bot can move
		assertTrue(canMove(x, y), "bot tried to make an action without the required action points")
		
		actionPoints -= calcMoveCost(x, y) // client side tracking of action points
		
		turnLog("MOVE $x $y") // add the movement to this turn's actions
		
//		update client copy
		this.x += x
		this.y += y
		
	}
	
	fun canMove(x: Int, y: Int) = actionPoints - calcMoveCost(x, y) > 0
	fun calcMoveCost(x: Int, y: Int) = MOVEMENT_COST
	
	/**
	 * Turns the bot [angle] degrees.
	 * 
	 * @param angle The angle to turn in degrees
	 * */
	fun turn(angle: Int) {
		
//		make sure the angle is in bounds
		assertTrue(angle in -360..360, "angle must be between -360 and 360")
		
//		make sure the bot can turn
		assertTrue(canTurn(angle), "bot tried to turn without the required action points")
		
		actionPoints -= calcTurnCost(angle) // client side tracking of action points
		turnLog("TURN $angle") // add the turn to this turn's actions
		
//		update local copy
		this.angle += angle
		
	}
	
	fun canTurn(angle: Int) = actionPoints - calcTurnCost(angle) > 0
	fun calcTurnCost(angle: Int) = (angle / TURN_COST)
	
	/**
	 * Shoots a projectile from the bot.
	 * Uses the current angle for the shooting
	 * */
	fun shoot() {
		
//		make sure the bot can shoot
		assertTrue(canShoot(), "bot tried to shoot without the required acton points")
		
		actionPoints -= calcShootCost() // client side tracking of action points
		turnLog("SHOOT") // add the shooting to this turn's actions
		
	}
	
	fun canShoot() = actionPoints - SHOOT_COST > 0
	fun calcShootCost() = SHOOT_COST
	
	/**
	 * Adds a command onto this turn's actions
	 * */
	private fun turnLog(msg: String) {
		turnLog.add(msg)
	}
	
}
