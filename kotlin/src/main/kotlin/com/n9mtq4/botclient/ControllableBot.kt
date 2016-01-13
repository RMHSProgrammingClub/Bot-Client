package com.n9mtq4.botclient

import com.n9mtq4.botclient.world.Block
import com.n9mtq4.botclient.world.BlockType
import com.n9mtq4.botclient.world.Bot
import com.n9mtq4.botclient.world.Flag
import com.n9mtq4.botclient.world.WorldObject
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.IOException
import java.util.ArrayList
import kotlin.test.assertTrue

/**
 * Created by will on 11/24/15 at 3:16 PM.
 * 
 * A bot that you can control.
 * These are received when you call [com.n9mtq4.botclient.Game.waitForTurn]
 * Not technically a part of the world.
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
data class ControllableBot(var x: Int, var y: Int, var angle: Int, val health: Int, var actionPoints: Int, var mana: Int, val vision: ArrayList<WorldObject>) {
	
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
	 * @throws NotEnoughActionPointsException if you can't perform the action
	 * */
	@Throws(NotEnoughActionPointsException::class)
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
	 * @throws NotEnoughActionPointsException if you can't perform the action
	 * */
	@Throws(NotEnoughActionPointsException::class)
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
	
	fun calcTurnCost(angle: Int) = Math.abs(Math.ceil((angle / TURN_COST).toDouble())).toInt()
	
	/**
	 * Shoots a projectile from the bot.
	 * Uses the current angle for the shooting
	 * 
	 * @return this bot, (a build method)
	 * @throws NotEnoughActionPointsException if you can't perform the action
	 * */
	@Throws(NotEnoughActionPointsException::class)
	fun shoot(): ControllableBot {
		
//		make sure the bot can shoot
		assertActionPoints(calcShootCost(), actionPoints, "shoot")
		
		actionPoints -= calcShootCost() // client side tracking of action points
		turnLog("SHOOT") // add the shooting to this turn's actions
		
		return this
		
	}
	
	fun calcShootCost() = SHOOT_COST
	
	/**
	 * Spawns a new bot for your team off ([x], [y]) of
	 * your bot's current position.
	 * 
	 * @param x the delta x pos of the new bot
	 * @param y the delta y pos of the new bot
	 * @return this bot, (a build method)
	 * @throws NotEnoughManaPointsException if you can't perform the action
	 * */
	@Throws(NotEnoughActionPointsException::class)
	fun spawnBot(x: Int, y: Int): ControllableBot {
		
//		check if in bounds
		assertTrue(x in -1..1, "x must be within -1 and 1")
		assertTrue(y in -1..1, "y must be within -1 and 1")
		
//		make sure the bot can spawn another bot
//		assertManaPoints(calcSpawnCostAp(x, y), mana, "spawn")
		assertActionManaPoints(calcSpawnCostAp(x, y), actionPoints, calcSpawnCostMana(x, y), mana, "spawn")
		
		actionPoints -= calcSpawnCostAp(x, y) // client side tracking of action points
		mana -= calcSpawnCostMana(x, y)
		turnLog("SPAWN $x $y") // add the spawning to this turn's actions
		
		return this
		
	}
	
	fun calcSpawnCostAp(x: Int, y: Int) = SPAWN_COST
	fun calcSpawnCostMana(x: Int, y: Int) = SPAWN_MANA_COST
	
	/**
	 * Places a new block right at the [x] and [y] off of you.
	 * 
	 * @param x the delta x pos of the block
	 * @param y the delta y pos of the block
	 * @return this bot, (a build method)
	 * @throws NotEnoughManaPointsException if you can't perform the action
	 * */
	@Throws(NotEnoughManaPointsException::class)
	fun placeBlock(x: Int, y: Int): ControllableBot {
		
//		check if in bounds
		assertTrue(x in -1..1, "x must be within -1 and 1")
		assertTrue(y in -1..1, "y must be within -1 and 1")
		
//		make sure the bot can spawn another bot
//		assertManaPoints(calcPlaceBlock(), mana, "place")
		assertActionManaPoints(calcPlaceBlockCostAp(x, y), actionPoints, calcPlaceBlockCostMana(x, y), mana, "place")
		
		
		actionPoints -= calcPlaceBlockCostAp(x, y) // client side tracking of action points
		mana -= calcPlaceBlockCostMana(x, y)
		turnLog("PLACE $x $y") // add the spawning to this turn's actions
		
		return this
		
	}
	
	fun calcPlaceBlockCostAp(x: Int, y: Int) = PLACE_COST
	fun calcPlaceBlockCostMana(x: Int, y: Int) = PLACE_MANA_COST
	
	/**
	 * Adds a command onto this turn's actions
	 * */
	private fun turnLog(msg: String) {
		turnLog.add(msg)
	}
	
	companion object {
		/**
		 * Creates a [ControllableBot] from the data provided from
		 * [Game.readAndMakeBot]
		 *
		 * @param data some pre-parsed data from [Game.readAndMakeBot]
		 * @return A [ControllableBot] created from the given data
		 * */
		@JvmName("buildBot")
		internal fun buildBot(data: String): ControllableBot {
			
//			initialize the json parsing
//			val jsonString = data.joinToString("\n")
			val parser = JSONParser()
			val json: JSONObject = parser.parse(data) as JSONObject
			
//			parse the things for the bot
			val x = (json.getRaw("x") as Long).toInt()
			val y = (json.getRaw("y") as Long).toInt()
			val angle = (json.getRaw("angle") as Long).toInt()
			val health = (json.getRaw("health") as Long).toInt()
			val actionPoints = (json.getRaw("ap") as Long).toInt()
			val mana = (json.getRaw("mana") as Long).toInt()
			
//			start vision parsing
			val visionJson = json.getRaw("vision") as JSONArray
			val vision = ArrayList<WorldObject>()
			visionJson.map { it as JSONObject }.forEach {
				
//				stuff everything has
				val type = it.getRaw("type") as String
				val vx = (it.getRaw("x") as Long).toInt()
				val vy = (it.getRaw("y") as Long).toInt()
				
//				stuff only some things have
				if (type.equals("bot", true)) {
//					bots have a team, angle, and health
					val vteam = (it.getRaw("team") as Long).toInt()
					val vangle = (it.getRaw("angle") as Long).toInt()
					val vhealth = (it.getRaw("health") as Long).toInt()
					vision.add(Bot(vx, vy, vangle, vhealth, vteam))
				}else if (type.equals("block", true)) {
//					blocks have health
					val vhealth = (it.getRaw("health") as Long).toInt()
					vision.add(Block(x, y, vhealth, true, BlockType.BLOCK))
				}else if (type.equals("wall", true)) {
//					walls are generic
					vision.add(Block(x ,y, 100, false, BlockType.WALL))
				}else if (type.equals("flag", true)) {
//					flags have a team
					val vteam = (it.getRaw("team") as Long).toInt()
					vision.add(Flag(x, y, vteam))
				}else {
					throw IOException("Error reading vision data:\n$data")
				}
				
			}
			
			return ControllableBot(x, y, angle, health, actionPoints, mana, vision)
			
		}
		
//		TODO: the following assert points functions can and should be static
		
		/**
		 * Makes sure you can perform the action. Throws
		 * an exception if you can't
		 *
		 * @param need How many action points you need
		 * @param have How many action points you have
		 * @param type The name of the desired action
		 * @throws NotEnoughActionPointsException if you can't perform the action
		 * */
		@Throws(NotEnoughActionPointsException::class)
		private fun assertActionPoints(need: Int, have: Int, type: String) {
			if (have - need < 0) throw NotEnoughActionPointsException(need, have, type)
		}
		
		/**
		 * Makes sure you can perform the action. Throws
		 * an exception if you can't
		 *
		 * @param need How many mana points you need
		 * @param have How many mana points you have
		 * @param type The name of the desired action
		 * @throws NotEnoughManaPointsException if you can't perform the action
		 * */
		@Throws(NotEnoughManaPointsException::class)
		private fun assertManaPoints(need: Int, have: Int, type: String) {
			if (have - need < 0) throw NotEnoughManaPointsException(need, have, type)
		}
		
		/**
		 * Makes sure you can perform the action. Throws
		 * an exception if you can't
		 * 
		 * @param apNeed How many action points you need
		 * @param apHave How many action points you have
		 * @param manaNeed How many mana points you need
		 * @param manaHave How many mana points you have
		 * @param type The name of the desired action
		 * @throws NotEnoughManaPointsException if you can't perform the action with mana
		 * @throws NotEnoughActionPointsException if you can't perform the action with ap
		 * */
		@Throws(NotEnoughActionPointsException::class, NotEnoughManaPointsException::class)
		private fun assertActionManaPoints(apNeed: Int, apHave: Int, manaNeed: Int, manaHave: Int, type: String) {
			assertActionPoints(apNeed, apHave, type)
			assertManaPoints(manaNeed, manaHave, type)
		}
		
	}
	
}
