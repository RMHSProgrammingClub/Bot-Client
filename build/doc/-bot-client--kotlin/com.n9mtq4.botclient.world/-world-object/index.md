[BotClient-Kotlin](../../index.md) / [com.n9mtq4.botclient.world](../index.md) / [WorldObject](.)


# WorldObject

`interface WorldObject`

Created by will on 11/24/15 at 5:08 PM.


Indicates if an object is in the world
These are added to vision



**Author**
Will "n9Mtq4" Bresnahan



### Properties


| [x](x.md) | `abstract val x: Int` |
| [y](y.md) | `abstract val y: Int` |


### Functions


| [isBlock](is-block.md) | `open fun isBlock(): Boolean`
Returns true if the object is a block.
Will return false if the obstacle is
a wall

 |
| [isBot](is-bot.md) | `open fun isBot(): Boolean`
Returns true if the world object
is a bot

 |
| [isObstacle](is-obstacle.md) | `open fun isObstacle(): Boolean`
Returns true if the world object
is a block (by extension also a wall)

 |
| [isWall](is-wall.md) | `open fun isWall(): Boolean`
Returns true if the object is a wall
Will return false if the obstacle is
a block. (even though a wall is a block)

 |


### Inheritors


| [Block](../-block/index.md) | `data class Block&nbsp;:&nbsp;WorldObject`
Created by will on 11/24/15 at 3:20 PM.

 |
| [Bot](../-bot/index.md) | `data class Bot&nbsp;:&nbsp;WorldObject`
Created by will on 11/24/15 at 5:31 PM.

 |
| [Flag](../-flag/index.md) | `data class Flag&nbsp;:&nbsp;WorldObject`
Created by will on 12/9/15 at 8:53 PM.

 |

