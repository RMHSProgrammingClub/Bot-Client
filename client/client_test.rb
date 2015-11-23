require_relative 'game.rb'

game = Game.new()
game.start

#while true
  bot = game.wait_for_turn
  bot.move(0, 1)
  bot.move(1, 0)
  bot.move(0, -1)
  bot.move(-1, 0)
  game.end_turn(bot)
#end