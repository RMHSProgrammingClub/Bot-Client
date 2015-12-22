[BotClient-Kotlin](../../index.md) / [com.n9mtq4.botclient.world](../index.md) / [Block](.)


# Block

`data class Block&nbsp;:&nbsp;[WorldObject](../-world-object/index.md)`

Created by will on 11/24/15 at 3:20 PM.


A Block / Obstacle in the world
Both "Blocks" and "Walls" are instances of this class
You can tell the difference by using
[WorldObject.isBlock](../-world-object/is-block.md) or [WorldObject.isWall](../-world-object/is-wall.md)



**Author**
Will "n9Mtq4" Bresnahan



### Constructors


| [&lt;init&gt;](-init-.md) | `Block(x:&nbsp;Int, y:&nbsp;Int, health:&nbsp;Int, isBreakable:&nbsp;Boolean, type:&nbsp;[BlockType](../-block-type/index.md))`
Created by will on 11/24/15 at 3:20 PM.

 |


### Properties


| [health](health.md) | `val health: Int` |
| [isBreakable](is-breakable.md) | `val isBreakable: Boolean` |
| [type](type.md) | `val type: [BlockType](../-block-type/index.md)` |
| [x](x.md) | `val x: Int` |
| [y](y.md) | `val y: Int` |


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

