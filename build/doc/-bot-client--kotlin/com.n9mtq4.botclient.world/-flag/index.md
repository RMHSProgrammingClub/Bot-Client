[BotClient-Kotlin](../../index.md) / [com.n9mtq4.botclient.world](../index.md) / [Flag](.)


# Flag

`data class Flag&nbsp;:&nbsp;[WorldObject](../-world-object/index.md)`

Created by will on 12/9/15 at 8:53 PM.

**Author**
Will "n9Mtq4" Bresnahan



### Constructors


| [&lt;init&gt;](-init-.md) | `Flag(x:&nbsp;Int, y:&nbsp;Int, team:&nbsp;Int)`
Created by will on 12/9/15 at 8:53 PM.

 |


### Properties


| [team](team.md) | `val team: Int` |
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

