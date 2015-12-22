[BotClient-Kotlin](../../index.md) / [com.n9mtq4.botclient.world](../index.md) / [Bot](.)


# Bot

`data class Bot&nbsp;:&nbsp;[WorldObject](../-world-object/index.md)`

Created by will on 11/24/15 at 5:31 PM.


A bot object in the world.
Has x, y, angle, and health




### Parameters

`x` - the x pos
`y` - the y pos
`angle` - the angle of the bot (degrees -360 to 360)
`health` - the health of the bot
`team` - the team number of the bot



### Constructors


| [&lt;init&gt;](-init-.md) | `Bot(x:&nbsp;Int, y:&nbsp;Int, angle:&nbsp;Int, health:&nbsp;Int, team:&nbsp;Int)`
Created by will on 11/24/15 at 5:31 PM.

 |


### Properties


| [angle](angle.md) | `val angle: Int`
the angle of the bot (degrees -360 to 360)

 |
| [health](health.md) | `val health: Int`
the health of the bot

 |
| [team](team.md) | `val team: Int`
the team number of the bot

 |
| [x](x.md) | `val x: Int`
the x pos

 |
| [y](y.md) | `val y: Int`
the y pos

 |


### Inherited Functions


| [isBlock](../-world-object/is-block.md) | `open fun isBlock(): Boolean`
Returns true if the object is a block.
Will return false if the obstacle is
a wall

 |
| [isBot](../-world-object/is-bot.md) | `open fun isBot(): Boolean`
Returns true if the world object
is a bot

 |
| [isObstacle](../-world-object/is-obstacle.md) | `open fun isObstacle(): Boolean`
Returns true if the world object
is a block (by extension also a wall)

 |
| [isWall](../-world-object/is-wall.md) | `open fun isWall(): Boolean`
Returns true if the object is a wall
Will return false if the obstacle is
a block. (even though a wall is a block)

 |

