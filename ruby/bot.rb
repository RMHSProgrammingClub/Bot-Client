require_relative 'entity.rb'
require_relative 'constants.rb'

class Bot < Entity
  attr_reader :ap, :vision, :turn_log

  def initialize (x, y, angle, health, team, ap, vision)
    @ap = ap
    @vision = vision
    @turn_log = Array.new

    super(x, y, angle, health, true)
  end

  def move (delta_x, delta_y)
    #Is int
    assert(is_int?(delta_x), "x must be a whole number")
    assert(is_int?(delta_y), "y must be a whole number")
    #Is in bounds
    assert((-1..1).include?(delta_x) , "x must be inbetween -1 and 1")
    assert((-1..1).include?(delta_y), "y must be inbetween -1 and 1")
    
    assert(@ap - $MOVEMENT_COST >= 0, "bot tried to make an action without the required ap")

    @ap -= $MOVEMENT_COST
    @turn_log << "MOVE " + delta_x.to_s + " " + delta_y.to_s
  end

  def turn (angle)
    assert((-360..360).include?(angle), "angle must be between -360 and 360")
    assert(@ap - (angle / $TURN_COST) >= 0, "bot tried to make an action without the required ap")

    @ap -= (angle / $TURN_COST)
    @turn_log << "TURN " + angle.to_s
  end

  def shoot
    assert(@ap - $SHOOT_COST >= 0, "bot tried to make an action without the required ap")

    @ap -= $SHOOT_COST
    @turn_log << "SHOOT"
  end

  def place_block (x, y)
    assert(@ap - $PLACE_COST >= 0, "bot tried to make an action without the required ap")
    #Is int
    assert(is_int?(x), "x must be a whole number")
    assert(is_int?(y), "y must be a whole number")
    #Is in bounds
    assert((-1..1).include?(x) , "x must be inbetween -1 and 1")
    assert((-1..1).include?(y), "y must be inbetween -1 and 1")

    @ap -= $PLACE_COST
    @turn_log << "PLACE " + x.to_s + " " + y.to_s
  end

  def spawn_bot (x, y)
    assert(@ap - $SPAWN_COST >= 0, "bot tried to make an action without the required ap")
    #Is int
    assert(is_int?(x), "x must be a whole number")
    assert(is_int?(y), "y must be a whole number")
    #Is in bounds
    assert((-1..1).include?(x) , "x must be inbetween -1 and 1")
    assert((-1..1).include?(y), "y must be inbetween -1 and 1")

    @ap -= $SPAWN_COST
    @turn_log << "SPAWN " + x.to_s + " " + y.to_s
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