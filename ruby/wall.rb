require_relative 'entity.rb'

class Wall < Entity

  def initialize (x, y)
    super(x, y, 0, 0, false)
  end
end