class Bot
  attr_reader :x, :y, :angle, :health, :vision

  def initializer (x, y, angle, health, vision)
    @x = x
    @y = y
    @angle = angle
    @health = health
    @vision
  end
end