package com.n9mtq4.botclient

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ConnectException
import java.net.Socket
import java.net.SocketException

/**
 * Created by will on 11/27/15 at 11:16 PM.
 *
 * Handles all the client to server connections
 * 
 * @property port the port to connect to
 * @param port the port to connect to
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
class ServerConnection(val port: Int) {
	
	private val client: Socket
	private val input: BufferedReader
	private val output: PrintWriter
	
	init {
		println("Connecting to server...")
		try {
			this.client = Socket("localhost", port)
			this.input = BufferedReader(InputStreamReader(client.inputStream))
			this.output = PrintWriter(client.outputStream, true)
			println("Successfully connected to server")
		}catch (e: ConnectException) {
			System.err.println("Is the server running?")
			e.printStackTrace()
			throw e
		}
	}
	
	/**
	 * Reads only one line from the server/
	 *
	 * @return a single line of data
	 * */
	internal fun readLine(): String {
		val str = input.readLine()
		return str
	}
	
	/**
	 * Reads all available data from the server.
	 *
	 * @return The data received (in a string)
	 * */
	@JvmName("read")
	internal fun read(): String {
		
		try {
			var text = input.readLine() // read the first line
			
			if (text.equals("{")) {
				// if we are dealing with a multi-line json string
				
				var command: String
				do {
					command = input.readLine()
					text += command + "\n"
				} while (command != "}") // read all the lines we have
				
				return text
				
			} else {
				return text // if its a normal string return the single line
			}
		}catch (e: SocketException) {
			System.err.println("Is the server running?")
			e.printStackTrace()
			throw e
		}
		/*		var text = ""
				do {
					val command = input.readLine();
					text += command + "\n"
				}while(command != null);
				
				return text.trim()*/
		
	}
	
	/**
	 * writes a string to the output socket with \n
	 * */
	internal fun writeln(msg: String) = write(msg + "\n")
	
	/**
	 * writes a string to the output socket
	 * */
	internal fun write(msg: String) {
		output.print(msg)
		output.flush()
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
		try {
			msg.forEach { output.println(it) }
			output.println("END")
			output.flush()
		}catch (e: SocketException) {
			System.err.println("Is the server running?")
			e.printStackTrace()
			throw e
		}
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
