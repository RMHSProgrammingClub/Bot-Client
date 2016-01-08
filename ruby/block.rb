class Block < Entity

  def initialize (x, y, health, is_destroyable)
    super(x, y, 0, health, is_destroyable)
  end
end