require_relative 'constants.rb'

class Bot
  attr_reader :x, :y, :angle, :health, :ap, :vision, :turn_log

  def initialize (x, y, angle, health, ap, vision)
    @x = x
    @y = y
    @angle = angle
    @health = health
    @ap = ap
    @vision = vision
    @turn_log = Array.new
  end

  def move (x, y)
    #Is int
    assert(is_int?(x), "x must be a whole number")
    assert(is_int?(y), "y must be a whole number")
    #Is in bounds
    assert((-1..1).include?(x) , "x must be inbetween -1 and 1")
    assert((-1..1).include?(y), "y must be inbetween -1 and 1")
    
    assert(@ap - $MOVEMENT_COST > 0, "bot tried to make an action without the required ap")

    @ap -= $MOVEMENT_COST
    @turn_log << "MOVE " + x.to_s + " " + y.to_s
  end

  def turn (angle)
    assert((-360..360).include?(angle), "angle must be between -360 and 360")
    assert(@ap - (angle / $TURN_COST) > 0, "bot tried to make an action without the required ap")

    @ap -= (angle / $TURN_COST)
    @turn_log << "TURN " + angle.to_s
  end

  def shoot
    assert(@ap - $SHOOT_COST > 0, "bot tried to make an action without the required ap")

    @ap -= $SHOOT_COST
    @turn_log << "SHOOT"
  end

  private
  def assert(assertion, abort_string)
    if !assertion
      abort(abort_string)
    end
  end

  # http://stackoverflow.com/questions/5661466/test-if-string-is-a-number-in-ruby-on-rails
  def is_int?(object)
  true if Float(object) rescue false
end
end