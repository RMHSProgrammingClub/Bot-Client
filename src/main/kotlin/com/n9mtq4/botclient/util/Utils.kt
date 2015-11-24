package com.n9mtq4.botclient.util

/**
 * Created by will on 11/24/15 at 4:40 PM.
 * 
 * A utils class.
 * Contains an extension for string that 
 * corresponds to Ruby's chomp
 * and a method to read input
 * from the server.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */

/**
 * Reads input from the server through
 * StdIn
 * 
 * @return The line that server has sent
 * */
fun readInput(): String {
	return ""
}

/**
 * Takes of the last character of a string.
 * 
 * @return The string sans the last character
 * */
fun String.chomp(): String {
	return this[0, this.length - 1] as String
}
