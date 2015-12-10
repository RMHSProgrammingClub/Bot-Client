require_relative 'entity.rb'

class Flag < Entity
  attr_reader :team_number

  def initialize (x, y, team_number)
    @team_number = team_number
    super(x, y, 0, 0, false)
  end
end