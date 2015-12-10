require 'socket'
require 'json'

require_relative 'bot.rb'
require_relative 'block.rb'
require_relative 'wall.rb'
require_relative 'flag.rb'

class Game
  attr_reader :bot, :ap, :team

  def initialize
    @server_socket = TCPSocket.open("localhost", 2000)
  end

  def start
    command = read_line

    if command != "START"
      abort("The server sent " + command + " instead of the start command!")
    end

    puts "Successfully connected to server"

    @team = read_line.to_i
    puts "Assigned team " + @team.to_s
  end

  def wait_for_turn
    command = read_line
    if command != "START_TURN"
      abort("The server sent " + command + " instead of the turn start command!")
    end

    prepare_turn
  end

  def end_turn (bot)
    log = ""
    for action in bot.turn_log
      log << action + "\n"
    end
    log << "END\n"

    write(log)
  end

  private
  def prepare_turn
    data = read_line.chomp

    data = JSON.parse(data)

    create_bot(data)
  end

  def create_bot (data)
    vision = Array.new

    for entity in data["vision"]
      if entity["type"] == "BOT"
        vision << Bot.new(entity["x"].to_i, entity["y"].to_i, entity["angle"].to_i, entity["team"].to_i, entity["health"].to_i, nil, nil)
      elsif entity["type"] == "WALL"
        vision << Block.new(entity["x"], entity["y"], entity["health"], false)
      elsif entity["type"] == "BLOCK"
        vision << Wall.new(entity["x"], entity["y"])
      elsif entity["type"] == "FLAG"
        vision << Flag.new(entity["x"], entity["y"], entity["team"])
      else
        abort("Server sent unknown type: " + entity["type"])
      end
    end

    Bot.new(data["x"].to_i, data["y"].to_i, data["angle"].to_i, data["health"].to_i, @team, data["ap"].to_i, vision)
  end

  def write (text)
    @server_socket.puts(text)
  end

  def read_line
    @server_socket.gets.chomp
  end
end