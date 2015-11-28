package com.n9mtq4.botclient

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

/**
 * Created by will on 11/27/15 at 11:16 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
class Networking(val port: Int) {
	
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
	
	fun read(): String {
		return input.readLine()
	}
	
	fun write(msg: String) {
		output.print(msg)
	}
	
	fun close() {
		input.close()
		output.close()
		client.close()
	}
	
}
