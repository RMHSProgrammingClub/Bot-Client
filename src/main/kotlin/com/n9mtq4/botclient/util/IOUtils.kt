package com.n9mtq4.botclient.util

import com.n9mtq4.botclient.Networking

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

val SOCKET_PORT = 2000

private val networking = Networking(SOCKET_PORT)

/**
 * Reads input from the server through
 * a socket on port [SOCKET_PORT]
 * 
 * @return The line that server has sent
 * */
fun read(): String {
	return networking.read()
}

/**
 * Writes output to the server through
 * a socket on port [SOCKET_PORT]
 * 
 * @param msg The string to write to the socket
 * */
fun write(msg: String) {
	networking.write(msg)
}
