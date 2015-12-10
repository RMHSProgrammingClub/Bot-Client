package com.n9mtq4.botclient

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

/**
 * Created by will on 11/27/15 at 11:16 PM.
 * 
 * Handles all the client to server connections
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
class ServerConnection(val port: Int) {
	
	internal val client: Socket
	internal val input: BufferedReader
	internal val output: PrintWriter
	
	init {
		println("Connecting to server...")
		this.client = Socket("localhost", port)
		this.input = BufferedReader(InputStreamReader(client.inputStream))
		this.output = PrintWriter(client.outputStream, true)
		println("Successfully connected to server")
	}
	
	/**
	 * Reads only one line from the server/
	 * 
	 * @return a single line of data
	 * */
	internal fun readLine(): String = input.readLine()
	
	/**
	 * Reads all available data from the server.
	 * 
	 * @return The data received (in a string)
	 * */
	internal fun read(): String {
//		return input.readLine()
		
		var text = ""
		do {
			val command = input.readLine();
			text += command + "\n"
		}while(command != null);
		
		return text.trim()
		
	}
	
	/**
	 * Writes data to the server.
	 * 
	 * @param msg the string to send
	 * */
	@Deprecated("Been replaced", ReplaceWith("writeWholeLog"))
	internal fun writeLogLine(msg: String) {
		output.print(msg)
	}
	
	/**
	 * Writes data to the server.
	 * 
	 * @param msg the turn log
	 * */
	internal fun writeWholeLog(msg: List<String>) {
		msg.forEach { output.println(it) }
		output.println("END")
	}
	
	/**
	 * Closes all server connections
	 * */
	internal fun close() {
		input.close()
		output.close()
		client.close()
	}
	
}
