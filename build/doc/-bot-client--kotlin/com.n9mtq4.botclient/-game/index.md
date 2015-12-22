[BotClient-Kotlin](../../index.md) / [com.n9mtq4.botclient](../index.md) / [Game](.)


# Game

`class Game`

Created by will on 11/24/15 at 3:14 PM.


An object for the currently running game.



**Author**
Will "n9Mtq4" Bresnahan



### Constructors


| [&lt;init&gt;](-init-.md) | `Game()`
Created by will on 11/24/15 at 3:14 PM.

 |


### Properties


| [serverVersion](server-version.md) | `val serverVersion: String`
The version of the server this client is connected to.

 |
| [team](team.md) | `val team: Int`
Your team number.
So far it is either 1 or 2

 |


### Functions


| [endTurn](end-turn.md) | `fun endTurn(controllableBot:&nbsp;[ControllableBot](../-controllable-bot/index.md)): Unit`
Ends your turn and writes the actions that your bot
has done this turn to a file

 |
| [waitForTurn](wait-for-turn.md) | `fun waitForTurn(): [ControllableBot](../-controllable-bot/index.md)`
Halts, waiting for input through StdIn
when it receives the Start turn command, it
makes a bot for that turn and returns it

 |

