package com.n9mtq4.botclient

import java.io.IOException

/**
 * Created by will on 11/24/15 at 3:14 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
class Game {
	
	/**
	 * Your team number.
	 * So far it is either 1 or 2
	 * */
	val team: Int
	
	/**
	 * The connection to the server
	 * */
	private val connection: ServerConnection
	
	/**
	 * Constructor for the Game
	 * 
	 * Makes sure that the game should
	 * be stated/created and sets your team number.
	 * */
	init {
		
		this.connection = ServerConnection(SOCKET_PORT)
		val command = connection.readLine()
		if (!command.contains("START")) { // BotServer-kt support
			throw IOException("Command error: Expected 'START', got '$command'")
		}
		
//		Version checking. Only works with BotServer-kt
		if (command.contains("API")) {
			val version = command.substring("START API ".length).toInt()
			if (version < API_LEVEL) {
				println("ERROR: the server is running a newer version than the client. Please update this API to support the newer server.")
				System.exit(-1)
			}else if (version != API_LEVEL) {
				println("WARNING: the server and the client are running a different version.")
			}
		}
		
		team = connection.readLine().toInt()
		println("Team Number: $team")
		
	}
	
	/**
	 * Halts, waiting for input through StdIn
	 * when it receives the Start turn command, it
	 * makes a bot for that turn and returns it
	 * 
	 * @return That turns bot
	 * */
	fun waitForTurn(): ControllableBot {
		
		val command = connection.read()
		if (command != "START_TURN")
			throw IOException("Command error: The server sent $command instead of the start command")
		
		return readAndMakeBot()
		
	}
	
	/**
	 * Ends your turn and writes the actions that your bot
	 * has done this turn to a file
	 * */
	fun endTurn(controllableBot: ControllableBot) {
		
/*		var log = ""
		controllableBot.turnLog.forEach { log += it + "\n" }
		log += "END\n"
		
		connection.writeLogLine(log)*/
		
		connection.writeWholeLog(controllableBot.turnLog)
		
	}
	
	/**
	 * Prepares the data for building a bot
	 * does some replacing and splits it.
	 * 
	 * The actually parsing is done by
	 * ControllableBot.buildBot
	 * 
	 * @see ControllableBot.buildBot
	 * @return A [ControllableBot] make from the next line in StdIn
	 * */
	private fun readAndMakeBot(): ControllableBot {
		
		var data = connection.read()
		
/*		data = data.replace("[", "")
		data = data.replace("]", "")
		data = data.replace("\"", "")
		data = data.replace("\\", "")
		data = data.replace(" ", "")
		
		val tokens = data.split(",")
		*/
		return ControllableBot.buildBot(data)
		
	}
	
}
