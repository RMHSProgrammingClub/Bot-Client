$SERVER_VERSION = "v1.0.5-beta" # The version of the server that the client must have compliance with
$SOCKET_PORT = 2000 # The port of the socket server
$MAP_WIDTH = 64 # The width of the map
$MAP_HEIGHT = 128 # The height of the map
$NUM_BLOCKS = 100 # The number of random blocks that are generated
$MAX_TURNS = 100 # The max turns in a map
$MAX_MANA = 100 # The starting mana amount
$TURNS_INVULN = 3 # The number of turns that each bot cannot shoot
$SPAWN_MANA_COST = 50 # The amount of mana that it costs to spawn a new bot
$PLACE_MANA_COST = 20 # The amount of mana that it costs to place a new block
$MANA_PER_TURN = 5 # The amount of mana that each team gains per turn
$BOT_SPACING = 10 # The spacing between each bot when they are spawned
$NUM_BOTS = 5 # The number of bots per team
$FOV = 90 # The angle that the bot can see
$ACTION_POINTS = 10 # The number of action points each bot gets per turn
$BOT_HEALTH = 100 # The starting health of each bot
$BLOCK_HEALTH = 10 # The starting health of each block
$MOVEMENT_COST = 1 # The action point cost of moving a bot
$PLACE_COST = 10 # The action point cost of placing a block
$SPAWN_COST = 10 # The action point cost of spawning a bot
$TURN_COST = 20 # The action point cost of turning a bot
$SHOOT_COST = 6 # The action point cost of shooting
$BOT_HIT_LOSS = 34 # The health that is lost when a bot gets shot
$BLOCK_HIT_LOSS = 10 # The health that is lost when a block gets shot
$BOTS_TO_WIN = 3 # The bots needed to surrond the flag to win
$TO_DEGREES = 180 / Math::PI # Multiplied by radians to get degrees
$TO_RADIANS = Math::PI / 180 # Multiplied by degrees to get radians