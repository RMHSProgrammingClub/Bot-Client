package com.n9mtq4.botclient

/**
 * THE MAIN METHOD TO TEST THE API.
 * 
 * Created by will on 11/24/15 at 3:14 PM.
 * 
 * DO NOT USE THIS FILE TO BASE YOUR BOT OFF OF.
 * Look at the bot examples at https://github.com/RMHSProgrammingClub/Bot-Examples
 * This file is only to test if the client can connect to the server.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
fun main(args: Array<String>) {
	
	val game = Game()
	
	try {
		while (true) {
			
			val bot = game() // you can now do this!
			
			bot.move(0, if (game.team == 1) 1 else -1); // move forward
			
//			debug printing
			println(bot.vision.toString())
			println(bot.vision.size)
			println(bot.uid)
			
			game endTurn bot
			
		}
	}catch (e: GameEnded) {
		println("Game ended with status: ${e.data}")
	}
	
}
