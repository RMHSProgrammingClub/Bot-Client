require_relative 'constants.rb'

class Bot
  attr_reader :x, :y, :angle, :health, :ap, :vision

  def initialize (x, y, angle, health, ap, vision)
    @x = x
    @y = y
    @angle = angle
    @health = health
    @ap = ap
    @vision = vision
    @turn = Array.new
  end

  def move (x, y)
    #Is int
    assert(x % 1 != 0)
    assert(y % 1 != 0)
    #Is in bounds
    assert(x === (-1..1))
    assert(y === (-1..1))
    
    assert(@ap - $MOVEMENT_COST > 0)

    @ap -= $MOVEMENT_COST
    @turn << "MOVE " + x + " " + y
  end

  def turn (angle)
    assert(angle === (-360..360))
    assert(@ap - (angle / $TURN_COST) > 0)

    @ap -= (angle / $TURN_COST)
    @turn << "TURN " + angle
  end

  def shoot
    assert(@ap - $SHOOT_COST > 0)

    @ap -= $SHOOT_COST
    @turn << "SHOOT"
  end
end