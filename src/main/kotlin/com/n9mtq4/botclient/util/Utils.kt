package com.n9mtq4.botclient.util

import java.util.Scanner

/**
 * Created by will on 11/24/15 at 4:40 PM.
 * 
 * A utils class.
 * Contains a method to read input
 * from the server.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */

private val scanner = Scanner(System.`in`)

/**
 * Reads input from the server through
 * StdIn
 * 
 * @return The line that server has sent
 * */
fun readInput(): String {
	return scanner.nextLine().trim()
}
