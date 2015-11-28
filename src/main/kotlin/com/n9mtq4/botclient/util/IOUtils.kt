package com.n9mtq4.botclient.util

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

/**
 * Created by will on 11/24/15 at 4:40 PM.
 * 
 * A utils class.
 * Contains a method to read input
 * from the server.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
//private val scanner = Scanner(System.`in`)

private val SOCKET_PORT = 2000

//TODO: these ports need to be based off the team number, or else they wont work
private val socketServer = ServerSocket(SOCKET_PORT)
private val client = socketServer.accept()
private val input = BufferedReader(InputStreamReader(client.inputStream))
private val output = PrintWriter(client.outputStream)

/**
 * Reads input from the server through
 * a socket on port [SOCKET_PORT]
 * 
 * @return The line that server has sent
 * */
fun read(): String {
	return input.readLine().trim()
}

/**
 * Writes output to the server through
 * a socket on port [SOCKET_PORT]
 * 
 * @param msg The string to write to the socket
 * */
fun write(msg: String) {
	output.print(msg)
}
