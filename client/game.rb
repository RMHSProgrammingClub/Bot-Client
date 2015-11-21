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

    data = gets.chomp
    data.gsub!("[", "")
    data.gsub!("]", "")
    data.gsub!("\"", "")
    data.gsub!("\\", "")
    data.gsub!(" ", "")

    data = data.split(",")

    @ap = get_ap(data)
    bot = create_bot(data)
  end

  private
  def get_ap (data)
    data[3].to_i
  end

  def create_bot (data)
    vision = Array.new

    i = 5 #Skip other data
    while i < data.length
      type = ""

      if data[i + 3] == "1"
        vision << Bot.new(data[i].to_i, data[i + 1].to_i, data[i + 2].to_i) 
      elsif data[i + 3] == "2" #Wall
        vision << Block.new(data[i].to_i, data[i + 1].to_i, data[i + 2].to_i, false)
      else #Block
        vision << Block.new(data[i].to_i, data[i + 1].to_i, data[i + 2].to_i, true)
      end

      i += 4
    end

    Bot.new(data[0].to_i, data[1].to_i, data[2].to_i, data[3].to_i, vision)
  end
end