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
	 * Read data from the server
	 * Halts and waits for data
	 * 
	 * @return The data received (in a string)
	 * */
	internal fun read(): String {
		return input.readLine()
	}
	
	/**
	 * Writes data to the server.
	 * 
	 * @param msg the string to send
	 * */
	internal fun write(msg: String) {
		output.print(msg)
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
