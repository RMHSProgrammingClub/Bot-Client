package com.n9mtq4.botclient

import com.n9mtq4.botclient.util.readInput
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter

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
	 * Constructor for the Game
	 * 
	 * Makes sure that the game should
	 * be stated/created and sets your team number.
	 * */
	init {
		
		val command = readLine()
		if (command != "START") {
			throw IOException("Command error: Expected 'START', got '$command'")
		}
		
		team = readInput().toInt()
		
	}
	
	/**
	 * Halts, waiting for input through StdIn
	 * when it receives the Start turn command, it
	 * makes a bot for that turn and returns it
	 * 
	 * @return That turns bot
	 * */
	fun waitForTurn(): ControllableBot {
		
		val command = readInput()
		if (command != "START_TURN")
			throw IOException("Command error: The server sent $command instead of the start command")
		
		return readAndMakeBot()
		
	}
	
	/**
	 * Ends your turn and writes the actions that your bot
	 * has done this turn to a file
	 * */
	fun endTurn(controllableBot: ControllableBot) {
		
		var log = ""
		controllableBot.turnLog.forEach { log += it + "\n" }
		log += "END\n"
		
		val out = PrintWriter(BufferedWriter(FileWriter(team.toString(), true)))
		out.print(log)
		out.close()
		
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
		
		var data = readInput()
		
		data = data.replace("[", "")
		data = data.replace("]", "")
		data = data.replace("\"", "")
		data = data.replace("\\", "")
		data = data.replace(" ", "")
		
		val tokens = data.split(",")
		
		return ControllableBot.buildBot(tokens)
		
	}
	
}
