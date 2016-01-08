class Entity
  attr_reader :x, :y, :angle, :health, :is_destroyable, :is_destroyed

  def initialize (x, y, angle, health, is_destroyable)
    @x = x
    @y = y
    @angle = angle
    @health = health
    @is_destroyable = is_destroyable
    @is_destroyed = false
  end
end