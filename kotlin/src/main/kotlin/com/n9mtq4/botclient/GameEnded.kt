package com.n9mtq4.botclient

/**
 * Created by will on 1/12/16 at 2:35 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
class GameEnded(val data: String) : Exception("Game has ended with data: $data")
