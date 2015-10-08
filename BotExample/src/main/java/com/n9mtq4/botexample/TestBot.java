package com.n9mtq4.botexample;

import github.rmhsprogrammingclub.botapi.Bot;
import github.rmhsprogrammingclub.botapi.MyBotCode;

/**
 * Created by will on 10/6/15 at 6:11 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class TestBot {
	
	@MyBotCode("Example Bot")
	public static void tick(Bot bot, int workAround1, int workAround2) {
		
		System.out.println("Called");
		
	}
	
}
