package com.n9mtq4.botclient

/**
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
			
			val bot = game.waitForTurn()
			
			bot.move(0, if (game.team == 1) 1 else -1); // move forward
			
			println(bot.vision.toString())
			println(bot.vision.size)
			
			game.endTurn(bot)
			
		}
	}catch (e: GameEnded) {
		println("Game ended with status: ${e.data}")
	}
	
}
