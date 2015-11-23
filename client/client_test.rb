require_relative 'game.rb'

game = Game.new()
game.start
bot = game.wait_for_turn
