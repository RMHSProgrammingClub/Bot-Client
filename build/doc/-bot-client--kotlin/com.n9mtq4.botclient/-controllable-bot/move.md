[BotClient-Kotlin](../../index.md) / [com.n9mtq4.botclient](../index.md) / [ControllableBot](index.md) / [move](.)


# move

`fun move(x:&nbsp;Int, y:&nbsp;Int): [ControllableBot](index.md)`

Moves the bot in the x or y direction
Remember: negative y is up, and positive is down


### Parameters

`x` - the x value to move (-1, 0, or 1)
`y` - the y value to move (-1, 0, or 1)

### Exceptions

`NotEnoughActionPointsException` - if you cant perform the action
**Return**
this bot, (a build method)


