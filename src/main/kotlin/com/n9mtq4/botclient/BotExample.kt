package com.n9mtq4.botclient

/**
 * Created by will on 11/24/15 at 3:14 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
fun main(args: Array<String>) {
	
	val game = Game()
	
	while (true) {
		
		val bot = game.waitForTurn()
		
//		TODO: add your bot ai code here
		bot.move(0, 1)
		bot.move(1, 0)
		bot.move(0, -1)
		bot.move(-1, 0)
		
		game.endTurn(bot)
		
	}
	
}
