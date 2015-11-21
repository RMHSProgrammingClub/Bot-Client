class Block
  attr_reader :x, :y, :health, :is_breakable

  def initialize (x, y, health, is_breakable)
    @x = x
    @y = y
    @health = health
    @is_breakable = is_breakable
  end
end