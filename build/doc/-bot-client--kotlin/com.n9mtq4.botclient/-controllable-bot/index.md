[BotClient-Kotlin](../../index.md) / [com.n9mtq4.botclient](../index.md) / [ControllableBot](.)


# ControllableBot

`data class ControllableBot`

Created by will on 11/24/15 at 3:16 PM.


A bot that you can control.
These are received when you call [com.n9mtq4.botclient.Game.waitForTurn](../-game/wait-for-turn.md)
Not technically a part of the world.




### Parameters

`x` - The x position
`y` - the y position
`angle` - The angle in degrees
`health` - The health
`actionPoints` - The number of action points the bot has
`vision` - An array of [WorldObject](../../com.n9mtq4.botclient.world/-world-object/index.md)s that you can see
**Author**
Will "n9Mtq4" Bresnahan



### Constructors


| [&lt;init&gt;](-init-.md) | `ControllableBot(x:&nbsp;Int, y:&nbsp;Int, angle:&nbsp;Int, health:&nbsp;Int, actionPoints:&nbsp;Int, mana:&nbsp;Int, vision:&nbsp;ArrayList&lt;[WorldObject](../../com.n9mtq4.botclient.world/-world-object/index.md)&gt;)`
Created by will on 11/24/15 at 3:16 PM.

 |


### Properties


| [actionPoints](action-points.md) | `var actionPoints: Int` |
| [angle](angle.md) | `var angle: Int` |
| [health](health.md) | `val health: Int` |
| [mana](mana.md) | `var mana: Int` |
| [turnLog](turn-log.md) | `val turnLog: ArrayList&lt;String&gt;`
A list of all the actions that
will/did happen this turn

 |
| [vision](vision.md) | `val vision: ArrayList&lt;[WorldObject](../../com.n9mtq4.botclient.world/-world-object/index.md)&gt;` |
| [x](x.md) | `var x: Int` |
| [y](y.md) | `var y: Int` |


### Functions


| [calcMoveCost](calc-move-cost.md) | `fun calcMoveCost(x:&nbsp;Int, y:&nbsp;Int): Int` |
| [calcPlaceBlock](calc-place-block.md) | `fun calcPlaceBlock(): Int` |
| [calcShootCost](calc-shoot-cost.md) | `fun calcShootCost(): Int` |
| [calcSpawnCost](calc-spawn-cost.md) | `fun calcSpawnCost(x:&nbsp;Int, y:&nbsp;Int): Int` |
| [calcTurnCost](calc-turn-cost.md) | `fun calcTurnCost(angle:&nbsp;Int): Int` |
| [move](move.md) | `fun move(x:&nbsp;Int, y:&nbsp;Int): ControllableBot`
Moves the bot in the x or y direction
Remember: negative y is up, and positive is down

 |
| [placeBlock](place-block.md) | `fun placeBlock(x:&nbsp;Int, y:&nbsp;Int): ControllableBot`
Places a new block right at the [x](place-block.md#x) and [y](place-block.md#y) off of you.

 |
| [shoot](shoot.md) | `fun shoot(): ControllableBot`
Shoots a projectile from the bot.
Uses the current angle for the shooting

 |
| [spawnBot](spawn-bot.md) | `fun spawnBot(x:&nbsp;Int, y:&nbsp;Int): ControllableBot`
Spawns a new bot for your team off ([x](spawn-bot.md#x), [y](spawn-bot.md#y)) of
your bots current position.

 |
| [turn](turn.md) | `fun turn(angle:&nbsp;Int): ControllableBot`
Turns the bot [angle](turn.md#angle) degrees.

 |

