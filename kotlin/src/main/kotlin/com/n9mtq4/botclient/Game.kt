package com.n9mtq4.botclient

/**
 * Created by will on 11/24/15 at 3:14 PM.
 * 
 * An object for the currently running game.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
class Game() {
	
	/**
	 * The version of the server this client is connected to.
	 * 
	 * "ruby" or "kotlin API_LEVEL"
	 * ex: "ruby", "kotlin 1", "kotlin 2"
	 * */
	val serverVersion: String
	
	/**
	 * The connection to the server.
	 * */
	private val connection: ServerConnection
	
	/**
	 * Your team number.
	 * So far it is either 1 or 2
	 * */
	val team: Int
	
	/**
	 * The compliance level that this client is running at
	 * */
	val currentCompliance: String
	
	/**
	 * Constructor for the Game
	 * 
	 * Makes sure that the game should
	 * be stated/created and sets your team number.
	 * */
	init {
		
		val port = System.getProperty(PropertyDictionary.SERVER_PORT)?.toInt() ?: SOCKET_PORT
		this.connection = ServerConnection(port)
		
//		send our compliance level
		this.currentCompliance = System.getProperty(PropertyDictionary.COMPLIANCE_LEVEL) ?: SERVER_VERSION
		if (currentCompliance != SERVER_VERSION) println("[WARNING]: Not using the client's compliance level, forcing the use of: \"$currentCompliance\"")
		connection.writeln(currentCompliance)
		
		val command = connection.readLine()
		if (!command.contains("START")) { // BotServer-kt support
			throw ClientNetworkException("Command error", "START", command)
		}
		
//		Version checking. Only works with BotServer-kt
		if (command.contains("API")) {
			val version = command.substring("START API ".length).toInt()
			this.serverVersion = "kotlin $version"
			if (version < API_LEVEL) {
				System.err.println("[ERROR]: the server is running a newer version than the client. Please update this API to support the newer server.")
				System.exit(-1)
			}else if (version != API_LEVEL) {
				println("[WARNING]: the server and the client are running a different version.")
			}
		}else {
			this.serverVersion = "ruby"
		}
		
		team = connection.readLine().toInt()
		println("Team Number: $team")
		
	}
	
	operator fun invoke() = waitForTurn()
	
	/**
	 * Halts, waiting for input through StdIn
	 * when it receives the Start turn command, it
	 * makes a bot for that turn and returns it
	 * 
	 * @return That turns bot
	 * */
	fun waitForTurn(): ControllableBot {
		
		val command = connection.read()
		
//		TODO: deprecated - as of commit 55df0f6 (above v1.0.6-beta) this will not happen; only for backwards compatibility
		if ("LOOSE" in command || "WIN" in command || "DRAW" in command) throw GameEnded(command)
		
		if (command == "END") {
			val data = connection.read()
			if ("LOOSE" in data || "WIN" in data || "DRAW" in data) throw GameEnded(command)
			else throw ClientNetworkException("Error with game end", "LOOSE || WIN || DRAW", command)
		}
		
		if (command != "START_TURN")
			throw ClientNetworkException("Command Error", "START_TURN", command)
		
		return readAndMakeBot()
		
	}
	
	/**
	 * Ends your turn and writes the actions that your bot
	 * has done this turn to a file
	 * */
	infix fun endTurn(controllableBot: ControllableBot) {
		
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
		return ControllableBot.buildBot(data)
		
	}
	
}
