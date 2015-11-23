require_relative 'bot.rb'
require_relative 'block.rb'

class Game
  attr_reader :bot, :ap

  def start
    command = gets.chomp

    if command != "START"
      abort("The server sent " + command + " instead of the start command!")
    end

    @team = gets.chomp.to_i
  end

  def wait_for_turn
    command = gets.chomp
    if command != "START_TURN"
      abort("The server sent " + command + " instead of the turn start command!")
    end

    prepare_turn
  end

  def end_turn (bot)
    for action in bot.turn_log
      puts action
    end

    puts "END"
  end

  private
  def prepare_turn
    data = gets.chomp
    data.gsub!("[", "")
    data.gsub!("]", "")
    data.gsub!("\"", "")
    data.gsub!("\\", "")
    data.gsub!(" ", "")

    data = data.split(",")

    create_bot(data)
  end

  def create_bot (data)
    vision = Array.new

    i = 5 #Skip other data
    while i < data.length
      type = ""

      if data[i + 4] == "1"
        vision << Bot.new(data[i].to_i, data[i + 1].to_i, data[i + 2].to_i) 
      elsif data[i + 4] == "2" #Wall
        vision << Block.new(data[i].to_i, data[i + 1].to_i, data[i + 2].to_i, false)
      else #Block
        vision << Block.new(data[i].to_i, data[i + 1].to_i, data[i + 2].to_i, true)
      end

      i += 5
    end

    Bot.new(data[0].to_i, data[1].to_i, data[3].to_i, data[2].to_i, data[4].to_i, vision)
  end
end